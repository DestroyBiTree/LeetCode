package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[][] heal = new int[t][n];
        for (int i = 0; i < t; i++){
            for (int j = 0; j < n;j++){
                heal[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < t; i++){
            int countA = 0;
            int countB = 0;
            int remain[] = new int[n];

            for (int j = 0; j < n; j++){
                remain[j] = heal[i][j];
            }

            while (true){
                int maxIndex = -1;
                int maxHeal = -1;

                for (int j = 0; j < n; j++){
                    if (remain[j] > maxHeal){
                        maxIndex = j;
                        maxHeal = remain[j];
                    }
                }

                if (maxHeal <= 0){
                    break;
                }

                countB++;
                remain[maxIndex] = 0;
                for (int j  = 0; j < n; j++){
                    if (remain[j] > 0){
                        countA++;
                        remain[j]--;
                    }
                }
            }
            countA++;
            countB++;
            System.out.println(Math.min(countA,countB));
        }
    }
}
