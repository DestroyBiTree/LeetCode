package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++){
            end[i] = scanner.nextInt();
        }

        int[] times = new int[2 * n];
        int cout = 0;
        for (int i = 0; i < n;i++){
            times[cout++] = start[i];
            times[cout++] = end[i] + 1;
        }

        Arrays.sort(times);

        int maxMeteor = 0;
        int maxTime = 0;
        int currentMeteor = 0;
        int currentTime = 0;
        for (int i = 0; i < 2 * n; i++){
            if (i == 0 || times[i] != times[i - 1]){
                if (currentMeteor > maxMeteor){
                    maxMeteor = currentMeteor;
                    maxTime = currentTime;
                }
                currentTime = times[i];
            }
            if (i % 2 ==0){
                currentMeteor++;
            }
            else {
                currentMeteor--;
            }
        }
        System.out.println(maxMeteor + " "+ maxTime);
    }

}
