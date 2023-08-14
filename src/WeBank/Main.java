package WeBank;

import java.util.Scanner;
//给出四个非负整数L,R,X,Y，请计算有多少个非负整数N满足以下四个条件：
//
//        1. N的二进制表示中1的个数不小于L
//
//        2. N的二进制表示中1的个数不大于R
//
//        3. N和X的按位与为X
//
//        4. N和Y的按位或为Y
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int ans = 0;
            for (int j = 0; j <= y; j++) {
                int yu = j & x;
                int huo = j | y;
                if (yu == x && huo == y) {
                    if (countOnes(j) >= l && countOnes(j) <= r) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }

    }

    private static int countOnes(int num) {
        int count= 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;

        }
        return count;
    }
}
