import java.util.ArrayList;
import java.util.List;

public class PermutationsString {
    public List<String> permute(String text) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[text.length()];
        backTrack(result, "", text, used);
        return result;
    }

    private void backTrack(List<String> result, String currentText, String text, boolean[] used) {
        if (currentText.length() == text.length()) {
            if (!result.contains(currentText))
                result.add(currentText);
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            if (!used[i]) {
                currentText += (text.charAt(i));
                used[i] = true;

                backTrack(result, currentText, text, used);

                used[i] = false;
                currentText = currentText.substring(0, currentText.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsString permutations = new PermutationsString();
        String text = "abc";

        List<String> result = permutations.permute(text);

        for (String permutation : result) {
            System.out.println(permutation);
        }
    }
}