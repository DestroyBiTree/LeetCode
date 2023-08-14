package zijie;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        System.out.println(mininum(nums));

    }

    public static int mininum(int nums[]){
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n - 1; i++){
            if (Math.abs(nums[i + 1] - nums [i] )> 1){
                cnt++;
                nums[i] = (nums[i] + nums[i + 1] / 2);
                i--;
            }
        }
        return cnt;
    }
    public static int mininum2(int nums[]){
        int n = nums.length;
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++){
            if (nums[i] == nums[i - 1]){
                continue;
            }

            if (i == 1 || Math.abs(nums[i] - nums[i - 2]) >= Math.abs(nums[i] - nums[i -1])){
                cnt+= Math.abs(nums[i] - nums[i - 1]);
                nums[i] = nums[i - 1];
            }
            else {
                cnt+= Math.abs(nums[i] - nums[i -2]);
                nums[i - 1] = nums[i - 2];
            }
        }
        return cnt;
    }

}
