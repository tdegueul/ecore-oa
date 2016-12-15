package fr.inria.diverse.objectalgebragenerator.popup.actions

import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.xbase.lib.Functions.Function1



import static extension fr.inria.diverse.objectalgebragenerator.popup.actions.GenerateAlgebra.findRootParent
import static extension fr.inria.diverse.objectalgebragenerator.popup.actions.GenerateAlgebra.getReverse

class GenerateAlgebra {

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

		'''
		package «package.name»;
		
		public interface «package.name.toFirstUpper»Algebra<«FOR x : rootEClassesMap.keySet SEPARATOR ', '»«x»«ENDFOR»> {
			
			«FOR eClass : allEClasses»
				«IF !eClass.isAbstract»
					« rootEClassesMap.getReverse(eClass.findRootParent)» «eClass.name.toFirstLower»(final «eClass.name» «eClass.name.toFirstLower»);
				«ENDIF»				
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
