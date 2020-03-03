import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution406 {
    public Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
        }
    };
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, cmp);
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] person : people){
            list.add(person[1],person);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
