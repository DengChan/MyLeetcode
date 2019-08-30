import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;

        }
        return ans;
    }
    private static void recursive(TreeNode root,List<Integer> list){
        if (root == null) return;
        recursive(root.left,list);
        list.add(root.val);
        recursive(root.right,list);
    }


    public static void main(String[] args) {

    }
}
