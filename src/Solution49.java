import java.util.*;

public class Solution49 {

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new LinkedList<>();
        if (strs.length==0) return ans;
        Boolean[] used = new Boolean[strs.length];
        for(int i=0;i<strs.length;i++) used[i] =false;
        for(int i=0;i<strs.length;i++){
            if (used[i]) continue;
            List<String> tmp = new LinkedList<>();
            tmp.add(strs[i]);
            used[i] = true;
            for(int j = i+1;j<strs.length;j++){
                if(used[j]) continue;
                if(equal(strs[i],strs[j])){
                    tmp.add(strs[j]);
                    used[j] = true;
                }
            }
            ans.add(tmp);
        }
        return ans;

    }

    private static Boolean equal(String s1, String s2){
        if (s1.length()!=s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
            else {
                map.put(s1.charAt(i),1);
            }
        }

        for(int i=0;i<s2.length();i++){
            if (!map.containsKey(s2.charAt(i))) return false;
            map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
        }
        for(Character c:map.keySet()){
            if(map.get(c)!=0) return false;
        }
        return true;


    }

    public static List<List<String>> groupAnagrams2(String[] strs){
        if (strs.length<1) return new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        int[] cnt = new int[26];
        for(String str : strs){
            Arrays.fill(cnt,0);
            for(char c: str.toCharArray()) cnt[c-'a'] +=1;
            StringBuilder countS = new StringBuilder("");

            for (int i=0;i<26;i++)
            {
                countS.append(cnt[i]);
                countS.append('#');
            }
            String S = countS.toString();
            if (!map.containsKey(S)) map.put(S,new ArrayList<>());
            map.get(S).add(str);

        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams3(String[] strs){
        if (strs.length<1) return new ArrayList<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer,List<String>> map = new HashMap<>();
        for(String str: strs){
            int key = 1;
            for(char c: str.toCharArray()) key = key * (prime[c-'a']);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());

    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams3(strs);
        for (List<String> lst: ans){
            for(String s : lst){
                System.out.println(s);
            }
            System.out.println("=================================================");
        }

    }
}
