package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_4963 {

    static class Island {
        int x, y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][] checked;
    static int count;
    static int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            checked = new boolean[n][m];
            count = 0;

            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !checked[i][j]) {
                        bfs(i, j);
                        count ++;
                    }
                }
            }

            resultBuilder.append(count).append('\n');
        }

        System.out.println(resultBuilder);
    }

    private static void bfs(int x, int y) {
        Queue<Island> queue = new LinkedList<>();

        queue.offer(new Island(x, y));
        checked[x][y] = true;

        while (!queue.isEmpty()) {
            Island cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + moving[i][0];
                int ny = cur.y + moving[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (checked[nx][ny] || map[nx][ny] == 0) continue;

                if (map[nx][ny] == 1) {
                    checked[nx][ny] = true;
                    queue.offer(new Island(nx, ny));
                }
            }
        }
    }
}
