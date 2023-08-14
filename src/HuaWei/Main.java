package HuaWei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取任务数
        int n = sc.nextInt();

        // 读取任务列表
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }

        // 计算总能耗
        int energy = calculateEnergy(tasks);

        // 输出结果
        System.out.println(energy);

        sc.close();
    }

    /**
     * 计算服务器的总能耗
     */
    private static int calculateEnergy(int[][] tasks) {
        int energy = 0;
        int state = 0; // 服务器初始状态为空载

        // 遍历所有时间片
        for (int i = 0; i < 1000000; i++) {
            int taskCount = 0;
            int taskTime = 0;

            // 统计当前时间片中的任务数量和执行时间
            for (int j = 0; j < tasks.length; j++) {
                if (tasks[j][0] <= i && tasks[j][1] >= i) {
                    taskCount++;
                    taskTime += tasks[j][1] - tasks[j][0] + 1;
                }
            }

            // 根据任务数量和执行时间更新服务器状态和能耗
            if (taskCount > 1) {
                if (state != 2) {
                    state = 2; // 服务器状态更新为多任务
                    energy += 4; // 能耗增加4
                }
            } else if (taskCount == 1) {
                if (state != 1) {
                    state = 1; // 服务器状态更新为单任务
                    energy += 3; // 能耗增加3
                }
            } else {
                if (state != 0) {
                    state = 0; // 服务器状态更新为空载
                    energy += 1; // 能耗增加1
                }
            }

            // 如果存在任务正在执行，则减少任务执行时间
            if (taskTime > 0) {
                taskTime--;
            }
        }

        return energy;
    }
}