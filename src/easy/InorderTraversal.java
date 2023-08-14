package easy;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {

    }
}
    class TreeNode {
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

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root,res);
            return res;

        }

        public void inorder(TreeNode root,List<Integer> res){
           if (root == null)
           {
               return;
           }
           inorder(root.left,res);
           res.add(root.val);
           inorder(root.right,res);
        }
   }