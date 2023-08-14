package easy;

import java.util.Arrays;

public class MergeArr {
    public static void main(String[] args) {
        int [] nums1 = new int[]{1};
        int [] nums2 = new int[]{};
        MergeArr mergeArr = new MergeArr();
        System.out.println(Arrays.toString(mergeArr.merge(nums1, 1, nums2, 0)));

    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sort = new int[m + n];
        while (i < n && j < m) {

            if (nums1[j] > nums2[i]) {

                sort[k++] = nums2[i++];
            }
            else {
                sort[k++] = nums1[j++];
            }
            if (i >= n){
                System.arraycopy(nums1,j,sort,k,m-j);
            }
            else {
                System.arraycopy(nums2,i,sort,k,n-i);
            }
        }

        if (m == 0) {
            for ( int q = 0; q < n; q++) {
                nums1[q] = nums2[q];
            }
        }
        else if (n == 0){
            return nums1;
        }
        else {
            for ( int q = 0; q < m + n; ++q) {
                nums1[q] = sort[q];
            }
        }
        return nums1;

    }
}
