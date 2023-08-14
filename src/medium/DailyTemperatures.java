package medium;

import java.lang.annotation.ElementType;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int [] tem = new int[]{37,38,39};
        for (int n : dailyTemperatures.dailyTemperaturesMe(tem)){
            System.out.println(n);
        }

    }
    /*暴力搜索的时间复杂度是n^2，最后提交会超时*/

    public int[] dailyTemperaturesMe(int[] temperatures) {
        int n = temperatures.length;
        int j = 0;
        for (int i = 0; i < n; i++){
            for ( j = i; j < n; j++){
                if (temperatures[j] > temperatures[i])
                {
                   temperatures[i] = j - i;
                   break;
                }
            }
            if (j == n)
                temperatures[i] = 0;

        }
        return temperatures;
    }

    /*用单调栈，详细思路看typora*/
    public int[] dailyTemperaturesMethod(int[] temperatures){
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer>stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < n; i++){
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;


    }
}
