package medium;
//347 前 K 个高频元素
//解法为小顶堆，使用优先队列实现小顶堆
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {

    }
     public int[] topKFrequentMethod(int[] nums, int k){
         Map<Integer, Integer> map = new HashMap<>();
         //使用map将每个数字出现的次数存入
         for (int num : nums){
             map.put(num, map.getOrDefault(num, 0) + 1);
         }
         //在优先队列中存储二元数组组(num,cnt),cnt表示元素值num在数组中的出现次数
         //升序排列
         PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1] - pair2[1]);

         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             if(pq.size() < k){
                 pq.add(new int[]{entry.getKey(),entry.getValue()});
             }else {
                 if(entry.getValue() > pq.peek()[1]){
                     pq.poll();
                     pq.add(new int[]{entry.getKey(),entry.getValue()});
                 }
             }
         }
         int ans[] = new int[k];
         for (int i = 0; i < k; i++){
             ans[i] = pq.poll()[0];
         }
         return ans;
     }
}

