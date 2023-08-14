package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*LeetCode.216
* 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    只使用数字1到9
    每个数字 最多使用一次
  返回所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。*/
public class CombinationSum3 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(k, n));

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(k,n,1,0);
        return res;
    }

    public void backTracing(int k, int n, int startindex, int sum) {
        if (path.size() > k || sum > n) {
            return;
        }
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startindex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backTracing(k,n,i + 1,sum);
            path.remove(path.size() - 1);
        }

    }

}
