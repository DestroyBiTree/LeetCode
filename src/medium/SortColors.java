package medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int [] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColorsMethod(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColorsMethod(int[] nums) {
        int ref = 1;
        int L = -1; //一开始没有小于区域
        int R = nums.length;
        int i = 0;
        while (i < R){
            if (nums[i] == ref){
                i++;
            }
            else if (nums[i] < ref){
                int n = nums[L + 1];
                nums[L + 1] = nums[i];
                nums[i] = n;
                L++;i++;
            }
            else if (nums[i] > ref){
                int n = nums[R - 1];
                nums[R - 1] = nums[i];
                nums[i] = n;
                R--;
            }
        }
    }
}
