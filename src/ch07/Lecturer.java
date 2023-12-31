package ch07;

public class Lecturer extends Person {
    private int careerTerm;

    public Lecturer(String name, int age, int careerTerm) {
        super(name, age);
        this.careerTerm = careerTerm;
    }

    @Override
    public void introduce() {
        System.out.println("저의 강의 경력은 " + this.careerTerm +"년입니다.");
    }

    public void teach() {
        System.out.println(name + "이(가) 강의를 시작합니다.");
    }
}
