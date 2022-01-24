package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1922 {

    static class Network {
        int start;
        int end;
        int distance;

        public Network(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static int n, m;
    static int[] parents;
    static List<Network> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];

        // 정점간 간선 연결
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Network(start, end, weight));
        }

        // self loop로 초기화
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        // 간선 기준 오름차순으로 정렬
        list.sort(Comparator.comparingInt(o -> o.distance));

        int result = 0;
        for (Network network : list) {
            // 사이클이 존재하면 그래프에 추가 x
            if (!union(network.start, network.end)) continue;

            // 사이클이 아니라면 그대로 그래프에 추가하여 거리 계산
            result += network.distance;
        }

        System.out.println(result);
    }

    /**
     * 유니온 파인드 알고리즘
     */
    private static boolean union(int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a == b) {
            return false;
        }

        else {
            parents[b] = a;
        }
        return true;
    }

    private static int find(int val) {
        if (parents[val] == val) {
            return val;
        }

        return parents[val] = find(parents[val]);
    }
}
