import java.util.HashMap;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans =0, i=0;
        int n = s.length();
        for(int j=0; j<n; j++)
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(map.get(ch),i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(ch,j+1);

        }
        return ans;

    }

    public static void main(String[] args){
        String s = "abcbabcde";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
