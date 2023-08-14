package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3)
            return null;
        for (int i = 0; i < len; i++){
            if (nums[i] > 0){
                return lists;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && nums[left] == nums[left +1 ]) left++;
                    while (left < right && nums[right] == nums[right +1 ]) right--;
                    left++;
                    right--;
                }
                else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }

            }

        }
        return lists;
    }
}
