package HuaWei;

import java.util.*;

public class Main2 {
    static int n, bian, block;
    static boolean[] zuai;
    static List<List<Integer>> tu;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        bian = scanner.nextInt();
        tu = new ArrayList<>(n);
        zuai = new boolean[n];
        for (int i = 0; i < n; i++) {
            tu.add(new ArrayList<>());
        }
        for (int i = 0; i < bian; i++) {
            int u =scanner.nextInt();
            int v =scanner.nextInt();
            tu.get(u).add(v);
            tu.get(v).add(u);
        }
        block = scanner.nextInt();
        for (int i = 0; i < block; i++) {
            int node = scanner.nextInt();
            zuai[node] = true;
        }
        List<Integer> duanlujing = zhaoDuan();
        if (duanlujing == null) {
            System.out.println("NULL");
        } else {
            for (int i = 0; i < duanlujing.size(); i++) {
                if (i > 0) {
                    System.out.print("->");
                }
                System.out.print(duanlujing.get(i));
            }
        }
    }
    static List<Integer> zhaoDuan(){
        int[] parent = new int[n];
        Queue<Integer> duilie = new LinkedList<>();
        boolean[] visited = new boolean[n];
        duilie.offer(0);
        Arrays.fill(parent,-1);

        while (!duilie.isEmpty()) {
            int curr = duilie.poll();
            if (tu.get(curr).size() == 1 && curr != 0) {
                List<Integer> path = new ArrayList<>();
                while (curr != -1) {
                    path.add(curr);
                    curr = parent[curr];
                }
                Collections.reverse(path);
                return path;
            }
            for(int neighbor : tu.get(curr)) {
                if (!visited[neighbor] && !zuai[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = curr;
                    duilie.offer(neighbor);
                }
            }
        }
        return null;
    }

}
