

/*
Construct Binary search tree.
 */

import com.sun.source.tree.Tree;

import java.util.*;

public class binarySearchTree {

    Treenode iTree = new Treenode() ;

    public static class Treenode {
        int key ;
        Treenode left;
        Treenode right ;

        Treenode (int k)
        {
            this.key = k ;
            this.left = null;
            this.right = null;
        }
        Treenode ()
        {
            this.key = -1 ;
            this.left = null;
            this.right = null;
        }
    }

    public Treenode search(Treenode root,int key)
    {
        Treenode curNode = root;

        while(curNode != null) {
            if(curNode.key == key) {
                return curNode ;
            }
            else if (key<curNode.key) {
                curNode = curNode.left;
            }
            else { //Greater than
                curNode = curNode.right ;
            }
        }
        return curNode ;
    }

    public Treenode insert(Treenode root, int key)
    {
        Treenode curNode = root ;
        Treenode newnode = new Treenode(key) ;

        if(root.key == -1) {
            root = newnode ;
            return newnode;
        }
        Treenode prev = null ;

        while(curNode != null) {
            if (curNode.key == key) {
                return root;
            } else if (key < curNode.key) {
                prev = curNode ;
                curNode = curNode.left;
            } else { //Greater than
                prev = curNode ;
                curNode = curNode.right;
            }
        }

        if (key < prev.key) {
             prev.left = newnode;
            } else {
                prev.right = newnode;
            }
        return root ;
    }

    public Treenode findMin(Treenode t)
    {
        while(t.left != null) {
            t = t.left ;
        }
        return t ;
    }

    public Treenode findMax(Treenode t)
    {
        while(t.right != null) {
            t = t.right ;
        }
        return t ;
    }

    public Treenode successor(Treenode root, Treenode node )
    {
        if(root == null ) return null;
        Treenode curNode = new Treenode() ;

        //find min in right subtree
        if(node.right != null) {
            curNode = node.right ;
            curNode = findMin(curNode);
            return curNode ;
        }

        Treenode ancestor = new Treenode() ;
        curNode = root ;
        while(curNode.key != node.key) {
            if(node.key < curNode.key) {
                ancestor = curNode ;
                curNode = curNode.left ;
            }
            else {
                curNode = curNode.right ;
            }
        }
       // if(ancestor.key == -1)
         //   return node ;
        return ancestor ;
    }


    public Treenode predecissor(Treenode root, Treenode node )
    {
        if(root == null || node == null) return null;

        Treenode curNode ;

        //find max in right subtree
        if(node.left != null) {
            curNode = node.left ;
            curNode = findMax(curNode);
            return curNode ;
        }

        Treenode ancestor = new Treenode() ;
        curNode = root ;
        while(curNode.key != node.key) {
            if(node.key < curNode.key) {
                curNode = curNode.left ;
            }
            else {
                ancestor = curNode ;
                curNode = curNode.right ;
            }
        }
        return ancestor ;
    }

    public Treenode delete(Treenode root, Treenode deleteNode)
    {
        Treenode curNode = root ;
        Treenode prevNode = null ;

        while(curNode != null)
        {
           if(deleteNode.key < curNode.key) {
                prevNode = curNode ;
                curNode = curNode.left ;
            }
            else  if(deleteNode.key > curNode.key){
                prevNode = curNode ;
                curNode = curNode.right ;

            }
            if(deleteNode.key == curNode.key) {
             //curnode is leaf node
                if(curNode.left == null && curNode.right == null) {
                    if(prevNode.left.key == curNode.key) {
                        prevNode.left = null ;
                    }
                    else prevNode.right = null ;
                    return root ;
                }

                // curNode has exactly one child left or right.
                Treenode childNode = null  ;
                if(curNode.left == null)
                    childNode = curNode.left;
                else if(curNode.right == null)
                    childNode = curNode.right ;
                if(prevNode.left == curNode)
                    prevNode.left = childNode ;
                else if(prevNode.right == curNode)
                    prevNode.right = childNode ;

                //Special edge case where tree has only one node
                if(prevNode == null)
                    root = childNode ;
                return root ;
            }
        }

        return root;
    }

    public void bfs(Treenode root)
    {
        Treenode curNode = root ;
        Queue<Treenode> storage = new LinkedList<Treenode>();
        storage.offer(root) ;

        while(!storage.isEmpty())
        {
            Treenode t = storage.poll() ;
            System.out.print(t.key);
            if(t.left != null) {
                storage.offer(t.left) ;
            }
            if(t.right != null) {
                storage.offer(t.right) ;
            }
        }
        System.out.println();
    }

    public void inorder(Treenode node) {
        if(node == null) return ;

        inorder(node.left) ;
        System.out.print(node.key);
        inorder(node.right);
    }

    static List<Integer> tree = new ArrayList<Integer>() ;

    public void preorder(Treenode root) {
        if(root == null) {
            return ;
        }

       // System.out.print(root.key);
        tree.add(root.key);
        preorder(root.left) ;
        preorder(root.right);
    }

    public void postorder(Treenode root) {
        Treenode curNode = root ;
        if(curNode == null) {
            return ;
        }

        postorder(curNode.left) ;
        postorder(curNode.right);
        System.out.print(curNode.key);
    }

    public void preorder_helper(Treenode root, int level) {
        if(root == null)
            return ;

        String s = new String() ;
        for(int i=0;i<level;i++)
            s += "*" ;

        System.out.print(s+root.key);
        preorder_helper(root.left,level+1) ;
        preorder_helper(root.right,level+1);
    }

    public void preorder_Example(Treenode root) {
        preorder_helper(root,0) ;
    }



    static List<Integer> pathA = new ArrayList<Integer> () ;
    static List<Integer> pathB = new ArrayList<Integer> () ;


//find preorder path from root to given node

    public void preorderPath(Treenode curNode, Treenode pathANode, boolean flagNode)
    {
        while(curNode.key != pathANode.key && curNode != null){
            if(curNode.left != null) {
                curNode = curNode.left;
            }
            else if(curNode.right !=null) {
                curNode = curNode.right;
            }
            System.out.println("curNode: "+curNode.key);
        }
    }

    public int findLCA(Treenode root, Treenode nodeA, Treenode nodeB)
    {
        //get two paths from root to curNode.
        preorderPath(root, nodeA,true) ;
        preorderPath(root, nodeB,false) ;

        //Build pathA hash map
        HashMap<Integer,Integer> pathAmap = new HashMap<Integer,Integer>() ;
        for(int i = 0; i<pathA.size();i++)
            pathAmap.put(pathA.get(i),i) ;

        //Loop through pathB and get first common node from last index
        for (int i = pathB.size()-1;i<=0;i--) {
            if(pathAmap.containsKey(pathB.get(i)))
            return pathB.get(i) ;
        }
        return root.key;
    }


    private Treenode ans;

    public binarySearchTree() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(Treenode currentNode, Treenode p, Treenode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public Treenode lowestCommonAncestor(Treenode root, Treenode p, Treenode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

        List<Integer> treeList = new ArrayList<Integer> () ;
        static int iterPos = -1 ;

        public void helper(Treenode node)
        {
            if(node == null)
                return ;
            if(node.left != null)
                helper(node.left) ;
            treeList.add(node.key) ;
            if(node.right != null)
                helper(node.right) ;
        }

      //  public binarySearchTree(Treenode root) {
        //    helper(root) ;
        //}

        /** @return the next smallest number */
        public int next() {
            if(iterPos < treeList.size())
                iterPos += 1 ;
            if(iterPos >= treeList.size())
                return 0;
            return treeList.get(iterPos);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            //First time
            //if(iterPos+1 == 0)
            //  return true;
            //last index
            if(iterPos+1 >= treeList.size()  )
                return  false;
            else return true;
        }


    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();
        Treenode root = new Treenode(1) ;
        //Treenode root = null;
       // root.left = new Treenode(2) ;
        //root.right = new Treenode(5) ;
        //root.left.left = new Treenode(1) ;
        //root.left.right = new Treenode(3) ;
        //root.right.left = new Treenode(6) ;
        //root.right.right = new Treenode(8) ;

        bst.helper(root) ;
        while(bst.hasNext())
            System.out.println(bst.next());


      //  System.out.println("LCA= "+bst.findLCA(root, root.left.left,root.left.right)) ;
      //  System.out.println(bst.lowestCommonAncestor(root, root.left.left,root.right ).key) ;
       // t = bst.insert(t, 1) ;

        /*
        t = bst.insert(t, 4 );
        t = bst.insert(t, 6);
        t = bst.insert(t, 3);
        t = bst.insert(t, 5);

        bst.findMin(t);
        bst.findMax(t);


        //successor
        Treenode s = bst.successor(t,bst.search(t,4)) ;
        System.out.println(s.key);

        Treenode s1 = bst.predecissor(t, bst.search(t,6)) ;
        System.out.println(s1.key);

        bst.delete(t,bst.search(t,5)) ;

        if(bst.search(t,5) == null) {
            System.out.println("Node deleted");
        }
        else System.out.println("Node NOT deleted");

        t = bst.insert(t, 1) ;
        bst.bfs(t);

        bst.inorder(t);
        System.out.println();
        bst.preorder(t);

        System.out.println();
        bst.postorder(t);
        System.out.println();
        bst.preorder_Example(t) ;

         */
        //bst.preorder(t);
        //for(Integer ele :tree)
          //  System.out.print(ele);
    }
}
