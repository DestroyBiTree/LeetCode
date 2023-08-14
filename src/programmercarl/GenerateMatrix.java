package programmercarl;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        //转了几圈，如果是奇数需要单独处理中心点
        int [][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n / 2;
        int count = 1;
        //每个圈的偏移量，过一圈就缩小一个
        int offset = 1;
        int i = 0, j = 0;
        while (loop -- > 0) {
            //每次循环前都确定从哪里开始赋值
             i = startx; j = starty;
            //先从左往右
            for (j = starty; j < n - offset; j++) {
                res[startx][j] = count++;
            }
            //从上往下
            for (i = startx; i < n - offset; i++) {
                res[i][j] = count++;
            }
            //从右往左
            for (;j >= startx; j--) {
                res[i][j] = count++;
            }
            //从下往上
            for (;i >= starty; i--) {
                res[i][j] = count++;
            }

            startx++;
            starty++;
            offset++;
        }
        //给中心点赋值
        if (n % 2 == 1) {
            res[n / 2][n / 2] = n * n;
        }
        return  res;
    }
}
