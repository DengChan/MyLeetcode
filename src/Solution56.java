import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0]==o2[0]) return 0;
            return o1[0]<o2[0]?-1:1;
        }

    };

    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, comparator);
        int[] last_set = intervals[0];
        int cnt = 1;
        for(int i=1;i<intervals.length;i++){
            int[] this_set = intervals[i];
            if(last_set[1]<this_set[0]){
                intervals[cnt][0] = this_set[0];
                intervals[cnt][1] = this_set[1];
                last_set = intervals[cnt++];
            }
            else {
                last_set[1] = Math.max(this_set[1],last_set[1]);
            }
        }

        int[][] ans = new int[cnt][2];
        for(int i=0;i<cnt;i++){
            ans[i] = intervals[i];
        }

        for (int i=0;i<ans.length;i++) {
            for(int k:ans[i]){
                System.out.print(k+" ");
            }
            System.out.println("");
        }
        return intervals;
    }

    public static void main(String[] args) {

        int[][] d = {{}};
        merge(d);
    }
}
