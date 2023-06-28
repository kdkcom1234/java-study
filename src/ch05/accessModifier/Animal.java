package ch05.accessModifier;

public class Animal {
    // go(lang)
    // var name string;    // protected
    // var Name string;     // public
    private String name;
    protected void eat() {
        System.out.println(("The animal is eating."));
    }
}
