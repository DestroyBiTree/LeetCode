package medium;

import java.util.HashMap;

public class BuildTree {
     public static void main(String[] args) {

     }
     public TreeNode buildTree(int[] preorder, int[] inorder) {
          HashMap<Integer,Integer> map = new HashMap<>();
          for (int i = 0; i < inorder.length; i++){
               map.put(inorder[i], i);
          }
          return findNode(preorder, inorder, 0, preorder.length, 0, inorder.length,map );
     }

     public TreeNode findNode(int[] preorder, int[] inorder, int p_start, int p_end, int in_start, int in_end, HashMap<Integer, Integer> map){
          if (p_start == p_end){
               return null;
          }
          int root_val = preorder[p_start];
          TreeNode root = new TreeNode(root_val);
          int in_root_index = map.get(root_val);

          //左子树的长度
          int left_num = in_root_index - in_start;
          root.left = findNode(preorder, inorder, p_start + 1, p_start + left_num + 1, in_start, in_root_index, map);
          root.right = findNode(preorder, inorder, p_start + left_num + 1, p_end, in_root_index + 1, in_end, map);
          return root;
     }
}
