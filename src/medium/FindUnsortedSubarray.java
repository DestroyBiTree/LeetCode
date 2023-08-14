package medium;

import java.util.Arrays;

//581. 最短无序连续子数组
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int a[] = new int[]{1,2,3,4};
        System.out.println(findUnsortedSubarray.findUnsortedSubarrayMe(a));

    }

    /*暴力解法：复制一个新的数组，然后对新的数组进行排序，新旧数组比较，两端不同的地方就是最短子数组*/
    public int findUnsortedSubarrayMe(int[] nums) {
        int[] copyNums = nums.clone();
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0 ,r = n - 1;
        while (l < n && nums[l] == copyNums[l]){
            l++;
        }
        while (r >= 0 && nums[r] == copyNums[r]){
            r--;
        }
        if (l >= r)
            return 0;
        else
            return r - l + 1;


    }
}
