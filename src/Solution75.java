public class Solution75 {
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int cur = 0;
        int p1 = nums.length-1;
        while (cur<=p1){
            if(nums[cur]==0){
                swap(p0,cur,nums);
                cur++;
                p0++;
            }
            else if(nums[cur]==2){
                swap(cur,p1,nums);
                p1--;
            }
            else cur++;
        }
    }
    private static void swap(int i, int j,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a ={2,0,2,1,1,0};
        sortColors(a);
        for (int k: a) System.out.print(k+" ");
    }
}
