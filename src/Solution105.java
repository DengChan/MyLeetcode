import java.util.HashMap;

public class Solution105 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
        if(pstart == pend) return null;
        int root_val = preorder[pstart];
        TreeNode root = new TreeNode(root_val);
        int root_inorder_index = map.get(root_val);
        int leftnum = root_inorder_index-istart;
        // 左子树
        root.left = buildTreeHelper(preorder,pstart+1,pstart+1+leftnum, inorder, istart,root_inorder_index);
        root.right = buildTreeHelper(preorder,pstart+1+leftnum, pend, inorder,root_inorder_index+1, iend);
        return root;


    }
}
