import java.util.*;

public class CountAllPermutationsOfPatternInMainString {
    public static void main(String[] args) {
        String mainString = "cbabcacabcab";
        String pattern = "abc";

        System.out.println(new CountAllPermutationsOfPatternInMainString().getCount(mainString, pattern));
        System.out.println(new CountAllPermutationsOfPatternInMainString().getCount2(mainString, pattern));
    }

    private int getCount2(String mainString, String pattern) {
        int count = 0;
        LinkedHashMap<Character, Integer> mapPattern = getMap(pattern);
        LinkedHashMap<Character, Integer> mapSubMainString = getMap(mainString.substring(0, pattern.length()));
        if (equals(mapPattern, mapSubMainString)) {
            count++;
        }

        for (int i = 1; i < mainString.length() - pattern.length() + 1; i++) {
            removeFromMap(mapSubMainString, mainString.charAt(i - 1));

            if (mapPattern.containsKey(mainString.charAt(i))) {
                addToMap(mapSubMainString, mainString.charAt(i + 2));
                if (equals(mapPattern, mapSubMainString)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static LinkedHashMap<Character, Integer> getMap(String pattern) {
        LinkedHashMap<Character, Integer> mapPattern = new LinkedHashMap<>();
        for (char ch : pattern.toCharArray()) {
            mapPattern.put(ch, mapPattern.getOrDefault(ch, 0) + 1);
        }

        return mapPattern;
    }

    private void removeFromMap(LinkedHashMap<Character, Integer> map, char ch) {
        if (!map.containsKey(ch)) {
            return;
        }

        int count = map.get(ch);
        if (count == 1) {
            map.remove(ch);
        } else {
            map.put(ch, count - 1);
        }
    }

    private void addToMap(Map<Character, Integer> map, char ch) {
        int count = map.getOrDefault(ch, 0);
        map.put(ch, count + 1);
    }

    private static boolean equals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (char ch : map1.keySet()) {
            if (!Objects.equals(map1.get(ch), map2.get(ch))) {
                return false;
            }
        }

        return true;
    }

    private int getCount(String mainString, String pattern) {
        int count = 0;
        PermutationsString permutationsString = new PermutationsString();
        List<String> patterns = permutationsString.permute(pattern);
        for (int i = 0; i < mainString.length() - pattern.length() + 1; i++) {
            String patterInMainString = mainString.substring(i, i + pattern.length());
            if (patterns.contains(patterInMainString)) {
                count++;
            }
        }

        return count;
    }
}