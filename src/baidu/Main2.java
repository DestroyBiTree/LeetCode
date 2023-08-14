package baidu;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String target = "Baidu";
        for (int i = 0; i < n; i++){
            String s = scanner.next();
            char sChar[] = s.toCharArray();
            if (s.length() != 5){
                System.out.println("No");
            }
            else {
                boolean flag = true;
                HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
                for (int j = 0; j < s.length();j++){
                    char c = sChar[j];
                    if (target.indexOf(c) >= 0){
                        if (charCount.containsKey(c)){
                            System.out.println("No");
                            flag = false;
                            break;
                        }
                        else {
                            charCount.put(c,1);
                        }
                    }
                    else {
                        System.out.println("No");
                        flag = false;
                        break;
                    }

                }
                if (flag)
                System.out.println("Yes");

            }
        }
    }
}
