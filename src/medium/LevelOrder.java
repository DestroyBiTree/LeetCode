package medium;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> level = new LinkedList();
        if (root != null)
            level.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!level.isEmpty()){
           int len = level.size();
           List<Integer> path = new ArrayList<>();
           for (int i = 0; i < len; i++){
                TreeNode t = level.poll();
                path.add(t.val);
                if (t.left != null){
                    level.add(t.left);
                }

                if (t.right != null){
                    level.add(t.right);
                 }
            }
           res.add(path);
        }
        return res;

    }
}
