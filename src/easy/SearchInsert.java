package easy;

public class SearchInsert {
    public static void main(String[] args) {
        System.out.println();
        int arrs[] = new int[]{1,3,5,6};
        SearchInsert searchInsert = new SearchInsert();
    }
    public int searchInsertM(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;

    }
}
