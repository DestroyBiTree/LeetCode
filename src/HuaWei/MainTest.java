package HuaWei;

import java.util.*;

public class MainTest {
    static int n; // 顶点数
    static int[] inDegree; // 存储每个顶点的入度
    static List<Integer>[] graph; // 图
    static Set<Integer> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        inDegree = new int[n];
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            int outDegree = scanner.nextInt();
            graph[i] = new ArrayList<>();
            for (int j = 0; j < outDegree; j++) {
                int outVertex = scanner.nextInt() - 1;
                graph[i].add(outVertex);
                inDegree[outVertex]++;
            }
        }
        if (hasCycle()) {
            System.out.println("-1"); // 存在环
            return;
        } else {
            for (int i = 0; i < n; i++) {
//                System.out.print(i + 1 + "号出度为" + graph[i].size() + " ");
                int key = graph[i].size();
                if (res.contains(key)){
                    continue;
                }else {
                    res.add(key);
                }
            }
        }
        System.out.println(res.size());
    }

    // 判断是否有环
    public static boolean hasCycle() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int next : graph[curr]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count != n; // 如果count != n，说明存在环
    }
}

