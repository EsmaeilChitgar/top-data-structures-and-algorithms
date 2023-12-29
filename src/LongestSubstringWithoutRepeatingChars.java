import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    private static int lengthOfLongestSubstring(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (hashMap.containsKey(ch)) {
                left = hashMap.get(ch) + 1;
            }

            hashMap.put(ch, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String input = "abcabcdebb";
        int length = lengthOfLongestSubstring(input);

        System.out.println("Longest substring without repeating characters: " + length);
    }

}
