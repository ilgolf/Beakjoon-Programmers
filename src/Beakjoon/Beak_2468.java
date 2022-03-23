package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2468 {

    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        int max = 0;
        for (int height = 0; height <= maxHeight; height++) {
            checked = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!checked[i][j] && map[i][j] > height) {
                        cnt += dfs(i, j, height);
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static int dfs(int x, int y, int height) {
        checked[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + moving[i][0];
            int ny = y + moving[i][1];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;

            if (!checked[nx][ny] && map[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }

        return 1;
    }
}
