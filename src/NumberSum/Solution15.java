package NumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3) return ans;
        Arrays.sort(nums);

        for (int k=0;k<nums.length-1;k++){
            if(nums[k]>0) break;
            // 这里一定是nums[k]==nums[k-1]
            // 考虑 [-1,0,0,0]的情况 如何去重
            // 与前一个元素相同，说明固定前一个元素的解已经得到了，不需要再遍历了
            if(k>0&&nums[k]==nums[k-1]) continue;
            int front = k+1;
            int back = nums.length-1;
            int target = 0-nums[k];
            while (front<back){

                if(nums[front]+nums[back]==target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[k]);
                    tmp.add(nums[front]);
                    tmp.add(nums[back]);
                    ans.add(tmp);
                    while (front<back&&nums[front]==nums[front+1]) front++;
                    while (front<back&&nums[back]==nums[back-1]) back--;
                    front++;
                    back--;
                }
                else if(nums[front]+nums[back]<target){
                    front++;
                }
                else {
                    back--;
                }
            }

        }
        return ans;
    }
}
