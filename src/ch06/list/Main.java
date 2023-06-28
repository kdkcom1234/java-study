package ch06.list;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // List<자료형> 변수형 = new ArrayList<자료형>();
        // 자료형에 따라서 다르게 작동하기 위해서 추가적인 매개변수를 <자료형>을 넣는다.
        // 자료형을 매개변수로 받는 것을 제네릭/제너릭/쥐네릭(generic)
        // 매개변수의 자료형은 기본(원시) 자료형(primitive type)은 안 됨
        // int/long... X, Integer, Long 클래스 타입을 넣어줘야한다.
        List<String> list = new ArrayList<>();
//        List<String> list = new LinkedList<String>();
        List<Integer> listInt = new ArrayList<>();

        // typescript, go하고 비슷한데
        // 타입추론(type inference)
        var str = "asdfasdfadsf";
        var number = 0;

        var map = new HashMap<String, Integer>();
        for(String s : new TreeMap<String, Integer>(map).keySet()) {

        }

        // 객체 추가
        // 리스트변수.add(객체);
        list.add(new String("남소나"));
        list.add(new String("명승정"));
        for (String name : list) {
            System.out.println(name);
        }

        // 특정 위치의 값을 변경
        // 리스트변수.set(인덱스, 객체);
        list.set(0, new String("조정빈"));
        list.set(1, new String("이현미"));
        for (String name : list) {
            System.out.println(name);
        }

        // 리스트변수.size() - 요소의 개수
        System.out.println(list.size());
        System.out.println("---------");

        list.add("김성우");
        list.add("김소현");
        for (String name : list) {
            System.out.println(name);
        }
        System.out.println("---------");

        // 1번 요소를 삭제
        list.remove(1);
        // 뒤에 있는 것을 전부 당겨옴, 중간에 구명(null)이 안 생김.
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("-----------");
        // 2번에 객체 삽입
        list.add(2, new String("이현미"));
        for (String name : list) {
            System.out.println(name);
        }
        // 이렇게 중간에 요소를 삭제하거나, 추가하게되면
        // 뒤쪽요소를 당겨오거나 밀어아야되는 overhead(추가적인연산) 발생
        // 이런 케이스 잦다면, ArrayList -> LinkedList
        //               요소추가,   전체 탐색,    요소삭제/삽입
        // ArrayList     빠름        빠름         느림(많이)
        // LinkedList    느림        느림         빠름

        List<String> lstStr = new ArrayList<String>
                (List.of("banana", "apple", "kiwi", "mango"));
        lstStr.add("pineapple");

        System.out.println("-----------");
        for(String s : lstStr) {
            // list변수.indexOf(객체)
            // 요소의 위치를 찾을 수 있음
            System.out.println(lstStr.indexOf(s) + ": " + s);    // 인덱스값 조회
        }
        System.out.println("-----------");
        System.out.println(lstStr.get(0));        // 해당 인덱스의 객체 조회
    }
}
