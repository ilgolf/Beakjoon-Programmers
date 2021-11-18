package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1916 {

    static class Node implements Comparable<Node> {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int n, m;
    static List<ArrayList<Node>> bus = new ArrayList<>();
    static int[] dp = new int[1001];
    static final int INF = Integer.MAX_VALUE;

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int dist = node.distance;
            int now = node.idx;

            if (dp[now] < dist) continue;

            for (Node next : bus.get(now)) {
                int cost = dp[now] + next.distance;

                if (cost < dp[next.idx]) {
                    dp[next.idx] = cost;

                    queue.offer(new Node(next.idx, cost));
                }
            }
        }

        return dp[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            bus.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus.get(x).add(new Node(y, cost));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, INF);

        int result = dijkstra(start, end);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
