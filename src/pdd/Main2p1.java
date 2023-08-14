package pdd;

import java.util.Scanner;

public class Main2p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int[][] hp = new int[T][N];
        for (int i = 0; i < T; i++){
            for (int j = 0; j < N; j++){
                hp[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < T; i++){
            int aCount = 0;
            int BCount = 0;
            int [] remainHp = new int[N];
            System.arraycopy(hp[i], 0, remainHp,0,N);
            while (true){
                boolean alldead = true;
                for (int j = 0; j < N; j++){
                    if (remainHp[j] > 0){
                        alldead = false;
                        break;
                    }
                }
                if (alldead){
                    System.out.println(aCount + BCount);
                    break;
                }
                if (BCount > 0){
                    int target = findMaxHp(remainHp);
                    remainHp[target] = 0;
                    BCount--;
                }
                else {
                    int target1 = findMaxHp(remainHp);
                    remainHp[target1] = 0;
                    aCount++;

                    int target2 = findMaxHp(remainHp);
                    if (remainHp[target2] > 0){
                        remainHp[target2]--;
                        aCount++;
                    }

                }
            }
        }
    }

    private static int findMaxHp(int[] remainHp) {
        int maxHp = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0;i<remainHp.length;i++){
            if (remainHp[i] > maxHp){
                maxHp = remainHp[i];
                index = i;
            }
        }
        return index;
    }

}

