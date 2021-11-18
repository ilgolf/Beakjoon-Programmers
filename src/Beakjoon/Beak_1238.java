package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak_1238 {

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

    static int n, m, x;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> village = new ArrayList<>();
    static ArrayList<ArrayList<Node>> reverse = new ArrayList<>();
    static int[] dp;

    static int[] dijkstra(ArrayList<ArrayList<Node>> village) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        dp = new int[10001];
        Arrays.fill(dp, INF);
        queue.offer(new Node(x, 0));
        dp[x] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int dist = node.distance;
            int now = node.idx;

            if (dp[now] < dist) continue;

            for (int i = 0; i < village.get(now).size(); i++) {
                int cost = dp[now] + village.get(now).get(i).distance;
                if (cost < dp[village.get(now).get(i).idx]) {
                    dp[village.get(now).get(i).idx] = cost;
                    queue.offer(new Node(village.get(now).get(i).idx, cost));
                }
            }
        }
        return dp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            village.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            village.get(s).add(new Node(e, cost));
            reverse.get(e).add(new Node(s, cost));
        }

        int[] dist1 = dijkstra(village);
        int[] dist2 = dijkstra(reverse);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }

        System.out.println(answer);
    }
}
