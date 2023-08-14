package medium;
/*278 寻找重复数*/
//数组长度为 n+1，同时给定的 nums[i] 都在[1,n] 范围内，
// 因此我们可以设定哈希规则为 nums[idx]=idx+1，即数值 x 会放在下标 x−1 的位置。
//如此一来，对于只出现一次的数值而言，必然能够顺利放在目标位置，而出现多次的数值必然会因为位置冲突而被找出。

public class FindDuplicate {
    public static void main(String[] args) {

    }
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int t = nums[i];
            int idx = t - 1;
            if (nums[idx] == t){
                if (idx != i)
                    return t;
                i++;

            }
            else {
                swap(nums, i, idx);
            }
        }
        return -1;

    }

    public void swap(int [] nums, int i ,int idx){
        int c = nums[i];
        nums[i] = nums[idx];
        nums[idx] = c;
    }
}
