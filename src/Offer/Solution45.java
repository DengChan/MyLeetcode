package Offer;

import java.util.*;

public class Solution45 {
    static  Comparator<String> cmp = (o1, o2) -> (o1+o2).compareTo(o2+o1);
    public static String minNumber(int[] nums) {
        if(nums==null) return "";
        if(nums.length<1) return "";
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        ;
        for(int num:nums) list.add(String.valueOf(num));
        String [] strs = list.toArray(new String[list.size()]);
        Arrays.sort(strs, cmp);
        StringBuffer sb = new StringBuffer();
        for(String str:strs) sb.append(str);
        String res = sb.toString();
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {10,2};
        System.out.println(minNumber(nums));
    }

}
