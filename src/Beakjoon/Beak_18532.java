package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_18532 {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, m, k, x;
    static List<ArrayList<Node>> city = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(x, 0));
        dist[x] = 0;


        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int nDist = cur.cost;
            int now = cur.idx;

            if (dist[now] < nDist) continue;

            for (int i = 0; i < city.get(now).size(); i++) {
                int cost = dist[now] + city.get(now).get(i).cost;

                if (cost < dist[city.get(now).get(i).idx]) {
                    dist[city.get(now).get(i).idx] = cost;
                    queue.offer(new Node(city.get(now).get(i).idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            city.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), 1));
        }

        dist = new int[n + 1];

        Arrays.fill(dist, INF);

        dijkstra();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == k) {
                result.append(i).append('\n');
            }
        }

        if (result.toString().length() == 0) {
            System.out.println(-1);
            return;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
