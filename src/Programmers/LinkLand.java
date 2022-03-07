package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LinkLand {

    static class Land {
        int start;
        int end;
        int cost;

        public Land(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static List<Land> lands = new ArrayList<>();
    static int[] parents;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] cost : costs) {
            lands.add(new Land(cost[0], cost[1], cost[2]));
            lands.add(new Land(cost[1], cost[0], cost[2]));
        }

        lands.sort(Comparator.comparingInt(o -> o.cost));

        for (Land land : lands) {
            if (!union(land.start, land.end)) continue;

            answer += land.cost;
        }

        return answer;
    }

    private boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        else {
            parents[aRoot] = bRoot;
            return true;
        }
    }

    private int find(int val) {
        if (parents[val] == val) {
            return val;
        }

        return parents[val] = find(parents[val]);
    }
}
