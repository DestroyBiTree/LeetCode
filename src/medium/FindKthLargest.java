package medium;

import java.util.Arrays;

public class FindKthLargest {
    public static void main(String[] args) {

    }

    public int findKLargest(int[] nums, int k){
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int p = quicksort(nums,left,right);
            if (p == target){
                return nums[p];
            }
            else if (p < target){
                left = p + 1;
            }
            else {
                right = p - 1;
            }

        }
        return -1;

    }

    public static int quicksort(int[] arr, int left, int right) {
            //保存基数
            int basic = arr[left];
            //定义左右指针
            int i = left;
            int j = right;
            while (i < j) {        //左指针小于右指针
                while (i < j && arr[j] > basic) {//操作右指针找到小于基数的下标
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];    //将右指针对应小于基数的值放到左指针所指的位置
                    i++;                //左指针自加
                }
                while (i < j && arr[i] < basic) {//相反，找到大于基数的下标
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];    //大于基数的值赋给右指针所指的位置
                    j--;                //右指针自减
                }
            }
            arr[i] = basic;                //将基数放入到指针重合处
            return i;


    }
}
