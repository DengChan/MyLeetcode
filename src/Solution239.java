import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return new int[]{};

        ArrayDeque<Integer> dequeue = new ArrayDeque<>(k);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // 如果当前最大值是窗口前一个元素，则把此元素从队列删除
            if(i>=k && dequeue.getFirst() == i-k) dequeue.pollFirst();

            // 如果当前元素大于之前的元素， 则之前的元素 永无出头之日
            while (!dequeue.isEmpty() && nums[i]>=nums[dequeue.peekLast()]) dequeue.pollLast();

            // 添加当前元素至队列
            dequeue.add(i);

            if(i>=k-1) res.add(nums[dequeue.peekFirst()]);

        }
        int[] ans = new int[res.size()];
        for(int i =0;i<res.size();i++) ans[i] = res.get(i);
        return ans;


    }
}
