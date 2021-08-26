public class maximumDepthOfBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0 ;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if(ldepth > rdepth)
            return (ldepth+1) ;
        else return (rdepth+1);
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3) ;
        tn.right = new TreeNode(20) ;
        tn.right.right = new TreeNode(7) ;
        tn.right.left = new TreeNode(15) ;
        tn.right.left.right = new TreeNode(15) ;
        tn.left = new TreeNode(1);
        System.out.println("maxDepth(tn) = " + maxDepth(tn));
    }
}
