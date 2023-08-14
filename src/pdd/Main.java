package pdd;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char sChar[] = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(;i < sChar.length;){
            if (Character.isDigit(sChar[i])) {
                int j = i + 1;
                for (;j < s.length() && Character.isDigit(sChar[j]);) {
                    j++;
                }
                int nums = Integer.parseInt(s.substring(i, j));
                char hc = sChar[j];
                for (int q = 0; q < nums; q++) {
                    sb.append(hc);
                }
                i = j + 1;
            }
            else {
                sb.append(sChar[i]);
                i++;
            }
        }
        System.out.println(sb);
    }
}