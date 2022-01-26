package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_5719 {

    /**
     * 1. 최단경로들을 기록한다. (now.cost + next.cost == dist[next.idx] 일 때)
     * 2. 최단경로들을 지운다. : DFS를 활용하여 도착지 D에서부터 출발지 S로 경로를 백트래킹
     * 3. 다익스트라로 가능한 경로 중 가장 빠른 길을 찾는다.
     */

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
    static int start, end;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;

    static boolean[][] isShortest;
    static ArrayList<Integer>[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 || m == 0) break;

            isShortest = new boolean[n][n];

            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n];
            parent = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st .nextToken());

                graph[u].add(new Node(v, p));
            }

            dijkstra(start, end);
            backTracking(start, end);
            dijkstra(start, end);

            if (dist[end] == INF) {
                sb.append("-1").append('\n');
            } else {
                sb.append(dist[end]).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void backTracking(int start, int now) {
        if (start == now) {
            return;
        }

        for (int i = 0; i < parent[now].size(); i++) {
            int next = parent[now].get(i);

            if (!isShortest[next][now]) {
                isShortest[next][now] = true;
                backTracking(start, next);
            }
        }
    }

    private static void dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int now = cur.idx;
            int weight = cur.distance;

            if (dist[now] < weight) {
                continue;
            }

            // 1. 최단경로들을 기록한다. (now.cost + next.cost == dist[next.idx] 일 때)
            for (Node next : graph[now]) {

                if (isShortest[now][next.idx]) continue;

                if (dist[next.idx] == weight + next.distance) {
                    parent[next.idx].add(now);
                }

                else if (dist[next.idx] > weight + next.distance) {
                    dist[next.idx] = weight + next.distance;

                    parent[next.idx].clear();
                    parent[next.idx].add(now);
                    queue.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}
