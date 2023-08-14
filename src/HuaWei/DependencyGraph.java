package HuaWei;

import java.util.*;
/*用Java实现以下代码：第一行输入一个数N,代表接下来的有向图中会有N个顶点。随后输入N行数字，第i行表示有向图中的第i个顶点，每行的第一个数字表示这一个顶点的入度为多少，
之后的数字表示这个顶点的入度是哪几个数字。现在先判断这个有向图中是否存在环，如果存在则输出-1，如果不存在，则每次找到出度为0的顶点，输出并将它删除，直到这个图为空。*/
public class DependencyGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 模块总数
        int[] indegrees = new int[n + 1]; // 记录每个模块的入度
        List<List<Integer>> adjList = new ArrayList<>(); // 邻接表表示依赖关系
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int m = scanner.nextInt(); // 依赖模块数量
            for (int j = 0; j < m; j++) {
                int id = scanner.nextInt(); // 依赖的模块 ID
                adjList.get(id).add(i);
                indegrees[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>(); // 存储入度为 0 的模块
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0; // 统计批量初始化次数
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一次性取出入度为 0 的所有模块进行处理
            for (int i = 0; i < size; i++) {
                int module = queue.poll();
                for (int dependent : adjList.get(module)) {
                    indegrees[dependent]--;
                    if (indegrees[dependent] == 0) {
                        queue.offer(dependent);
                    }
                }
            }
            count++;
        }
        if (count < n) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}



