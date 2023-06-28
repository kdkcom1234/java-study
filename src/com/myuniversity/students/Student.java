// src/com/myuniversity/students/Student.java

// 회사(com), 비영리조직(org)
// 1차
// com.----
// org.----

// 2차
// 회사명, 조직명
// com.naver, com.wooahan
// org.apache, org.mozilla

// 3차
// 제품명, 서비스명, 도메인명(비즈니스범위명)
// com.naver.search, com.naver.blog, com.naver.news

// 그 하위
// com.naver.news.sports.baseball
package com.myuniversity.students;

import com.myuniversity.courses.Course;

// comparable 인터페이스를 구현한다.
// implements 구현
// 자바 객체를 특정 필드로 정렬하는 방법(chatgpt)
// java sort by specific field(google)
public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Collections.sort(리스트)
    // 객체별로 compareTo 메서드를 실행하여 정렬해줌
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
