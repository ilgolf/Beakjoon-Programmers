package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1197 {

    static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int n, m;
    static List<Node> list = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        // self loop로 초기화
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        // 간선 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, weight));
        }

        // 간선 가중치를 기준으로 오름차순 정렬
        list.sort(Comparator.comparingInt(o -> o.weight));

        int result = 0;
        for (Node node : list) {
            if (!union(node.start, node.end)) continue;

            result += node.weight;
        }

        System.out.println(result);
    }

    private static boolean union(int start, int end) {
        int aRoot = find(start);
        int bRoot = find(end);

        if (aRoot == bRoot) {
            return false;
        } else {
            parents[aRoot] = bRoot;
            return true;
        }
    }

    private static int find(int val) {
        if (parents[val] == val) return val;

        return parents[val] = find(parents[val]);
    }
}
