package mhy;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int k = 0; k < n; k++) {
            in.nextLine();
            String s = in.nextLine();
            String t = in.next();
            String s1 = removeChar(s);
            String s2 = removeChar(t);
            if (s1.equals(s2)) {
                System.out.println("Yes");
            }
            else
                System.out.println("No");

        }
    }

    public static String removeChar(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char currChar = str.charAt(i);
            if (currChar != 'm' && currChar != 'h' && currChar != 'y'){
                sb.append(currChar);
            }
        }
        return sb.toString();
    }
}
