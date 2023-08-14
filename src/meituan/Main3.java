package meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String colors = scanner.nextLine();
        int[] parent  = new int[n + 1];
        for (int i = 2; i <= n; i++){
            parent[i] = scanner.nextInt();
        }
        scanner.close();

        int[] redCount = new int[n + 1];
        int[] blueCount = new int[n + 1];
        int[] balanceCount = new int[n + 1];

        dfs(1,0,colors,parent,redCount,blueCount,balanceCount);
        System.out.println(balanceCount[1]);
    }

    private static void dfs(int cur, int parent, String colors, int[] tree, int []redCount, int[] blueCount, int[]balanceCount){
        if (colors.charAt(cur - 1) == 'R'){
            redCount[cur]++;
        }
        else {
            blueCount[cur]++;

        }

        for (int i = 2; i < tree.length; i++){
            if (tree[i] == cur){
                if (i != parent){
                    dfs(i,cur,colors,tree,redCount,blueCount,balanceCount);
                    redCount[cur] += redCount[i];
                    blueCount[cur] += balanceCount[i];
                }
            }
        }
        int redSubtree = redCount[cur];
        int blueSubtree = blueCount[cur];
        int redO = redCount[1] - redSubtree;
        int blueO = blueCount[1] - blueSubtree;
        if (redSubtree == blueO && blueSubtree == redO){
            balanceCount[cur]++;
        }
        balanceCount[cur] += balanceCount[parent];
    }
}
