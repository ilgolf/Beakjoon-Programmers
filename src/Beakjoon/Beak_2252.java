package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2252 {

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inDegree = new int[n + 1];

        // 정점 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결 : a -> b
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inDegree[b] ++;
        }

        // 진입 차수가 0인 정점 큐 삽입
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐에서 원소를 꺼내 연결된 모든 간선 제거
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);

            for (int val : graph.get(node)) {
                inDegree[val] --;

                // 제거 후 진입 차수가 0이된 정점 삽입
                if (inDegree[val] == 0) {
                    queue.offer(val);
                }
            }
        }

        System.out.println(result);
    }
}
