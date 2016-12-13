# Parametrized Model and Object Algebra

## Limitations

Defining independent model and the associated algebra look ok. The composition of the semantics sounds good too. But the composition of the models is not.

Two solutions to study:

- simply put models I want to reuse in a new ecore, without adding anything more. And define the abstract type during the concrete models definition.
- redefine the abstract type of the whole inheritance tree of an abstract class (e.g AbstractCompare\<E\> where E should be an Expression\<G\> so I also have to redefine Equal which shouldn't be needed!).

