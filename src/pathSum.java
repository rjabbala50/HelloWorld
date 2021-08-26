

/*
https://leetcode.com/problems/path-sum/submissions/
*/

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pathSum {

    private static class TreeNode {
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

    public void helper(TreeNode root, int sum,boolean flag)
    {
        if(root.left == null  && root.right == null)  {
            if(sum-root.val ==  0) {
                flag = true;
                return   ;
            }
            else return ;
        }
        if(root.left!= null) {
            helper(root.left,sum-root.val,flag) ;
        }
        if(root.right!= null) {
            helper(root.right,sum-root.val,flag) ;
        }
        return ;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false ;
        boolean flag = false ;
        helper(root,sum,flag);
        return flag ;
    }

    public void helper(TreeNode root, int sum, int target, List<List<Integer>> result, List<Integer> path)
    {

        if(root.left == null  && root.right == null)  {
            if(sum == target+root.val) {
                path.add(root.val) ;
                result.add(path) ;
               // path.remove(root.val) ;
                return ;
            }
            else return;
        }

        target += root.val ;
        path.add(root.val) ;

        if(root.left!= null) {
            helper(root.left,sum,target,result,path) ;
        }
        if(root.right!= null) {
            helper(root.right,sum,target,result,path) ;
        }

        path.remove(0) ;
        return ;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return null ;
        List<List<Integer>> result = new ArrayList<>() ;
        List<Integer> path = new ArrayList<>() ;

        helper(root,sum,0,result,path);
        return result ;
    }

    public static void main(String[] args) {
        pathSum p = new pathSum();
        pathSum.TreeNode t = new pathSum.TreeNode();
        pathSum.TreeNode t1 = new pathSum.TreeNode(2,new TreeNode(3),new TreeNode(4));
        t1.left.left = new TreeNode(5) ;
        t1.left.left.right = new TreeNode(6) ;
        t1.left.left.right.left = new TreeNode(8) ;
       // System.out.println(p.hasPathSum(t1,7));
        p.pathSum(t1,22) ;

    }
}
