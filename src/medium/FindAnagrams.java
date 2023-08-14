package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*438. 找到字符串中所有字母异位词*/
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
/*思路：滑动窗口法*/
/*固定窗口p的长度，用一个长度为26的数组去统计p中每个单词出现的次数，从左向右滑动，不停地判断窗口中的字符串是否是p的字母异位词即可*/
/**/
public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagramsMethod = findAnagrams.findAnagramsMethod(s, p);
        for (Integer list: anagramsMethod){
            System.out.println(list);
        }



    }
    public List<Integer> findAnagramsMethod(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() < p.length())
            return res;
        //counts表示p中每个字母出现的次数
        int counts[] = new int[26];
        char[] arrp = p.toCharArray();
        char[] arrs = s.toCharArray();
        for (int i = 0; i < p.length(); i++){
            //这个方法真是太妙了
            counts[arrp[i] - 'a']++;
        }
        //表示当前窗口中每个单词出现的次数
        int curCounts[] = new int[26];
        for (int i = 0; i < p.length() - 1; i++){
            curCounts[arrs[i] - 'a']++;
        }

        for (int left = 0, right = p.length() - 1; right < s.length(); right++, left++){
            curCounts[arrs[right] - 'a'] ++;
            if (Arrays.equals(curCounts,counts)){
                res.add(left);
            }
            curCounts[arrs[left] - 'a']--;
        }
        return res;

    }
}
