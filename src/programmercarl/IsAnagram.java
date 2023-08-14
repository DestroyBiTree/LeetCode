package programmercarl;

import java.util.Arrays;

//242. 有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char sTimes [] = new char[58];
        char tTimes [] = new char[58];
        for (int i = 0; i < s.length(); i++) {
            sTimes[s.charAt(i) - 'A']++;

        }
        for (int i = 0; i < t.length(); i++) {
            tTimes[t.charAt(i) - 'A']++;
        }
        if (Arrays.equals(sTimes,tTimes)) {
            return true;
        }
        else {
            return false;
        }
    }
}
