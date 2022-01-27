package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beak_3176 {

    static class Road {
        int idx;
        int cost;

        public Road(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int n;
    static int[][] parents;
    static int[][] max;
    static int[][] min;
    static int k = 0;
    static int[] depth;
    static ArrayList<Road>[] tree;
    static int maxResult;
    static int minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i *= 2) {
            k ++;
        }

        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[a].add(new Road(b, cost));
            tree[b].add(new Road(a, cost));
        }

        depth = new int[n + 1];
        parents = new int[k + 1][n + 1];
        max = new int[k + 1][n + 1];
        min = new int[k + 1][n + 1];

        dfs(1, 1);

        fillParents();

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st =  new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            getLCA(d, e);
            sb.append(minResult).append(" ").append(maxResult).append('\n');
        }

        System.out.println(sb);
    }

    private static int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            return getLCA(b, a);
        }

        minResult = 10000001;
        maxResult = 0;

        for (int i = 0; i <= k; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                maxResult = Math.max(maxResult, max[i][a]);
                minResult = Math.min(minResult, min[i][a]);
                a = parents[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = k; i >= 0; i--) {
            if (parents[i][a] != parents[i][b]) {
                minResult = Math.min(minResult, Math.min(min[i][a], min[i][b]));
                maxResult = Math.max(maxResult, Math.max(max[i][a], max[i][b]));

                a = parents[i][a];
                b = parents[i][b];
            }
        }

        minResult = Math.min(minResult, Math.min(min[0][a], min[0][b]));
        maxResult = Math.max(maxResult, Math.max(max[0][a], max[0][b]));

        return parents[0][a];
    }

    private static void fillParents() {
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                // 점화식
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
                max[i][j] = Math.max(max[i - 1][j], max[i - 1][parents[i - 1][j]]);
                min[i][j] = Math.min(min[i - 1][j], min[i - 1][parents[i - 1][j]]);
            }
        }
    }

    private static void dfs(int start, int count) {
        // 1. 체크인
        depth[start] = count;

        int len = tree[start].size();

        // 3. 연결된 곳을 순회
        for (int i = 0; i < len; i++) {
            Road next = tree[start].get(i);

            // 4. 갈 수 있는가?
            if (depth[next.idx] == 0) {

                // 5. 간다.
                dfs(next.idx, count + 1);

                parents[0][next.idx] = start;
                max[0][next.idx] = next.cost;
                min[0][next.idx] = next.cost;
            }
        }

        // 6. 체크 아웃
        return;
    }
}
