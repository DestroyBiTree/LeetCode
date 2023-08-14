package HuaWei;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int [][] tasks = new int[n][2];
        int max_size = 0;
        for (int i = 0; i < n; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
            max_size = Math.max(max_size, tasks[i][1] + 1);
        }

        int sum = 0;
        int [] energy = new int[max_size];
        int [] diff = new int[max_size];

        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            diff[start] += 1;
            if (end + 1 < max_size) {
                diff[end + 1] -= 1;
            }
        }

        energy[0] = diff[0];
        for (int i = 1; i < max_size; i++) {
            energy[i] = energy[i - 1] + diff[i];
        }

        int tag = 0;
        for (int i = 0; i < max_size; i++) {
            if (energy[i] != 0) {
                tag = 1;
            } else if (tag == 0) {
                continue;
            }

            if (energy[i] == 0) {
                sum += 1;
            } else if (energy[i] == 1) {
                sum += 3;
            } else {
                sum += 4;
            }
        }


        System.out.println(sum);

    }
}
