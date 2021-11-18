package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1167 {

    static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    static int n;
    static List<ArrayList<Node>> list = new ArrayList<>();
    static boolean[] checked;
    static int node;
    static int max = 0;

    static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        checked[x] = true;

        for (int i = 0; i < list.get(x).size(); i++) {
            Node v = list.get(x).get(i);

            if (!checked[v.e]) {
                dfs(v.e, v.cost + len);
                checked[v.e] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());

                if (e == -1) break;

                int cost = Integer.parseInt(st.nextToken());

                list.get(s).add(new Node(e, cost));
            }
        }

        checked = new boolean[n + 1];
        dfs(1, 0);

        checked = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }
}
