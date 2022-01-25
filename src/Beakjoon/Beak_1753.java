package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_1753 {

    static class Node implements Comparable<Node> {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }

    static int v, e;
    static List<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dp = new int[20001];
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(dp, INF);

        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            if (dp[i] == INF) {
                System.out.println("INF");
            } else{
                System.out.println(dp[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(start, 0));
        dp[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int dist = node.distance;
            int now = node.idx;

            if (dp[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dp[now] + graph.get(now).get(i).distance;

                if (cost < dp[graph.get(now).get(i).idx]) {
                    dp[graph.get(now).get(i).idx] = cost;
                    queue.offer(new Node(graph.get(now).get(i).idx, cost));
                }
            }
        }
    }
}
