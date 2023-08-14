package medium;
/*11盛水最多的容器*/
public class MaxArea {
    public static void main(String[] args) {
    MaxArea maxArea = new MaxArea();
    int[] height = new int[]{1,3,2};
        System.out.println(maxArea.maxAreaMeth(height));
    }

    public int maxAreaMeth(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1, max = 0, curAre = 0;
        while (j != i ){

            if ( height[j] < height[i]){
                curAre = height[j] * (j - i);
                max = curAre > max ? curAre : max;
                j--;
            }
            else {
                curAre = height[i] * (j - i);
                max = curAre > max ? curAre : max;
                i++;
            }
        }

        return max;
    }
}
