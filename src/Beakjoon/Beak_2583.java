package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_2583 {

    static int n, m, k;
    static int[][] map;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        answer.append(results.size()).append('\n');

        results.stream()
                .sorted()
                .forEach(c -> answer.append(c).append(' '));

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        map[x][y] = 1;
        count ++;

        for (int i = 0; i < 4; i++) {
            int nx = x + moving[i][0];
            int ny = y + moving[i][1];

            if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) continue;

            if (map[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}
