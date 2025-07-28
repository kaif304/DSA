package oops.abstraction;

/*
    A class must be abstract if it has some abstract behaviour.

    Any class who inherits Hello has to implement abstract method.

    We can't create objects of abstract classes because it does not
    have full implementation, so what is the use of its objects.
*/
abstract class Hello {
    abstract void sayHello(); // cannot have body
}
class Hi extends Hello {
    public void sayHi(){
        System.out.println("Hi from Hi");
    }

    @Override
    void sayHello() { // has to be overridden
        System.out.println("Hello from Hello");
    }
}

public class AbstractClasses {
    public static void main(String[] args) {
        Hi hi = new Hi();
        hi.sayHello();
        hi.sayHi();
    }
}
