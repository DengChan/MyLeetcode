import java.util.ArrayList;
import java.util.LinkedList;

public class Solution98 {
    public ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        InOrder(root);
        boolean flag = true;
        for (int i =1;i<list.size();i++){
            if (list.get(i)<list.get(i-1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    private void InOrder(TreeNode root){
        if (root==null) return;
        InOrder(root.left);
        list.add(root.val);
        InOrder(root.right);
    }
}
