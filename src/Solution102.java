import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return ans;
        dfs(root,0);
        return ans;
    }
    private void dfs(TreeNode root,int level){
        // 遇到了该层的左侧第一个结点
        if(level==ans.size()) ans.add(new ArrayList<>());

        // 获得该层的list,并加入该结点的值
        ans.get(level).add(root.val);
        if(root.left!=null) dfs(root.left,level+1);
        if(root.right!=null) dfs(root.right, level+1);

    }

}
