import java.util.*;

public class PermutationsArray {
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, ArrayList<Integer> currentList, int[] nums, boolean[] used) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentList.add(nums[i]);
                used[i] = true;

                backTrack(result, currentList, nums, used);

                used[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsArray permutationsArray = new PermutationsArray();
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = permutationsArray.permute(nums);

        System.out.println("Permutations of " + Arrays.toString(nums) + ":");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}