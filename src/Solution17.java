import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    static  String [] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()<1) return ans;
        dfs(digits,"", ans);
        return ans;

    }
    private static void dfs(String digits, String cur, List<String> ans){
        if(digits.length()==1) {
            int num = digits.charAt(0)-'0';
            String map_s = map[num];
            for(char c:map_s.toCharArray()){
                ans.add(cur+c);
            }
        }
        else {
            int num = digits.charAt(0)-'0';
            String map_s = map[num];
            for(char c:map_s.toCharArray()){
                dfs(digits.substring(1),cur+c,ans);
            }
        }
    }

}
