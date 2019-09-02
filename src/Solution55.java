import java.util.Arrays;

public class Solution55 {
    /*顺藤摸瓜,每次更新能达到的最远距离即可*/
    public static boolean canJump(int[] nums) {
        int l = nums.length;
        if(l<1) return false;
        int reach = 0;
        for(int i=0;i<l;i++){
            // 如果i超过了到达的边界 则表示不能到达i 失败
            if (i>reach) break;
            if (i == l-1 && reach>=l-1){
                return true;
            }
            reach = Math.max(reach, i+nums[i]);
            if(reach>=l-1) {
                return true;
            }
        }
        return false;

    }

    /*如果数组里边没有 0，那么无论怎么跳，一定可以从第 0 个跳到最后一个位置。
    所以我们只需要看 0 的位置，如果有 0 的话，我们只需要看 0 前边的位置，能不能跳过当前的 0 ，
    如果 0 前边的位置都不能跳过当前 0，那么直接返回 false。如果能的话，就看后边的 0 的情况。
    */
    public static boolean canJump2(int[] nums){
        int l = nums.length;
        if(l<1) return true;
        for(int i=0;i<l;i++){
            if(nums[i]==0){
                int j=i-1;
                boolean canReach = false;
                while (j>=0){
                    if(j+nums[j]>i) {
                        canReach = true;
                        break;
                    }
                    j--;
                }
                if(!canReach) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(canJump2(a));
    }
}
