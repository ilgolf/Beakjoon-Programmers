package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_1967 {

    static class Node {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }

    static int n;
    static List<ArrayList<Node>> tree = new ArrayList<>();
    static boolean[] checked;
    static int max = 0, maxIdx = 0;

    static void dfs(int start, int count) {
        if (max < count) {
            max = count;
            maxIdx = start;
        }

        for (Node node : tree.get(start)) {
            if (!checked[node.idx]) {
                checked[node.idx] = true;
                dfs(node.idx, count + node.distance);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        checked = new boolean[n + 1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Node(end, cost));
            tree.get(end).add(new Node(start, cost));
        }

        checked[1] = true;
        dfs(1, 0);

        checked = new boolean[n + 1];
        checked[maxIdx] = true;
        dfs(maxIdx, 0);
        System.out.println(max);
    }
}
