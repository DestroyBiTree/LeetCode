package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {
    public static void main(String[] args) {

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(nums, 0 , new ArrayDeque<>(), new boolean[nums.length], res);
        return res;
    }

    public void backTracking(int[] nums, int index, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if (index == nums.length){
            res.add(new ArrayList<>(path));
            return; 
        }


        for (int i = 0; i < nums.length; i++){
           if (!used[i]){
               path.addLast(nums[i]);
               used[i] = true;
               backTracking(nums, index + 1, path, used, res);
               path.removeLast();
               used[i] = false;
           }
        }
    }
}
