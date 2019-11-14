import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = combination(candidates, target, 0);
        return result;
    }

    public static List<List<Integer>> combination(int[] candidates, int target, int last) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates[0] > target) {
            return result;
        }
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            if (last > candidates[i]) {
                continue;
            }
            if (target == candidates[i]) {
                List<Integer> temp0 = new LinkedList<>();
                temp0.add(candidates[i]);
                result.add(temp0);
                return result;
            }

            for (List<Integer> temp : combination(candidates, target - candidates[i], candidates[i])) {
                List<Integer> temp0 = new LinkedList<>();
                temp0.add(candidates[i]);
                temp0.addAll(temp);
                result.add(temp0);
            }


        }
        return result;
    }
}
