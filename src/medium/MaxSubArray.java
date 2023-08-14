package medium;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArrayMethod(int[] nums){
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0, right = 0, win = 0;
        while (right < nums.length){
            win += nums[right];
            right++;

            max = max > win ? max : win;

            while (win < 0){
                win -= nums[left];
                left--;
            }

        }
        return max;
    }
}


