package programmercarl;
/*LeetCode27.移除元素*/
/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。*/
/*解法：
* 定义快慢指针fast和slow，fast指向原来数组中不为目标值的元素，slow作为新数组中的位置*/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
