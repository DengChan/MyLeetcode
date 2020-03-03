package NumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4) return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target) continue;
                int L = j+1;
                int R = nums.length-1;
                while (L<R){
                    int sum = nums[i] + nums[j]+nums[L] + nums[R];
                    if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[L]);
                        temp.add(nums[R]);
                        ans.add(temp);
                        while (L<R && nums[L]==nums[L+1]) L++;
                        while (L<R && nums[R]==nums[R-1]) R--;
                        L++;
                        R--;
                    }
                    else if(sum<target){
                        L++;
                    }
                    else R--;
                }
            }
        }
        return ans;
    }
}
