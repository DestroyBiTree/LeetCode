package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*3.无重复字符的最长子串长度*/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstringMeth2(s));
    }

    public int lengthOfLongestSubstringMeth(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, length = 0, maxLength = 0;
        while (right < s.length())
        {
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                if (maxLength < ++length)
                    maxLength = length;
                }
            else {
                while (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                    length--;
                }
                set.add(s.charAt(right++));
                length++;


            }
        }
        return maxLength;
    }
    public static int lengthOfLongestSubstringMeth2(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int end = 0,start = 0; end < n; end++){
            if (map.containsKey(chars[end])){
                start = Math.max(map.get(chars[end]),start);
            }
            ans = Math.max(ans,end - start + 1);
            map.put(chars[end],end + 1);
        }
        return ans;
    }
}
