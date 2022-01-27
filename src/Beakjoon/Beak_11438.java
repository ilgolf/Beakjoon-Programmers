package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_11438 {

    static int[][] parents;
    static int[] depth;
    static int n, m;
    static int k = 0;
    static List<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 2^k > n으로 k 구하기
        for (int i = 1; i < n; i *= 2) {
            k ++;
        }

        depth = new int[n + 1];
        parents = new int[k + 1][n + 1];

        dfs(1, 1);

        fillParent();

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getLCA(a, b)).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int count) {
        // 1. 체크인
        depth[start] = count;

        // 2. 목적지 인가?
        int len = tree.get(start).size();

        // 3. 연결된 곳을 순회
        for (int i = 0; i < len; i++) {
            int next = tree.get(start).get(i);

            // 4. 갈 수 있는가?
            if (depth[next] == 0) {

                // 5. 간다.
                dfs(next, count + 1);
                parents[0][next] = start;
            }

        }
        // 6. 체크 아웃
        return;
    }

    private static void fillParent() {
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    private static int getLCA(int a, int b) {
        // depth[a] < depth[b] 일 경우 더 탐색
        if (depth[a] < depth[b]) {
            return getLCA(b, a);
        }

        // 높이 맞추기
        for (int i = 0; i <= k; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                a = parents[i][a]; // 비트를 밀면서 각 2^k 를 확인하고 올려주기
            }
        }

        // 높이 맞췄는지 확인
        if (a == b) {
            return a;
        }

        // 공통 조상이 아닐 때 가지 올라가기
        // 최종적으로 LCA 밑까지 올라감
        for (int i = k; i >= 0; i--) {
            if (parents[i][a] != parents[i][b]) {
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        // 나온 값에 공통 조상
        return parents[0][a];
    }
}
