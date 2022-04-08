package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_2644 {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int result = -1;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        checked = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(a, b, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int end, int depth) {
        // 1. 목적지 인가? : start == end일 경우 종료
        if (start == end) {
            result = depth;
            return;
        }

        // 2. 체크인
        checked[start] = true;

        for (int next : graph.get(start)) {
            if (!checked[next]) {
                dfs(next, end, depth + 1);
            }
        }
    }
}
