import java.util.HashMap;
import java.util.Map;

public class Hashing {
    public static void printFreq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], 1);
            else {
                int current = map.get(arr[i]);
                map.put(arr[i], current + 1);
            }
        }

        for (int key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    // O <= a[i] < 10
    public static void countSort(int[] arr) {
        int[] map = new int[10];

        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }

        for (int i = 0; i < map.length; i++) {
            int occurrences = map[i];
            for (int j = 0; j < occurrences; j++) {
                System.out.print(i + " ");
            }
        }
    }

    // -10 < a[i] < 10
    // aabbcc
    // (0): a
    public static void countSort2(int[] arr) {
        int[] map = new int[20];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] + 10;
            map[index]++;
        }

        for (int i = 0; i < map.length; i++) {
            int occurrences = map[i];
            int value = i - 10;
            for (int j = 0; j < occurrences; j++) {
                System.out.print(value + " ");
            }
        }
    }

    public static void countFreq(String str) {
        int[] map = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            map[index]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                char ch = (char) (i + 'a');
                System.out.println(ch + ":" + map[i]);
            }
        }
    }

    // anagram
    // permutation
    // abc -> cba
    // aabc -> caba
    // abd -> bcd
    // navya -> vanya
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] map = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            map[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            map[index]--;
        }

        // comparison
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) return false;
        }

        return true;
    }

}
