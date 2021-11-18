package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1865 {
    
    static class Node {
        int edge;
        int distance;

        public Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }

    static List<ArrayList<Node>> world;
    static int n,m,w;
    static int[] dp;
    static final int INF = (int)1e9;

    static boolean Bell(int start) {
        Arrays.fill(dp, INF);
        dp[start] = 0;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            flag = false;

            for (int j = 1; j <= n; j++) {
                for (Node node : world.get(j)) {
                    if (dp[j] != INF && dp[node.edge] > dp[j] + node.distance) {
                        dp[node.edge] = dp[j] + node.distance;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (Node node : world.get(i)) {
                    if (dp[i] != INF && dp[node.edge] > dp[i] + node.distance) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t -- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dp = new int[100001];
            world = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                world.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                world.get(s).add(new Node(e, cost));
                world.get(e).add(new Node(s, cost));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                world.get(s).add(new Node(e, -cost));
            }

            boolean isMinCycle = false;
            for (int i = 1; i <= n; i++) {
                if (Bell(i)) {
                    isMinCycle = true;
                    sb.append("YES").append('\n');
                    break;
                }
            }

            if (!isMinCycle) {
                sb.append("NO").append('\n');
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
