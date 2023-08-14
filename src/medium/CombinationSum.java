package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = new int[]{2,5,3};
        combinationSum.combinationSumMe(nums,4);


    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSumMe(int[] candidates, int target) {
        backTracking(candidates,target,0,0);
        return result;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex){
        if (sum > target) {
            return;
        }
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates,target,sum,i);
            sum-= candidates[i];
            path.remove(path.size() - 1);

        }

    }
}
