# FSM familly with ecore

## Implementations

| Implementation choice                    | FSM                                      | TFSM                                     |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| Classes as parameter - Arbitrary abstract type | [fr.inria.diverse.fsm.algebra](fr.inria.diverse.fsm.algebra) | [fr.inria.diverse.tfsm.algebra](fr.inria.diverse.tfsm.algebra) |
| Attributes as parameters - One abstract type by ecore class | [fr.inria.diverse.fsm.algebra2](fr.inria.diverse.fsm.algebra2) | [fr.inria.diverse.tfsm.algebra2](fr.inria.diverse.tfsm.algebra2) |
| Classes as parameter - One abstract type by Class without no custom supertype [^1] | [fr.inria.diverse.fsm.algebra3](fr.inria.diverse.fsm.algebra3) | [fr.inria.diverse.tfsm.algebra3](fr.inria.diverse.tfsm.algebra3) (TODO) |
| Attributes as parameters - One abstract type by Class without no custom supertype [^1] | [fr.inria.diverse.fsm.algebra4](fr.inria.diverse.fsm.algebra4) (TODO) | [fr.inria.diverse.tfsm.algebra4](fr.inria.diverse.tfsm.algebra4) (TODO) |

[^1] : In other terms, only classes which inherits directly from EObject emits a new abstract type and all its children have the same return type in the algebra.

## FSM

### Concepts

- State
- Transition
- transition triggered on string events

## TFSM

### Concepts

- State
- Transition
- Clock (tick + reset on transition trigger)
- Transition triggered when event called + clock constraints ok

# Observations
*   Reopening a class in a extended model is currently not an easy task
*   ... and it's even worse when the extended class already has sub-classes in the original model
    * Reusing the existing code is not always efficient (cf Graphviz impls)
    * no explicit definition of the type returned by a subpart of the model (e.g. the ClockConstraints in TFSM can be defined as another algebra which returns booleans).

      ​
