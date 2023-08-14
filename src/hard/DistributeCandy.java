package hard;

import java.util.Arrays;

/*135.分发糖果*/
/*n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
        你需要按照以下要求，给这些孩子分发糖果：
        每个孩子至少分配到 1 个糖果。
        相邻两个孩子评分更高的孩子会获得更多的糖果。
        请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目*/
/*采用贪心算法，先确定一边。先确定比左边大的情况，然后逆向判断比右边大的情况
* 只能这样的顺序，反过来不对*/

public class DistributeCandy {
    public static void main(String[] args) {
        int [] ratings = new int[]{1, 2, 2, 5, 4, 3, 2};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int nums = 0;
        if (n == 1){
            return 1;
        }
        int candy[] = new int[n];
        Arrays.fill(candy,1);
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            nums += candy[i];
        }
        return nums;
    }
}
