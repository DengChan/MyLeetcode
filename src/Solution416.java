public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if (sum%2 == 1) return false;
        int target = sum/2;
        boolean[][] dp =new boolean[nums.length][target+1];
        for(int i=0;i<nums.length;i++) dp[i][0] = true;
        dp[0][nums[0]] = true;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<target+1;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i]<=j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
