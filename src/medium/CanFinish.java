package medium;

import java.util.*;
/*207课程表*/
public class CanFinish {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //map中存储结点对应的初度
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        //先把所有的课放进去
        for (int i = 0; i < numCourses; i++){
            inDegree.put(i,0);

        }
        //课程间的依赖关系,依赖当前课程的后续课程
        //(3,0),(3,1)对应的存储为<3,[0,1]>
        Map<Integer, List<Integer>> adj = new HashMap<>();

        //初始化入度和依赖关系
        for (int[] relate : prerequisites){
            int cur = relate[1];
            int next = relate[0];
            //更新入度
            inDegree.put(next,inDegree.get(next) + 1);
            //当前节点的邻接表
            if (!adj.containsKey(cur)){
                adj.put(cur,new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

        //将入度为0的课程放入队列
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()){
            if (inDegree.get(key) == 0){
                q.offer(key);
            }
        }

        //当队列中不为空的时候开始取出节点，学习课程
        while (!q.isEmpty()) {
            int cur = q.poll();
            //遍历这个课程的邻接表
            if (!adj.containsKey(cur)) {
                //如果没有其他课程依赖这个课程，则直接跳过
                continue;
            }
            //获取依赖于这个课程的其他课程列表
            List<Integer> successorList = adj.get(cur);
            for (int k : successorList) {
                //逐一的将他们的入度减去1
                inDegree.put(k, inDegree.get(k) - 1);
                //如果入度减到了0就入队
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }

            for (int key : inDegree.keySet()){
                if (inDegree.get(key) != 0){
                    return false;
                }

            }

            return true;


        }





}

