package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] r = new int[n];
        for (int i = 0; i < n; i++){
            r[i] = scanner.nextInt();
        }

        double[] avg = new double[n];
        double[] med = new double[n];
        for (int i = 0;i < n; i++){
            double sum = 0;
            for (int j = 0; j < i; j++){
                sum += r[j];
            }

            avg[i] = sum/(i + 1);

            int[] tmp = Arrays.copyOf(r,1 + i);
            Arrays.sort(tmp);
            if ((i + 1) % 2 == 1){
                med[i] = tmp[(i + 1) / 2];

            }
            else {
                med[i]  = (tmp[i/2] + tmp[(i/2) + 1])/2.0;
            }
        }

        for (int i = 0; i < n; i++){
            System.out.println(Math.round(avg[i]) + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++){
            System.out.println(Math.round(med[i]) + " ");
        }
        System.out.println();
    }
}
