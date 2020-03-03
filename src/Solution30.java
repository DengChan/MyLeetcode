import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s.length()==0||words.length==0) return ans;
        int word_len = words[0].length();
        int word_num = words.length;
        if(word_len*word_num>s.length()) return ans;
        HashMap<String , Integer> hasMap = new HashMap<>();
        for(String word : words) hasMap.put(word,hasMap.getOrDefault(word,0)+1);

        // 以i为子串起点, 但i只能到word_len-1,否则可能出现重复解,
        // 比如有些窗口left 缩减到 >= word_len  这相当于又遍历了一遍
        for(int i=0;i<word_len;i++){

            int left = i; // 窗口左边界
            int right = i; // 窗口右边界
            int n=0;
            HashMap<String, Integer> counter = new HashMap<>();//记录单词个数
            // 不断扩大右边界
            while (right+word_len<=s.length()){
                String tmp_word = s.substring(right, right+word_len);
                // 如果出现了words 以为的单词，则直接把窗口左边界移到该单词后面，并清空counter
                if(!hasMap.containsKey(tmp_word)){
                    right += word_len;
                    left = right;
                    counter.clear();
                    n=0;
                }
                else {
                    counter.put(tmp_word,counter.getOrDefault(tmp_word,0)+1);
                    n++;
                    // 如果出现了多余的单词，则缩小左边界 直到不再重复
                    while (counter.get(tmp_word)>hasMap.getOrDefault(tmp_word,0)){
                        String rm_word = s.substring(left,left+word_len);
                        counter.put(rm_word,counter.get(rm_word)-1);
                        n--;
                        left += word_len;
                    }
                    right+=word_len;
                    if(n==word_num) {
                        ans.add(left);
                    }
                }

            }
        }
        return ans;

    }
}
