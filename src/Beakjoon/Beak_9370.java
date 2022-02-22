package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_9370 {

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }

    static int n, m, k;
    static int s, g, h;
    static List<ArrayList<Node>> graph;
    static int[] endPoint;
    static int[] dp;
    static boolean[] checked;
    static final int INF = (int)1e9;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            endPoint = new int[k];
            dp = new int[n + 1];
            checked = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if ((a == h && b == g) || (a == g && b == h)) {
                    graph.get(a).add(new Node(b, d * 2 - 1));
                    graph.get(b).add(new Node(a, d * 2 - 1));
                }
                else {
                    graph.get(a).add(new Node(b, d * 2));
                    graph.get(b).add(new Node(a, d * 2));
                }

            }

            for (int i = 0; i < k; i++) {
                endPoint[i] = Integer.parseInt(br.readLine());
            }

            Arrays.fill(dp, INF);

            dijkstra();

            Arrays.sort(endPoint);

            for (int val : endPoint) {
                if (dp[val] % 2 == 1) {
                    sb.append(val).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(s, 0));
        dp[s] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int now = cur.idx;

            if (checked[now]) continue;

            checked[now] = true;

            for (Node next : graph.get(now)) {
                int cost = dp[now] + next.dist;

                if (!checked[next.idx] && cost < dp[next.idx]) {
                    dp[next.idx] = cost;
                    queue.offer(new Node(next.idx, cost));
                }
            }
        }
    }
}
