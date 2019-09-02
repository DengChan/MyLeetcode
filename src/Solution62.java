import java.util.Arrays;

public class Solution62 {
    public static int uniquePaths(int m, int n) {
        if(m<=1 && n<=1) return 0;
        if(m==1 || n==1) return 1;
        int[][] pathCnt = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) pathCnt[i][j] = 0;
        }
        pathCnt[0][0] = 0;
        pathCnt[0][1] =1;
        pathCnt[1][0]=1;
        dfs(0,0,m-1,n-1,pathCnt);
        return pathCnt[m-1][n-1];
    }

    private static int dfs(int x, int y, int m, int n, int[][] pathCnt){
        if(pathCnt[m-x][n-y]!=0) return pathCnt[m-x][n-y];
        int cnt = pathCnt[x][y];
        if(x+1<=m) cnt += dfs(0,0,m-1,n,pathCnt);
        if(y+1<=n) cnt += dfs(0,0,m,n-1,pathCnt);
        pathCnt[m-x][n-y] = cnt;
        return cnt;

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(14,8));
    }
}
