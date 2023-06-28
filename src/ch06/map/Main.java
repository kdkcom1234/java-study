package ch06.map;

import com.myuniversity.students.Student;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 해시맵: HashMap, 추가할 때 정렬X, 성능이 좀 더 좋겠지
        // 트리맵: TreeMap, 추가할 때 이진트리로 정렬, 성능이 떨어지지만 키값으로 정렬
        Map<String, Student> students = new HashMap<>();

        // 객체추가
        // 키(key, 유일값): 학번
        // 값(value): 학생정보
        // 맵변수.put(엔트리(K, V))
        students.put("e-01-00004", new Student("조정빈"));
        students.put("e-01-00001", new Student("강애진"));
        students.put("e-01-00003", new Student("김성우"));
        students.put("e-01-00002", new Student("김소현"));

        // 객체검색/조회
        // 맵변수.keySet() -> key 목록을 반환함(키는 중복이 안 됨)
        // Set: 집합, 원소의 중복이 없는 자료구조
        // 일반적으로 Map, 연관배열, dictionary, key-value pair
        // 자료구조는 정렬해서 저장하지 않음
        for (String key : students.keySet() ) {
            // 맵변수.get(키값) -> 값 객체
            System.out.println("학번: " + key + ", 학생명: " + students.get(key).getName());
        }
//        // 맵변수.values() -> 값 목록을 반환함
//        for (Student s: students.values()) {
//            System.out.println(s.getName());
//        }

        // 키 값 존재여부 확인
        boolean result = students.containsKey("e-01-00005");

        System.out.println("---------");
//        Map<String, Student> sortedStudents = new TreeMap<>(students);
        // 해시맵을 정렬된 트리맵으로 변환해서 출력
        for (String key : new TreeMap<>(students).keySet() ) {
            // 맵변수.get(키값) -> 값 객체
            System.out.println("학번: " + key + ", 학생명: " + students.get(key).getName());
        }
        // 객체의 값 수정
        // 맵변수.get(키값): 키값으로 조회후 먼가를 처리할 수 있음
        Student s = students.get("e-01-00002");
        // setter 등으로 값 수정

        // 객체삭제
        // 맵변수.remove(키값): 특정 키값의 엔트리(key-value쌍)를 삭제
        students.remove("e-01-00003");
        // 모두 다 밀어버려
        students.clear();

        // 맵(k,v) -> value list
        List<Student> lstStudent = new ArrayList<>(students.values());
        // 정렬
        Collections.sort(lstStudent, Comparator.comparing(Student::getName));
        // 출력
        for (Student std : lstStudent) {
            System.out.println(std.getName());
        }

        // 맵자체를 정렬(stream-api)
        // value 클래스가 Comparable 구현한 상태여야 함
        Stream<Map.Entry<String, Student>> sortedStudent =
                students.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());

        for(Map.Entry<String, Student> std: sortedStudent.toList()) {
            System.out.println(std.getValue().getName());
        }
    }
}
