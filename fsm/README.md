# FSM familly with ecore

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
