package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_11724 {

    static int n,m;
    static int[][] graph;
    static boolean[] checked;

    static void dfs(int start) {
        checked[start] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1 && !checked[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        checked = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!checked[i]) {
                dfs(i);
                count ++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
