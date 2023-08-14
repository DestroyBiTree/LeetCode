package medium;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {

    }

    public boolean wordBreakMethod(String s, List<String> wordDict){
        //dp表示长度为i的单词是否可以拆分成字典里的单词
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i && !dp[i]; j++){
                if (dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
