package medium;
/*240. 搜索二维矩阵 II*/
public class SearchMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int [] nums : matrix){
            if (search(nums,target) > 0){
                return true;
            }
        }
        return false;
    }

    public int search(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + high >> 1;
            int midNum = nums[mid];
            if (midNum == target)
                return 1;
            else if (midNum > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
