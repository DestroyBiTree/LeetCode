package medium;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
    }

    public List<List<Integer>> subSetsMethod(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(nums,0, result, path);
        return result;
    }

    public void backTracking(int[] nums, int start,List<List<Integer>> result,List<Integer> path){
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backTracking(nums, i + 1,result, path);
            path.remove(path.size() - 1);
        }

    }
}
