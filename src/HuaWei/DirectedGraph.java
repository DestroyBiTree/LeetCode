package HuaWei;

import java.util.*;

public class DirectedGraph {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 顶点个数
        int[] outDegree = new int[n + 1]; // 存储每个顶点的出度
        List<List<Integer>> graph = new ArrayList<>(); // 存储有向图
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= n; i++) {
            int degree = input.nextInt(); // 顶点的出度
            outDegree[i] = degree;
            for (int j = 0; j < degree; j++) {
                int v = input.nextInt(); // 顶点i的第j个出边指向的顶点
                graph.get(i).add(v);
            }
        }

        // 拓扑排序
        int[] inDegree = new int[n + 1]; // 存储每个顶点的入度
        for (int i = 1; i <= n; i++) {
            for (int v : graph.get(i)) {
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
            count++;
        }

        // 判断是否存在环
        if (count != n) {
            System.out.println("-1");
        } else {
            // 输出每个顶点的出度
            for (int i = 1; i <= n; i++) {
                System.out.print(i + "号出度为" + outDegree[i]);
                if (outDegree[i] > 0) {
                    System.out.print(",");
                    for (int j = 0; j < outDegree[i]; j++) {
                        int v = graph.get(i).get(j);
                        if (!res.contains(v)) {
                            continue; // 忽略不在拓扑排序结果中的顶点
                        }
                        System.out.print(v);
                        if (j != outDegree[i] - 1) {
                            System.out.print(",");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
