package baidu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        StringBuilder sb = new StringBuilder();
        if (x == 1){
            System.out.println("r");
        }
        if (x % 7 == 0){
            while (x/7 > 0) {
                sb.append("rreed");
            }
        }


    }

}
