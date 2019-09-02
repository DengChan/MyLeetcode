import java.util.Arrays;

public class Solution64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<1||n<1) return 0;
        int[] sum = new int[n];
        sum[0] = grid[0][0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + grid[0][i];
        }

        for(int i=1;i<m;i++)
        {
            sum[0] = grid[i][0]+sum[0];
            for(int j=1;j<n;j++){
                sum[j] = Math.min(sum[j-1]+grid[i][j],sum[j] + grid[i][j]);
            }
        }
        return sum[n-1];
    }

    public static void main(String[] args) {
        int[][] a ={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(a));
    }
}
