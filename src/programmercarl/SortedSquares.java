package programmercarl;

import java.util.Arrays;

/*977. 有序数组的平方*/
/*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。*/
/*解法：双指针法*/
/*因为原来的数组中可能有负数，平方之后变成较大的数，所以可以从两端向中间遍历*/
public class SortedSquares {
    public static void main(String[] args) {
        int [] res = sortedSquares(new int[]{-5,-2,0,1,2,3});
        System.out.println(Arrays.toString(res));
    }
    public static int[] sortedSquares(int[] nums) {
        int i = nums.length;
        int [] res = new int[i];
        int l = 0;
        int r = i - 1;
        i--;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                res[i--] = nums[l] * nums[l];
                l++;
            } else {
                res[i--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}
