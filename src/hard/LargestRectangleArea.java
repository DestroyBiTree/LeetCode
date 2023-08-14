package hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/*柱状图中最大矩形*/

public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int [] height = new int[]{3,5,6,7,4};
        System.out.println(largestRectangleArea.largestRectangleAreaMethod(height));

    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int [] newHegihts = new int[heights.length + 2];
        newHegihts[0] = 0;
        newHegihts[newHegihts.length - 1] = 0;
        for (int i = 1; i < heights.length + 1; i++){
            newHegihts[i] = heights[i - 1];
        }

        for (int i = 0 ; i < newHegihts.length; i++){
            while (!stack.isEmpty() && newHegihts[i] < newHegihts[stack.peek()]){
                int cur = stack.pop();
                int height = newHegihts[cur];
                int width =  i - stack.peek() - 1;
                int area = height * width;
                res = Math.max(res, area);
            }

            stack.push(i);
        }

        return res;
    }

    /*单调栈法。目的在于找到当前柱子的左右两边都比自己小的柱子，所以是单调减的栈，要求栈顶是最大值*/
    public int largestRectangleAreaMethod(int[] heights){
//        用来保存结果
        int area = 0;
//        假设左右两个端点的柱子高度都是0
        int newHeight[] = new int[heights.length + 2];
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;
        for (int i = 0; i < heights.length; i++){
            newHeight[i + 1] = heights[i];
        }

        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for (int i = 1; i < newHeight.length; i++){
            if (newHeight[i] >= newHeight[stack.peek()]){
                stack.push(i);
            }
            else if (newHeight[i] < newHeight[stack.peek()]){
                while (newHeight[i] < newHeight[stack.peek()] && !stack.isEmpty()){
                    int h = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int w = i - stack.peek() - 1;
                        area = Math.max(area, newHeight[h] * w);
                    }
                }
                stack.push(i);
            }
        }
        return area;
    }
}
