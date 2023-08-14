package hard;

import java.util.HashMap;
/*76.最小覆盖子串*/
/*
* 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。*/
/*思路为滑动窗口法*/
public class MinWindow {
    public static void main(String[] args) {
        minWindowMe("ABAACB","ABC");
    }
    public static String minWindowMe(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        char chas[] = s.toCharArray();
        //lr初始化
        int minL = 0,minR = slen;
        //如果s比t小直接返回空字符串
        if (slen < tlen) return "";
        //为什么是58？A 65 z122
        int tmap[] = new int[58];
        int winmap[] = new int[58];
        //统计t的词频
        for (int i = 0; i < tlen; i++){
            tmap[t.charAt(i) -'A']++;
        }
        //定义左右指针，count表示有效字符的数量
        int left = 0, right = 0, count = 0;
        while (right < slen){
        // ++winmap的意义在于r已经进入这个窗口了，所以这个字符的数量一定要+1
        //当r指针指向的这个字符进入窗口以后，当前这个字符数量小于t所需的数量时，有效数字加1
        //为什么是小于等于？等于的原因同样是已经自增一次了，所以判断相等时有效数字也加1
            if (++winmap[chas[right] - 'A'] <= tmap[chas[right] - 'A']) {count++;}
            //当有效数组和t的长度相等的时候，可以缩短窗口了
            while (count == tlen){
                //先记录下来当前的窗口是否变小了
                if (right - left < minR - minL){
                    minL = left;
                    minR = right;
                }
                //原来位置的left先减去一个数，即--winmap。
                //缩短窗口，查看是否去掉了一个有效数字。
                if (tmap[chas[left] - 'A'] > --winmap[chas[left] - 'A']){count--;}
                //无论如何l都已经左移了
                left++;
            }
            //每轮r都右移一位
            right++;
        }
        return minR == slen ? "" : s.substring(minL, minR + 1);
    }
}
