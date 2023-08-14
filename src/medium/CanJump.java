package medium;

public class CanJump {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJumpMethod(nums));
    }
    public boolean canJumpMethod(int[] nums){
        int len = nums.length;
        boolean flag [] = new boolean[len];
        if (nums[0] != 0)
            flag[0] = true;
        if (nums[0] ==0 && len ==1)
            return true;
        for (int i = 0; i < len; i++){
             int trueNum = nums[i];
             if (i < len - 1 && nums[i] == 0 && flag[i + 1] == false)
                 return false;
             for (int j = i, k = 0; k <= trueNum && j <len; k++,j++){
                 flag[j] = true;
             }
        }
        return true;
//        for(boolean value : flag){
//            if (!value)
//                return false;
//        }
//        return true;
    }
}
