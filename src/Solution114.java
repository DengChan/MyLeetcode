public class Solution114 {
    public void flatten(TreeNode root) {
        while (root!=null){
            if(root.left==null){
                root = root.right;
            }
            else {
                TreeNode pre = root.left;
                while (pre.right!=null) pre =pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    private TreeNode flattenHelper(TreeNode root){
        if (root == null) return null;

        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        TreeNode p = left;
        if(p==null) {
            return root;
        }
        while (p.right!=null) p = p.right;
        p.right = right;
        root.left = null;
        root.right = left;
        return root;
    }
}
