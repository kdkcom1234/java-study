package ch06.list;

import com.myuniversity.students.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListEx {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("사과");
        lst.add("바나나");
        lst.add("체리");
        // 내부적으로 구버전 자바이면 merge-sort, 현재자바전이면 tim-sort
        Collections.sort(lst);
        for (String elm : lst) {
            System.out.println(elm);
        }

        System.out.println("--");

        Collections.reverse(lst);
        for (String elm : lst) {
            System.out.println(elm);
        }

        List<Student> lstStudent = new ArrayList<Student>();
        lstStudent.add(new Student("조정빈"));
        lstStudent.add(new Student("김성우"));
        lstStudent.add(new Student("양수열"));

        System.out.println("-----");
        // Comparable로 구현
//        Collections.sort(lstStudent);
//        for (Student s : lstStudent) {
//            System.out.println(s.getName());
//        }

        // @: at mark
        // kdkcom@naver.com
        // 클래스명::필드명(getter)
        // 해당 클래스의 필드로 먼가를 하겠다.
        // 컬렉션s.sort(lstStudent, Comparator.comparing(클래스명::필드(getter));
        Collections.sort(lstStudent, Comparator.comparing(Student::getName));
        for (Student s : lstStudent) {
            System.out.println(s.getName());
        }
    }
}
