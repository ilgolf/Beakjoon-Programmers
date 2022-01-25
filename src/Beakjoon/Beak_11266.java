package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beak_11266 {

    static int v, e;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count = 0; // 단절점 개수
    static StringBuilder sb = new StringBuilder();
    static int order = 0; // 방문 정점
    static int[] searchOrder; // order 탐색 기록
    static boolean[] isCutVertex; // 단절점 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        searchOrder = new int[v + 1];
        isCutVertex = new boolean[v + 1];

        // 그래프 정점 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 잇기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 탐색을 하지 않는 경우 == 0일경우 dfs
        for (int i = 1; i <= v; i++) {
            if (searchOrder[i] == 0) {
                dfs(i, true);
            }
        }

        for (int i = 1; i <= v; i++) {
            if (isCutVertex[i]) {
                count ++;
                sb.append(i).append(' ');
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }

    private static int dfs(int now, boolean isRoot) {

        // 체크인
        order ++;
        searchOrder[now] = order;

        int num = order;
        int child = 0;

        // 탐색 가능한 정점 탐색
        for (int next : graph.get(now)) {
            if (searchOrder[next] == 0) {
                child ++; // 루트 노드 일경우 자식 노드 ++

                int low = dfs(next, false);


                // 1. 루트가 아닌데 order <= low
                if (!isRoot && low >= searchOrder[now]) {
                    isCutVertex[now] = true;
                }

                // 최솟값 갱신
                num = Math.min(num, low);
            } else {
                num = Math.min(num, searchOrder[next]);
            }
        }

        // 자식 트리가 2개 이상인 루트 일 경우 단절 점
        if (isRoot && child >= 2) {
            isCutVertex[now] = true;
        }

        return num;
    }
}
