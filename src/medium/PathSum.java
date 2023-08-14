package medium;
//437.路径总和III
/*题目要求*/
/*给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。*/

/*暴力思路*/
/*设置两个DFS搜索函数，DFS1用来搜索每个结点都当做根节点，DFS2搜索有无等于目标的结点*/
public class PathSum {
    public static void main(String[] args) {

    }
    int ans,t;
    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        ans = 0;
        dfs1(root);
        return ans;
    }
    public void dfs1(TreeNode root){
        if (root == null)
            return;
        else{
            dfs2(root, root.val);
            dfs1(root.left);
            dfs1(root.right);
        }

    }

    public void dfs2(TreeNode root, long val){
        if (val == t)
            ans++;
        if (root.left != null)
            dfs2(root.left,val + root.left.val);
        if (root.right != null)
            dfs2(root.right, val +root.right.val);
    }

}
