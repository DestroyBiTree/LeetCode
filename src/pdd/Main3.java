package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] pre = new int[n][3];
        for (int i = 0; i < n; i++){
            String s = scanner.next();
            for (int j = 0;j < s.length(); j++){
                if (s.charAt(j) == 'A'){
                    pre[i][0] = 1;

                }
                else if (s.charAt(j) == 'B'){
                    pre[i][1] = 1;
                }
                else if (s.charAt(j) == 'C'){
                    pre[i][2] = 1;
                }
            }
        }
        int [][] act = new int[3][2];
        for (int i = 0; i < 3; i++){
            act[i][0] = scanner.nextInt();
            act[i][1] = scanner.nextInt();
        }

        int[] ass = new int[n];
        Arrays.fill(ass,-1);
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < n; i++){
                if (ass[i] == -1){
                    int [] p = pre[i];
                    int minCos = Integer.MAX_VALUE;
                    int minAct = -1;
                    for (int j = 0; j < 3; j++){
                        if (p[j] == 1 && act[j][0] > 0 && act[j][1] < minCos){
                            minCos = act[j][1];
                            minAct = j;
                        }
                    }
                    if (minAct != -1){
                        ass[i] = minAct;
                        act[minAct][0]--;
                        act[minAct][1]+=minCos;
                        flag = true;
                    }
                }
            }
        }

        boolean succ = true;
        for (int i = 0; i < n; i++){
            if (ass[i] == -1){
                succ = false;
                break;
            }
        }

        if (succ){
            System.out.println("YES");
            int total = 0;
            for (int i = 0; i < 3; i++){
                total += act[i][1];
            }
            System.out.println(total / 2);
        }
        else {
            System.out.println("NO");
            int maxAss = 0;
            for (int i = 0; i < 3; i++){
                int assSign = 0;
                for (int j = 0; j < n; j++){
                    if (ass[j] == i){
                        assSign++;
                    }
                }
                maxAss = Math.max(maxAss,assSign);
            }
            System.out.println(maxAss * 2);
        }
    }
}
