package medium;

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange.searchRangeMethod(nums,0)));

    }

    public int[] searchRangeMethod(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        if (len == 0)
            return new int[]{-1,-1};
        int flag = binSearch(nums, target, left,right);
        if (flag!= -1){
            int l = flag;
            int r = flag;
            while (l >= 0 && nums[l] == target)
                l--;
            while (r <len && nums[r] == target)
                r++;
            return new int[]{l + 1, r - 1};
         }
        else if (flag == -1)
            return new int[]{-1,-1};
        else
            return null;


    }
    public int binSearch(int[] nums, int target, int left, int right){
        int len = nums.length;

        while (left <= right){
            int mid = left + right >> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}
