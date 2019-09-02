import java.util.*;

public class Solution {
    public static Stack<Integer> stack = new Stack<>();
    public static Queue<Integer> queue = new LinkedList<>();
    public static boolean isValid(String s) {
        if(s.length()%2==1) return false;
        char s0 = s.charAt(0);
        if(s0=='}'||s0==']'||s0==')') return false;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='[') stack.push(ch);
            else if(ch==')'||ch=='}'||ch==']'){
                if(stack.empty()) return false;
                if(stack.pop()!=map.get(ch)) return false;
            }
        }

        return stack.empty();
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l;
        ListNode head;

        if(l1==null&&l2==null) return null;
        else if(l1!=null&&l2==null) return l1;
        else if(l2!=null&&l1==null) return l2;

        if(l1.val<l2.val) {l=l1;head=l1;l1 = l1.next;}
        else {l = l2;head=l2;l2 = l2.next;}
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val) {l.next = l1;l1 = l1.next; }
            else {l.next=l2; l2 = l2.next;}
            l=l.next;
        }
        while (l1!=null){l.next = l1;l1= l1.next;l = l.next;}
        while (l2!=null){l.next = l2;l2= l2.next;l = l.next;}
        return head;
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()<1) return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1 = expandMid(s,i,i);
            int len2 = expandMid(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>(end-start+1)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expandMid(String s,int left, int right){
       while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
           left--;
           right++;
       }
       return right-left-1;

    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int[] max = new int[n];
        max[0] = nums[0];
        int res = Math.max(max[0],-(int)Math.pow(2,31));
        for(int i=1;i<nums.length;i++){
            max[i] = Math.max(max[i-1]+nums[i], nums[i]);
            res = Math.max(max[i],res);
        }
        return res;
    }

    public static int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 2;
        for(int i=3;i<=n;i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l=0;
        int r = height.length-1;
        while (l<r){
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxArea;
    }

    public boolean isSymmetric(TreeNode root) {
        return travals(root,root);
    }
    private boolean travals(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null) return true;
        if(root1==null||root2==null) return false;
        return (root1.val==root2.val&&travals(root1.left,root2.right)&&travals(root1.right,root2.left));

    }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            res = Math.max(res,prices[i]-min);
            if(prices[i]<min) min = prices[i];
        }
        return res;
    }


    public static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits.length()==0) return list;
        char[] c2 = {'a','b','c'};
        char[] c3 = {'d','e','f'};
        char[] c4 = {'g','h','i'};
        char[] c5 = {'j','k','l'};
        char[] c6 = {'m','n','o'};
        char[] c7 = {'p','q','r','s'};
        char[] c8 = {'t','u','v'};
        char[] c9 = {'w','x','y','z'};
        char[][] cc={c2,c3,c4,c5,c6,c7,c8,c9};

        String str = "";
        combine(digits,str,list,cc);
        return list;
    }
    private static void combine(String digits,String str, List<String> l,char[][] cc){
        if(digits.length()==1){
            int digit = (int)digits.charAt(0) - (int)('0');
            for(int i=0;i<cc[digit-2].length;i++){
                l.add(str+cc[digit-2][i]);
            }
        }
        else {
            int digit = (int)digits.charAt(0) - (int)('0');
            for(int i=0;i<cc[digit-2].length;i++){
                combine(digits.substring(1),str+cc[digit-2][i],l,cc);
            }
        }
    }


    //19. 删除倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return null;
        ListNode p = head;
        ListNode q = head;
        ListNode pre = head;
        boolean first = true;
        while (n--!=0) q = q.next;

        while (q!=null){
            q = q.next;
            p = p.next;
            if(first) first = false;
            else pre = pre.next;
        }
        if(p!=head) pre.next = p.next;
        else return head.next;

        return head;
    }

    //22.括号生成
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if(n==0) {
            ans.add("");
            return ans;
        }
        for(int c=0;c<n;c++){
            for(String left : generateParenthesis(c)){
                for (String right: generateParenthesis(n-c-1)){
                    ans.add("("+left+")"+right);
                }
            }
        }
        return ans;
    }


    public static void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        permutation(nums,0,nums.length-1);
    }
    private static boolean permutation(int[] nums, int s, int e){
        if (e-s<=0) return false;
        boolean flag  = permutation(nums,s+1, e);
        if(flag) return flag;
        if(nums[s]<nums[s+1]){
            flag = true;
            int tmp = nums[s];
            nums[s]=nums[s+1];
            nums[s+1] = tmp;
            return flag;
        }
        for(int i=s;i<e;i++){
            if(nums[i]>nums[i+1]){
                int tmp = nums[i];
                nums[i]=nums[i+1];
                nums[i+1] = tmp;
            }

        }
        return flag;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums.length<1) return ans;

        int left_bound = findBound(nums,target,true);

        // 当目标值为第一个元素时，即索引值为0，无法判断此时0是左边界还是表示目标值比最小值还小，需要通过值来判断
        if(left_bound==nums.length||nums[left_bound]!=target) return ans;
        int right_bound = findBound(nums,target,false)-1;
        ans[0] = left_bound;
        ans[1] = right_bound;
        return ans;

    }

    private static int findBound(int[] nums,int target, boolean left){
        int l = 0;
        int h = nums.length;

        while (l<h){
            int m = (l+h)/2;
            if(target<nums[m]|| (left && target==nums[m])){
                h = m;
            }else{
                l = m+1;
            }
        }

        return l;
    }

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        addElement(candidates, list, 0, target, 0);
        return res;
    }

    private static void addElement(int[] candidates, List<Integer> candidate_list, int sum, int target, int index){
        if(sum>target) return;
        if(sum==target) {
            List<Integer> r = new ArrayList<>(candidate_list);
            res.add(r);
        }
        if(candidates[index]>target-sum) return;
        for(int i =index;i<candidates.length;i++){
            candidate_list.add(candidates[i]);
            addElement(candidates, candidate_list, sum+candidates[i], target, i);
            candidate_list.remove(candidate_list.size()-1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Boolean[] map = new Boolean[nums.length];
        for(int i=0;i<nums.length;i++) map[i] = false;
        tranverse(nums, list, map);
        return res;
    }
    private static void tranverse(int[] nums, List<Integer> list, Boolean[] map){
        if(list.size()==nums.length){
            List<Integer> r = new ArrayList<>(list);
            res.add(r);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!map[i]) {
                list.add(nums[i]);
                map[i] = true;
                tranverse(nums,list, map);
                map[i] = false;
                list.remove(list.size()-1);
            }

        }
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i;j++){
                int row = i;
                int col = j;
                int r = 4;
                int last = matrix[row][col];
                while (r!=0){
                    r--;
                    int next_row = col;
                    int next_col = -row + n-1;
                    int next = matrix[next_row][next_col];
                    matrix[next_row][next_col] = last;

                    row = next_row;
                    col = next_col;
                    last = next;

                }
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null||nums.length<3) return ans;

        Arrays.sort(nums);


        for (int i=0;i<=nums.length-3;i++){
            int a = nums[i];
            // 如果a>0 则后续不可能组成0
            if(a>0) break;

            // 去重
            if(i> 0 && nums[i]==nums[i-1]) continue;

            int L = i+1;
            int R = nums.length-1;

            while (L<R){
                int sum = a + nums[L] + nums[R];
                if(sum<0) L++;
                else if(sum>0) R--;
                else {
                    ans.add(Arrays.asList(a,nums[L],nums[R]));
                    L++;
                    R--;
                    while (L<R && nums[L]==nums[L-1]) L++;
                    while (L<R && nums[R]==nums[R+1]) R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] a ={1,2,-2,-1};
        List<List<Integer>> r = new ArrayList<>();
        r = threeSum(a);
        for (List<Integer> l : r){
            for(Integer i: l){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        System.out.println(r.size());

    }


}
