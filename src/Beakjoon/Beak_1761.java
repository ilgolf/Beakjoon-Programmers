package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최소 공통 조상 문제
 * 거리와 정점을 입력 받아 공통 조상을 찾아 준다 그리고 찾기 위해 올라간 정점 거리
 * 맞춰주기 위해 올라간 거리 더해준다.
 */
public class Beak_1761 {

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int n, m;
    static int[][] parents; // 부모 저장
    static int[] depth; // 깊이 저장
    static int[] costs; // 깊이 저장
    static int k = 1;
    static List<ArrayList<Node>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree.get(a).add(new Node(b, cost));
            tree.get(b).add(new Node(a, cost));
        }

        for (int i = 1; i < n; i*=2) {
            k ++;
        }

        depth = new int[n + 1];
        parents = new int[k][n + 1];
        costs = new int[n + 1];

        // 레벨 저장해주기
        dfs(1, 1);

        // 부모 채워주기 : 점화식 (parents[k][v] = parents[k - 1][parents[k - 1][v]])
        fillParents();


        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = getLCA(a, b);
            // 중복되는 최소 공통 조상 거리는 삭제 a 거리 + b 거리 - 2 * 공통 조상 거리
            resultBuilder.append(costs[a] + costs[b] - 2 * costs[res]).append('\n');
        }

        System.out.println(resultBuilder);
    }

    private static int getLCA(int a, int b) {
        // depth가 같지 않은 경우 더 탐색
        if (depth[a] < depth[b]) {
            return getLCA(b, a);
        }

        // 높이 맞추기
        for (int i = 0; i < k; i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {
                a = parents[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (parents[i][a] != parents[i][b]) {
                a = parents[i][a];
                b = parents[i][b];
            }
        }

        return parents[0][a];
    }

    private static void fillParents() {
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
    }

    private static void dfs(int index, int count) {
        // 1. 체크인
        depth[index] = count;

        // 2. 목적지 인가? (생략)

        // 3. 연결된 곳을 순회
        for (Node node : tree.get(index)) {
            int next = node.idx;

            // 4. 갈 수 있는가? : 아직 안가본 곳 -> 0
            if (depth[next] == 0) {
                // 5. 간다.
                costs[next] = costs[index] + node.dist; // 루트로 부터 거리 저장
                dfs(next, count + 1);
                parents[0][next] = index; // 체크인
            }
        }
        // 6. 체크아웃
    }
}
