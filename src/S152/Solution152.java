package S152;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int tmp = imax;
                imax = imin;
                imin = imax;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            if(imax > res) res = imax;
        }
        return res;
    }
}
