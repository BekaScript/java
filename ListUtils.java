package assignment12_03_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    public static <T> List<T> merge(List<T> list1, List<T> list2){
        List<T> longer = list1;
        List<T> shorter =list2;
        if(list2.size() > list1.size()) {
            longer = list2;
            shorter = list1;
        }
        List<T> mergedList = new ArrayList<T>();
        for (int i = 0; i < shorter.size(); i++) {
            mergedList.add(list1.get(i));
            mergedList.add(list2.get(i));
        }
        for (int i = shorter.size(); i < longer.size(); i++) {
            mergedList.add(longer.get(i));
        }
        return mergedList;
    }
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("X", "Y", "Z","M","N"));

        System.out.println(ListUtils.merge(list1,list2));
    }
}
