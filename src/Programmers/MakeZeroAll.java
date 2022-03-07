package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MakeZeroAll {

    static List<Integer>[] tree;
    static long[] inDegree;
    static long[] arr;
    static boolean[] checked;
    static long answer = 0;

    public long solution(int[] a, int[][] edges) {
        tree = new ArrayList[a.length];
        inDegree = new long[a.length];
        arr = new long[a.length];
        checked = new boolean[a.length];

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            arr[i] = a[i];
            tree[i] = new ArrayList<>();
        }

        // 모든 합이 0이 아니면 정답이 안나옴
        if (sum != 0) return -1;

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
            inDegree[edge[0]] ++;
            inDegree[edge[1]] ++;
        }

        bfs();

        return answer;
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 연결된 모든 간선 Queue 추가
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            // 1. Queue에서 빼오기
            int cur = queue.poll();
            // 2. 체크 인
            checked[cur] = true;

            // 3. 연결 된 곳을 순회
            for (int next : tree[cur]) {
                // 4. 갈 수 있는가? : 방문 한적 없는 곳만 순회
                if (!checked[next]) {
                    // 체크 아웃 : 방문 했으니 간선 삭제
                    inDegree[next] --;
                    arr[next] += arr[cur];
                    answer += Math.abs(arr[cur]); // 정답 갱신
                    arr[cur] = 0;
                    // 다시 Queue에다 넣고 순회
                    if (inDegree[next] == 1) queue.offer(next);
                }
            }
        }
    }
}
