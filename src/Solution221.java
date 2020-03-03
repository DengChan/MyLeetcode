/*
动态规划，令dp[i][j]表示以[i,j]为右下角的最大正方形面积,思考如下几个情形:
1. 如果matrix[i][j] = 0 , 那么dp[i][j] 一定等于0
2. 如果matrix[i][j] = 1,且i或j处于边界上,显然dp[i][j]=1
3. 如果matrix[i][j] = 1, i和j都不处于边界上,那么观察上，左 和 左上的dp
    3.1 如果dp[i-1][j-1] ==0 或者 dp[i-1][j] == 0 或者 dp[i][j-1]==0 那么无法组成正方形 dp[i][j] = 1
    3.2 如果他们都不等于0， 那么 dp[i][j] 为 三者最小的面积 再往外扩大一格的面积
* */

public class Solution221 {
    static int res = 0;
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length<1) return 0;
        if(matrix[0].length<1) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                update(matrix,dp,i,j);
            }
        }
        return res;
    }
    private static void update(char[][] matrix, int[][] dp, int i, int j){
        if(matrix[i][j] == '0') dp[i][j] = 0;
        else if(i-1<0||j-1<0) dp[i][j]=1;
        else if(dp[i-1][j-1]==0||dp[i-1][j]==0||dp[i][j-1]==0) dp[i][j] = 1;
        else{
            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
            dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);
            int l =(int) Math.sqrt((double)dp[i][j]);
            dp[i][j] = (l+1)*(l+1);
        }
        if(dp[i][j]>res) res = dp[i][j];
    }

    public static void main(String[] args) {
        char[][] m= {{'0','1','1','0'},
                    {'1','1','1','1'},
                    {'1','1','1','1'},
                    {'1','1','1','1'}};
        System.out.println(maximalSquare(m));
    }
}
