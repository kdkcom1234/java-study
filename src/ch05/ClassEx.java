package ch05;

public class ClassEx {
    public static void main(String[] args) {
        // Student 클래스 객체를 생성하고 메서드를 실행
        Student student = new Student("고대근");
        student.setName("고대근");

        System.out.println(student);
        System.out.println(student.getName());

        Student student1 = new Student("고대근");
        student1.setName("명승정");
        System.out.println(student1);
        System.out.println(student1.getName());
    }
}
