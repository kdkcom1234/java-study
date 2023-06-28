package ch09;

import java.util.List;

public class CollectionUtil<T> {
    public int countOccurrences(List<T> list, T target) {
        int count = 0;
        for(T instance : list) {
            if(instance.equals(target)) {
                count++;
            }
        }

        return count;
    }
}
