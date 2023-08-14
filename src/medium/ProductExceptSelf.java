package medium;
/*238.除自身以外数组的乘积*/
public class ProductExceptSelf {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int left [] = new int[nums.length];
        left[0] = 1;
        int right [] = new int[nums.length];
        right[right.length - 1] = 1;

        for (int i = 1; i < left.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = right.length - 2; i >= 0; i--){
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0 ; i < nums.length; i++){
            nums[i] = left[i] * right[i];
        }
        return nums;


    }
}
