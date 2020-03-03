package NumberSum;

import java.util.Arrays;

public class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        int ans=99999999;
        int minus = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            int L = k+1;
            int R = nums.length-1;
            while (L<R){
                int tmp = nums[k] + nums[L] + nums[R];
                if(Math.abs(tmp-target)<minus) {
                    ans = tmp;
                    minus = Math.abs(tmp-target);
                }
                if(tmp==target) break;
                else if(tmp<target) L++;
                else R--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(nums,-1));
    }
}
