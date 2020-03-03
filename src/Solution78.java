import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution78 {
    public  static  List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            travels(nums,list);
            list.remove(0);
        }
        ans.add(new ArrayList<>());
        return ans;
    }

    private static void travels(int[] nums, List<Integer> list){
        ans.add(new ArrayList<>(list));
        int last = list.get(list.size()-1);
        for (int i = 0;i<nums.length;i++){
            if(nums[i]<=last) continue;
            list.add(nums[i]);
            travels(nums,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> ans = subsets(a);
        for(List<Integer> list:ans){
            for(int k : list) System.out.print(k + " ");
            System.out.println();
        }

    }
}
