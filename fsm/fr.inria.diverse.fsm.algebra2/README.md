# FSM - Algebra #2

## Description

Algebra with object attributes as parameters.

History

* A lot of abstract type (another version with less types will be created soon)
* Lazy object declaration to deal with circular object relationship

## TODO

1. Naive implementation : Every time a call to a method is done on a proxy, a new object is created so their is no possibility to define statefull proxies. Either find a way to declare everything statically or to limit the creation of new proxies