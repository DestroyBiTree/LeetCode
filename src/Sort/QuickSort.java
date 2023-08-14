package Sort;

import java.util.Arrays;
/*快速排序*/
public class QuickSort {
    public static void main(String[] args) {
        int num[] = new int[]{71,56,12,78,32,45};
        quickSort(num,0,num.length - 1);
        System.out.println(Arrays.toString(num));
    }
    public static void quickSort(int arr[], int left, int right) {
        if (left > right)
            return;
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr,left,i - 1);
        quickSort(arr,i + 1,right);
    }

}
