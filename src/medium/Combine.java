package medium;

import java.util.*;

/*LeetCode77.组合*/
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Combine combine = new Combine();
        List<List<Integer>> result = combine.combine(n, k);
        for (List per : result) {
            System.out.println(Arrays.toString(per.toArray()));
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }
    public void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n,k,i + 1);
            path.remove(i);
        }
    }


}
