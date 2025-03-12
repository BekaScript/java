package assignment12_03_2025;

import java.util.Map;

public class MapUtils {
    public static <K, V> void printMapItems(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

//    public static void main(String[] args) {
//        Map<Integer, String> intStringMap = Map.of(1, "One", 2, "Two", 3, "Three");
//        Map<String, Double> stringDoubleMap = Map.of("PI", 3.14, "e", 2.71);
//
//        printMapItems(intStringMap);
//    }

}
