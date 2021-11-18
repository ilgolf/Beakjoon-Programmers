package Programmers;

import java.util.*;

public class FarNode {

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] checked;

    // root : 1 -> 2, 3, 4, ...
    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        checked[1] = true;

        int count = 0;

        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int idx : graph.get(cur)) {
                    if (!checked[idx]) {
                        temp.offer(idx);
                        checked[idx] = true;
                    }
                }
            }

            if (temp.isEmpty()) break;
            queue.addAll(temp);
            count = temp.size();
        }

        return count;
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        checked = new boolean[n + 1];

        // 노드 만들어주기
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 연결해주기
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        answer = bfs();

        int max = 0;

        return answer;
    }
}
