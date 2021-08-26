import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class tree_postorderIterativeWalk {

      public static class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
             this.left = left;
           this.right = right;
          }
     }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> output = new ArrayList();
            Deque<TreeNode> stack = new ArrayDeque();

            while (root != null || !stack.isEmpty()) {
                // push nodes: right -> node -> left
                while (root != null) {
                    if (root.right != null) {
                        stack.push(root.right);
                    }
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                // if the right subtree is not yet processed
                if (!stack.isEmpty() && root.right == stack.peek()) {
                    stack.pop();
                    stack.push(root);
                    root = root.right;
                    // if we're on the leftmost leaf
                } else {
                    output.add(root.val);
                    root = null;
                }
            }

            return output;
        }

    static TreeNode prev = null ;
    static boolean helper(TreeNode curNode)
    {
        if(curNode == null)
            return true ;

        if(!helper(curNode.left))
            return false ;
        if( prev != null && curNode.val < prev.val)
            return false ;
         prev = curNode ;
         return helper(curNode.right) ;
    }

    static boolean isBST(TreeNode root){
        if(root == null)
            return true;
        return helper(root) ;
    }


    public static void main(String[] args) {
        tree_postorderIterativeWalk  t = new tree_postorderIterativeWalk() ;

    TreeNode root = new TreeNode(3) ;
        root.left = new TreeNode(2) ;
        root.right = new TreeNode(5) ;
        List<Integer> list = t.postorderTraversal(root) ;
        for(Integer i:list)
            System.out.print(i);

     /*
        TreeNode root = new TreeNode(-1) ;
        //root.right =  new TreeNode(-1) ;
        root.left =  new TreeNode(0) ;
        System.out.println(isBST(root));
        */

    }
}
