import java.util.TreeMap;

public class MostRepeatedCharacter {
    public static void main(String[] args) {
        String input = "aaaavvvvvvvvvvvvvvvvvvvvvvvvvvvccxcbjsdbhfsuagfusaihfidisjid";
        System.out.println(new MostRepeatedCharacter().findCharacter(input));
    }

    private char findCharacter(String input) {
        int max = 0;
        char maxCh = input.charAt(0);
        TreeMap<Character, Integer> sortedMap =  new TreeMap<>();
        for (char ch:input.toCharArray()){
            if(!sortedMap.containsKey(ch)){
                sortedMap.put(ch, 0);
            }

            sortedMap.put(ch, sortedMap.get(ch)+1);
            if (sortedMap.get(ch)>max){
                max = sortedMap.get(ch);
                maxCh = ch;
            }
        }

        return maxCh;
    }
}
