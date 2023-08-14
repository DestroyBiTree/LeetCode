package medium;

import java.util.HashSet;
import java.util.Set;
/*先将所有数字放入hashet中。 遍历nums，如果set中存在nums[i]-1，则表示这个元素不是开始元素，所以不会是最长的连续子序列起点，跳过。
       对于没有nums[i]-1的元素，则表示为起点，开始循环，每次+1，判断是否在set中，并维护变量记录最大值。*/

public class LongestConsecutive {
    public static void main(String[] args) {

    }

    public int longestConsecutiveMethod(int[] nums) {
        Set<Integer> hashNum = new HashSet<>();
        for (int a : nums){
            hashNum.add(a);
        }
        int result = 0;
        for (int a : nums){
            if (hashNum.contains(a - 1)){
                continue;
            }

            int max = 0;
            while (hashNum.contains(a)){
                max++;
                a++;

            }
            result = Math.max(result, max);
        }
        return result;

    }
}
