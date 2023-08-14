package hard;

import java.util.Deque;
import java.util.LinkedList;
//42. 接雨水
/*单调栈法。使用的是递增的栈，因为要始终保持栈头的位置是最小的数，用来形成凹槽*/
public class Trap {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int n = height.length;
        if (n < 2) return 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int count = 0;
        stack.push(0);
        for(int i = 1; i < n; i++){
            if (height[i] < height[stack.peek()]){
                stack.push(i);
            }
            else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }
            else if (height[i] > height[stack.peek()]){
                while (!stack.isEmpty() && height[i] > height[stack.peek()] ){
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int r = i - stack.peek() - 1;
                        count += h * r;
                    }
                }
                stack.push(i);
            }
        }

        return count;
    }

}
