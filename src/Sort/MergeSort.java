package Sort;

import java.util.Arrays;
/*归并排序*/
public class MergeSort {
    public static void main(String[] args) {
        int num[] = new int[]{71,56,12,78,32,45};
        mergeSort(num,0,num.length - 1);
        System.out.println(Arrays.toString(num));
    }
    public static void mergeSort(int[] array,int low, int height) {
        //当low和height相遇的时候结束递归
        if(low >= height) {
            return;
        }
        int mid = (low + height) / 2;

        //递归对左边和右边进行分割
        mergeSort(array,low,mid);
        mergeSort(array,mid + 1,height);
        
        //分割完进行合并
        merge(array, low, height, mid);
    }

    private static void merge(int[] array, int low, int height, int mid) {
        int s1 = low;
        int s2 = mid + 1;
        int i = 0;
        int ref[] = new int[height - low + 1];
        while (s1 <= mid && s2 <= height) {
            //这个等号决定稳定与否
            if (array[s1] <= array[s2]) {
                ref[i++] = array[s1++];
            }else {
                ref[i++] = array[s2++];
            }
        }
        //判断哪个还有剩余
        while (s1 <= mid) {
            ref[i++] = array[s1++];
        }
        while (s2 <= height) {
            ref[i++] = array[s2++];
        }
        //最后将排好序的ref拷贝到array中
        for (int j = 0; j < ref.length; j++) {
            array[j + low] = ref[j];
        }


    }
}
