package medium;

public class MaxProduct {
    public static void main(String[] args) {

    }
    public int maxProductMethod(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i],nums[i] * imax);
            imin = Math.min(nums[i],nums[i] * imin);

            max = Math.max(imax, max);

        }
        return max;

    }
}
