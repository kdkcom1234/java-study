package ch09;

import ch06.list.account.Account;
import com.myuniversity.students.Student;

import java.util.ArrayList;
import java.util.List;

public class GenericExMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(1);

        int targetInt = 1;   // 몇개가 있는지 찾을 특정 요소

        CollectionUtil<Integer> utilInt = new CollectionUtil<>();
        int occurrenceCountInt = utilInt.countOccurrences(numbers, targetInt);

        System.out.println("Number of occurrences of " + targetInt + ": " + occurrenceCountInt);

        List<String> strList = new ArrayList<>();
        strList.add("apple");
        strList.add("banana");
        strList.add("apple");
        strList.add("cherry");
        strList.add("durian");
        strList.add("melon");

        String targetStr = "apple";   // 몇개가 있는지 찾을 특정 요소

        CollectionUtil<String> utilStr = new CollectionUtil<>();
        int occurrenceCountStr = utilStr.countOccurrences(strList, targetStr);

        System.out.println("Number of occurrences of " + targetStr + ": " + occurrenceCountStr);

        Cache<Student> c = new Cache<>();
        c.setData(new Student("고대근"));
        Student s = c.getData();

        Cache<Account> a = new Cache<>();
        a.setData(new Account("000001", 10));
        Account acc = a.getData();
    }
}
