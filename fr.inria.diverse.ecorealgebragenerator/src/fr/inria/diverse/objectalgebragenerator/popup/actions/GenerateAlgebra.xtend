package fr.inria.diverse.objectalgebragenerator.popup.actions

import java.util.Collection
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature.Setting
import org.eclipse.emf.ecore.impl.BasicEObjectImpl
import org.eclipse.emf.ecore.util.EcoreUtil
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
		subtypes.filter[x|!x.isRoot].map[f|addChildren(f, allElems)].forEach[x|ret.addChild(x)]
		ret
	}

	def String process(EObject eObject) {
		val package = eObject as EPackage

		val allEClasses = eObject.eAllContents.filter[e|e instanceof EClass].map[e|e as EClass].toList.sortBy[e|e.name]
		val allRootEClasses = eObject.eAllContents.filter[e|e instanceof EClass].map[e|e as EClass].map [ e |
			e.findRootParent
		].toSet

		val allClassesToImport = newHashSet()
		allClassesToImport.addAll(allEClasses)
		allClassesToImport.addAll(allRootEClasses)

		val Map<Character, EClass> rootEClassesMapA = allRootEClasses.toMap(new Function1<EClass, Character>() {

			val char x = 'A'
			var cptr = 0

			override apply(EClass t) {

				// FIXME : wont work after 26 abstract types...
				val char ret = (x + (cptr++)) as char
				return ret
			}

		})

		val Map<Character, Iterable<EClass>> tree = rootEClassesMapA.mapValues [ e |
			addChildren(e, allEClasses).toList.filter[b|!b.isAbstract] // we only keep the concrete classes of hierarchies
		].filter[p1, p2|!p2.empty] // and do not keep parts of the hierarchy with only abstract classes
		val rootEClassesMap = rootEClassesMapA.filter[p1, p2|tree.keySet.exists[z|p1.equals(z)]]

//		println('''
//			# Cross references
//			«FOR eRef : package.eCrossReferences.map[e|e as EFactory]»
//				- «eRef.EPackage.name»
//			«ENDFOR»
//		''')
//		println('''
//			# Root Eclasses
//			«FOR r : allRootEClasses»
//				- «r.name»
//			«ENDFOR»
//		''')

//		println('''
//			# All EClasses
//			«FOR eClass : allEClasses»
//				- «eClass.name»
//			«ENDFOR»
//		''')

//		println('''
//			# First representation status
//			«FOR e : rootEClassesMapA.entrySet»
//				- «e.key» = «e.value.name»
//			«ENDFOR»
//		''')

//		println('''
//			# Full tree
//			«FOR key : tree.keySet»
//				- «key»
//				«FOR value:tree.get(key)»
//					«"  "»- «value.name»
//				«ENDFOR»
//			«ENDFOR»
//		''')
//		println(rootEClassesMapA.keySet)
//		println(tree.keySet)
//		println(rootEClassesMap.keySet)

//		val Map<Character, Map<EObject, Collection<Setting>>> lstExternalRef = rootEClassesMapA.mapValues[e|EcoreUtil.ExternalCrossReferencer.find(e)]

//		println('''
//		External roots :
//		«FOR ext : lstExternalRef.entrySet»
//			- «ext.key»
//			«FOR abcd:ext.value.entrySet»
//				«"  "»- «abcd.key»: 
//				«FOR tmp:abcd.value»
//				«"    "»- «(tmp as Setting)»
//				«ENDFOR»
//			«ENDFOR»
//		«ENDFOR»
//		''')

		'''
		package «package.name».algebra;
		
		«FOR imported : allClassesToImport.sortBy[x| '''«x.EPackage.name».«x.name»''']»
			import «imported.EPackage.name».«imported.name»;
		«ENDFOR»

		public interface «package.name.toClassName»Algebra«FOR x : rootEClassesMapA.keySet BEFORE '<' SEPARATOR ', ' AFTER '>'»«x»«ENDFOR» {
		
			«FOR eClass : allEClasses.filter[e|!e.isAbstract] SEPARATOR '\n'»
				« rootEClassesMapA.getReverse(eClass.findRootParent)» «eClass.name.toFirstLower»(final «eClass.name» «eClass.name.toFirstLower»);
			«ENDFOR»
		
			«FOR abstractTypes : rootEClassesMap.entrySet SEPARATOR '\n'»
				public default «abstractTypes.key» $(final «abstractTypes.value.name» «abstractTypes.value.name.toFirstLower») {
					final «abstractTypes.key» ret;
					«FOR type:tree.get(abstractTypes.key) BEFORE 'if' SEPARATOR 'else if' AFTER ''» («abstractTypes.value.name.toFirstLower» instanceof «type.name») {
						ret = this.«type.name.toFirstLower»((«type.name») «abstractTypes.value.name.toFirstLower»);
					} «ENDFOR»else {
						throw new RuntimeException("Unknow «abstractTypes.value.name» " + «abstractTypes.value.name.toFirstLower»);
					}
					return ret;
				}
			«ENDFOR»
		}'''
	}

	/**
	 * A root element is an element with no super type or explicitly defined with @OARoot.
	 */
	def static boolean isRoot(EClass eClass) {
		eClass.ESuperTypes.empty || eClass.hasOARootAnnotation
	}

	def static EClass findRootParent(EClass eClass) {
		if(eClass.isRoot) eClass else findRootParent(eClass.ESuperTypes.head)
	}

	def static boolean hasOARootAnnotation(EClass eClass) {
		eClass.EAnnotations.exists[e|e.source.equals("OARoot")]
	}

	def static <K, V> K getReverse(Map<K, V> map, V value) {
		map.filter[p1, p2|p2.equals(value)].keySet.head
	}
	
	def static String toClassName(String name) {
		name.split("\\.").map[e|e.toFirstUpper].join
	} 
}
