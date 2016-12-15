package fr.inria.diverse.objectalgebragenerator.popup.actions

import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.xbase.lib.Functions.Function1

class Node<T> {
	val List<Node<T>> childen = newArrayList()

	val T value

	var Node<T> parent

	new(T t) {
		this.value = t
	}

	def boolean hasChilden() {
		!childen.empty
	}

	def isRoot() {
		this.parent == null
	}

	def addChild(Node<T> t) {
		childen.add(t)
		t.parent = this
	}

	def List<T> toList() {
		val ret = newArrayList()
		ret.addAll(childen.map[toList].flatten)
		ret.add(value)
		ret
	}
}

class GenerateAlgebra {

	def Node<EClass> addChildren(EClass e, List<EClass> allElems) {
		val ret = new Node(e)
		val subtypes = allElems.filter[f|f.ESuperTypes.contains(e)]
		subtypes.map(f|addChildren(f, allElems)).forEach[x|ret.addChild(x)]
		ret
	}

	def String process(EObject eObject) {
		val package = eObject as EPackage

		val allEClasses = eObject.eAllContents.filter[e|e instanceof EClass].map[e|e as EClass].toList.sortBy[e|e.name]
		val allRootEClasses = allEClasses.filter [ e |
			(e as EClass).ESuperTypes.size == 0
		]

		val Map<Character, EClass> rootEClassesMap = allRootEClasses.toMap(new Function1<EClass, Character>() {

			val char x = 'A'
			var cptr = 0

			override apply(EClass t) {

				// FIXME : wont work after 26 abstract types...
				val char ret = (x + (cptr++)) as char
				return ret
			}

		})

		val Map<Character, Node<EClass>> tree = rootEClassesMap.mapValues[e|addChildren(e, allEClasses)]

		tree.entrySet.forEach[e|println('''«e.key» «e.value.toList»''')]

		'''
		package «package.name»;
		
		public interface «package.name.toFirstUpper»Algebra<«FOR x : rootEClassesMap.keySet SEPARATOR ', '»«x»«ENDFOR»> {
			
			«FOR eClass : allEClasses»
				«IF !eClass.isAbstract»
					« rootEClassesMap.getReverse(eClass.findRootParent)» «eClass.name.toFirstLower»(final «eClass.name» «eClass.name.toFirstLower»);
					
				«ENDIF»				
			«ENDFOR»
			«FOR abstractTypes : rootEClassesMap.entrySet SEPARATOR '\n'»
				public default «abstractTypes.key» $(final «abstractTypes.value.name» «abstractTypes.value.name.toFirstLower») {
					final «abstractTypes.key» ret;
					«FOR type:tree.get(abstractTypes.key).toList.filter[e|!e.isAbstract] BEFORE 'if' SEPARATOR 'else if' AFTER ''» («abstractTypes.value.name.toFirstLower» instanceof «type.name») {
						ret = this.«type.name.toFirstLower»((«type.name») «abstractTypes.value.name.toFirstLower»);
					} «ENDFOR»else {
						throw new RuntimeException("Unknow «abstractTypes.value.name» " + «abstractTypes.value.name.toFirstLower»);
					}
					return ret;
				}
			«ENDFOR»
		}'''
	}

	def static EClass findRootParent(EClass s) {

		// FIXME : we are not dealing with model reuse for now.
		if(s.ESuperTypes.size == 0) s else findRootParent(s.ESuperTypes.head)
	}

	def static <K, V> K getReverse(Map<K, V> map, V value) {
		map.filter[p1, p2|p2.equals(value)].keySet.head
	}
}
