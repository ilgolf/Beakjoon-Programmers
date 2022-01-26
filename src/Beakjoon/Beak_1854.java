package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_1854 {

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

    static int n, m, k;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Integer>[] dist; // k번째 사이즈를 유지하기 위한

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        dist = new PriorityQueue[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        // 간선 연결해주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        // 다익스트라
        dijkstra(1);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (dist[i].size() == k) {
                sb.append(dist[i].peek()).append('\n');
            }
            else {
                sb.append("-1").append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        dist[start].add(0);
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            int now = curr.idx;
            int weight = curr.distance;

            if (dist[now].peek() < weight) continue;
            
            for (Node next : graph[now]) {
                
                // k 번째보다 큐 사이즈가 작을 경우
                if (dist[next.idx].size() < k) {
                    dist[next.idx].add(weight + next.distance);
                    queue.offer(new Node(next.idx, weight + next.distance));
                }
                
                // k 번째보다 큐 사이즈가 크고 갱신해줘야 할 때
                else if (dist[next.idx].peek() > (weight + next.distance)) {
                    dist[next.idx].poll();
                    dist[next.idx].offer(weight + next.distance);
                    queue.offer(new Node(next.idx, weight + next.distance));
                }
            }
        }
    }
}
