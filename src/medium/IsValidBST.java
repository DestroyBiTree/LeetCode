package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class IsValidBST {
    public static void main(String[] args) {


    }


    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (root.val > pre)
            pre = root.val;
        else
            return false;
        boolean right = isValidBST(root.right);
        return right && left;

    }
}
