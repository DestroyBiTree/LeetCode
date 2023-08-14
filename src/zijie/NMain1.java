package zijie;

import java.util.Scanner;

public class NMain1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (k != 0) {
            int n = scanner.nextInt();
            if (n % 4 == 0 && n > 4) {
                System.out.println("yes");
            } else {

                System.out.println("no");
            }
            k--;
        }

    }
}
