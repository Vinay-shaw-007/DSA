package Miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class SortNumber {
    public static void main(String[] args) {
        int n = 19;
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10};
        // int[] arr = {4, 7, 2, 4};
        calulateFrequency(arr, n);
    }

    private static void calulateFrequency(int[] arr, int n) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int value = map.get(arr[i])+1;
                map.put(arr[i], value);
            }
        }
        
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                               .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                               (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Sorted Map: " + Arrays.toString(sortedMap.entrySet().toArray()));
        for (Map.Entry<Integer,Integer> entry: sortedMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++) {
                System.out.print(key+" ");
            }
        }
    }
}
