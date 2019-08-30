package S139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // 用于表示以第i个位置结尾的子串(从1开始) 能否由词表组合
        boolean[] dp = new boolean[s.length()+1];
        // 认为空串为词表的一个,dp的真正起始为1
        dp[0] = true;
        // 从头遍历所有子串,计算dp[i]
        // 把s[0:i]拆分为s[0:j] s[j+1:i]
        // 如果s[0:j]可以被词表组合而成 即dp[j]==true
        // 同时 词表包括s[j+1:i] 则s[0:i] 也可以被词表组合而成 设置dp[i]为true
        for(int i=1;i<=s.length();i++){
            // 注意 dp是从1开始 表示到第一个字符组成的子串能否由词表组成
            // 而substring 是从0开始,当j=1 时 substring是从第二个字符开始的 都使用j刚好符合我们的题意
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }


    public static void main(String[] args) {
        String s = "catsandog";
        String[] d = {"cats", "dog", "san", "and", "cat"};
        List<String> wordDict = new ArrayList<String>(Arrays.asList(d));
        System.out.println(wordBreak(s,wordDict));
    }

}
