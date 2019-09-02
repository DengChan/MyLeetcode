import java.math.BigInteger;

public class Solution96 {
    public static int numTrees(int n) {
       int[] h = new int[n+1];
       h[0] = 1;
       h[1] = 1;
       for(int i=2;i<=n;i++){
           h[i] = 0;
           for(int j =0;j<i;j++){
               h[i] += h[j]*h[i-1-j];
           }
       }
       return h[n];
    }


    public static void main(String[] args) {
        System.out.println(numTrees(20));
    }
}
