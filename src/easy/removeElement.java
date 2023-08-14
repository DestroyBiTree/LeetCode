package easy;

import java.util.Arrays;

public class removeElement {
    public static void main(String[] args) {
        int arrs[] = new int[]{1,2,4,5,2,4,6,7,8,2,10};
        removeElement element = new removeElement();
        element.removeElement2(arrs,2);
        System.out.println(Arrays.toString(arrs));
    }
    public int removeElementTest(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++)
        {
            if (nums[right] != val)
            {
                nums[left] = nums [right];
                left++;
            }
        }
        return left;
    }

        public int removeElement2(int[] nums, int val) {
            int n = nums.length;
            int left = 0;
            for (int right = 0; right < n; right++) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }



}
