package easy;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] sChar = s.toCharArray();
        int cout = 0;

        for (int i = 0; i < sChar.length - 1; i++) {
            int num = 0;
            for ( int j = i; sChar[j] == sChar[j + 1]; j++){
                num++;
                i = j;
                if (j + 1 == sChar.length - 1){
                    break;
                }
            }
            num++;
            if (num % 2 == 0){
                cout += num / 2;
            }
            else {
                cout += (num - 1) / 2;
            }
        }
        System.out.println(cout);
    }

}
/*请使用java解答以下问题：
给定一个由数字组成的字符串s，s的长度在1到100000之间。
可以将字符串s内任意位置的字符改成任意的数字字符，
至少需要多少次修改，才能让修改后的字符串s不包含两个连续相同的字符？*/