package xiaohongshu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        for (char c :s.toCharArray()) {
            char des = (char) ('a' + (c - 'a' +23) % 26);
            sb.append(des);

        }
        System.out.println(sb.toString());
    }
}
