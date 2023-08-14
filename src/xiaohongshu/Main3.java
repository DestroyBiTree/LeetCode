package xiaohongshu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int [][] array = new int[m][2];

        for (int i = 0; i < m; i++) {
            array[i][0] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            array[i][1] = sc.nextInt();
        }

        String operator = sc.next();
        int [] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }

        getRes(nums, array, operator.toCharArray(),x);
        for (int r : nums) {
            System.out.print(r + " ");
        }
    }
    private  static void getRes(int [] nums, int [][] array, char[] operator, int[] x) {
        for (int i = 0; i < operator.length; i++) {
            switch (operator[i]) {
                case '|' :
                    operator1(nums, array[i][0] - 1, array[i][1] - 1, x[i]);
                    break;
                case '&' :
                    operator2(nums, array[i][0] - 1, array[i][1] - 1, x[i]);
                    break;
                case '=' :
                    operator3(nums, array[i][0] - 1, array[i][1] - 1, x[i]);
                    break;
            }
        }
    }

    private static void operator1(int nums[], int l, int r, int x) {
        for (int i = l; i < nums.length && i <= r; i++) {
            nums[i] |= x;
        }
    }
    private static void operator2(int nums[], int l, int r, int x) {
        for (int i = l; i < nums.length && i <= r; i++) {
            nums[i] &= x;
        }
    }
    private static void operator3(int nums[], int l, int r, int x) {
        for (int i = l; i < nums.length && i <= r; i++) {
            nums[i] = x;
        }
    }
}
