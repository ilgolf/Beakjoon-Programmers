package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Weekly_9 {

    static List<ArrayList<Integer>> list = new ArrayList<>();

    static int bfs(int start, int ignore) {
        boolean[] checked = new boolean[list.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int count = 0;
        int curr;

        while (!queue.isEmpty()) {
            count ++;
            curr = queue.poll();

            checked[curr] = true;
            for (int val : list.get(curr)) {
                if (val == ignore || checked[val]) continue;

                queue.offer(val);
            }
        }

        return Math.abs((list.size() - 1 - count) - count);
    }

    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int s = wire[0];
            int e = wire[1];

            list.get(s).add(e);
            list.get(e).add(s);
        }

        int min = n;
        for (int[] wire : wires) {
            min = Math.min(min, bfs(wire[0], wire[1]));
        }

        return min;
    }
}
