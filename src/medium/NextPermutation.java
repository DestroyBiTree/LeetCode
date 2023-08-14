package medium;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,5,3,4,4,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutationMethod(nums);
        System.out.println(Arrays.toString(nums));

    }
    public void nextPermutationMethod(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i --;
        }

        if (i < 0){
            reverse(nums,0,len - 1);
            return;
        }

        int lg = i + 1;

        while (lg < len  && nums[lg] > nums[i]){
            lg++;
        }
        swap(nums,i,lg - 1);
        reverse(nums,i + 1,len - 1);


    }

    public void swap(int[] nums,int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;

    }

    public void reverse(int[] nums, int l, int r){
        while (l < r){
            swap(nums,l++,r--);
        }
    }
}
