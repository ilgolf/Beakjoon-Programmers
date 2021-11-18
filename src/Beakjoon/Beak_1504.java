package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak_1504 {

    static class Node implements Comparable<Node> {

        int v;
        int distance;

        public Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int n, e;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static int[] dp = new int[801];

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dp = new int[801];
        Arrays.fill(dp, INF);
        queue.offer(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int dist = node.distance;
            int now = node.v;

            if (dp[now] < dist) continue;

            for (Node next : graph.get(now)) {
                int cost = dp[now] + next.distance;

                if (cost < dp[next.v]) {
                    dp[next.v] = cost;

                    queue.offer(new Node(next.v, cost));
                }
            }
        }

        return dp[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cost = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Node(y, cost));
            graph.get(y).add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);

        long result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);

        if (Math.min(result1, result2) >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(result1, result2));
    }
}
