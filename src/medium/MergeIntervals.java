package medium;

import java.util.*;
/*56.合并区间*/
public class MergeIntervals {
    public static void main(String[] args) {

//        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] test = new int[][]{{1,4},{4,6}};
        int[][] test = new int[][]{{1,3},{2,4},{5,6},{6,7},{7,9}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(test);
        for (int[] val : result){
            System.out.println(Arrays.toString(val));
        }

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        /*现将大数组按照小数组的第一个数字升序排列*/
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });


        /*merge用来保存最终结果
        * 当当前的数组的第一位数字大于merge数组中最右边数组的第二位数字时，代表无重合区间，则可以直接加入
        * 否则就是有重合区间，则需要比较当前数组的右区间和merge数组中最右边数组的右区间*/
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public int[][] merge2(int[][] intervals) {
        BitSet set = new BitSet();
        int right = 0, max = 0;
        /*将区间放大，防止出现[1,2],[3,4]这种区间不相连，但是位图看着相连的情况*/
        for (int[] interval : intervals){
            right = interval[1] * 2 + 1;
            set.set(interval[0], right, true);
            //记录最大的右边界
            max = right > max ? right : max;
        }

        int index = 0, count = 0;
        while (index < max){
            int start = set.nextSetBit(index);
            int end = set.nextClearBit(start);
            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int [][] res = new int[count][];
        for (int i = 0; i < count; i++){
            res[i] = intervals[i];
        }
        return res;
    }

}
