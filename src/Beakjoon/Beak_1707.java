package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1707 {

    static final int CHECK_COLOR = 1; // 정점 색칠 변수
    static int v, e;
    static List<ArrayList<Integer>> graph;
    static boolean isDoubleGraph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < k; testcase++) {
            st = new StringTokenizer(br.readLine());
            graph = new ArrayList<>();

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            isDoubleGraph = true;
            colors = new int[v + 1];

            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i <= v; i++) {
                if (!isDoubleGraph) {
                    break;
                }

                if (colors[i] == 0) {
                    dfs(i, CHECK_COLOR);
                }
            }

            resultBuilder.append(isDoubleGraph ? "YES" : "NO").append('\n');
        }
        System.out.println(resultBuilder);
    }

    private static void dfs(int start, int color) {
        // 1. 체크인 : 색깔 칠하기
        colors[start] = color;

        // 2. 연결된 곳을 순회 : 연결된 그래프 간선 탐색
        for (int vertex : graph.get(start)) {
            // 3. 목적지 인가? : 이미 색칠이 되있음 이분 그래프 X
            if (colors[vertex] == color) {
                isDoubleGraph = false;
                return;
            }

            // 4. 갈 수 있는가? : 색칠이 안되어있다면 순회
            if (colors[vertex] == 0) {
                dfs(vertex, -color);
            }
        }
    }
}
