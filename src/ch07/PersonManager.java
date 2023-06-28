package ch07;

public class PersonManager {
    // 다형성을 이용해서
    // 현재 객체가 Student일 수도 있고, Lecturer 일 수도 있음.
    public void work(Person p) {
        if(p instanceof Student) {
            ((Student) p).study();
        } else if(p instanceof Lecturer) {
            ((Lecturer) p).teach();
        }
    }
}
