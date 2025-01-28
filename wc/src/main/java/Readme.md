- We can use libraries like **Apache commons CLI** or **Args4j** for advanced flag parsing use cases.

- **Method Hiding** v/s **Method Overriding**
    - Method Hiding is used with static methods. 
    - Example:- Animal dog = new Dog(); dog.sound() // it will call the static sound method of Animal and not of dog.
    - Subclass static method cannot hide an instance method of super class

- **try with resources** syntax
    - Used to close auto closeable resources ( classes that implements java.lang.AutoCloseable)
    - This way we are avoiding a finally block which would have just closed the resources explicitly

- **BufferedReader** v/s **Scanner**
    - Scanner giving incorrect output in CharacterCounter. 


- **File** object holds the path to the file or directory but do not contain the data.