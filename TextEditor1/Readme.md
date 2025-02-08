
- Add undo/redo functionality or state restoration without exposing the internal state of the object and thus breaking encapsulation
- Here the memento pattern is used. 
- It captures the internal state of an object in a memento, allowing the object to restors it's state later on without revealing the internal details


- The originator class is responsible for the creation of memento and restoring ( Seems like it violates SRP)