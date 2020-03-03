package Offer;

import java.util.Arrays;
import java.util.Stack;

public class Solution05 {
    public String replaceSpace(String s) {
        if(s.length()<1) return s;
        int ns = 0;
        for(char c: s.toCharArray()){
            if(c==' '){
                ns++;
            }
        }
        char[] newS = new char[s.length() + ns*2+1];
        int i = 0;
        int j = 0;
        while (i<s.length()){
            if(s.charAt(i)!=' ') {
                newS[j++] = s.charAt(i);
            }
            else {
                newS[j++] = '%';
                newS[j++] = '2';
                newS[j++] = '0';
            }
            i++;
        }
        newS[j] = '\0';
        return new String(newS);
    }
}
