package Beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_10026 {

    static class P {
        int  x,y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static char[][] map;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void bfs(int x, int y) {
        Queue<P> queue = new LinkedList<>();
        checked[x][y] = true;
        queue.offer(new P(x, y));
        char color = map[x][y];

        while (!queue.isEmpty()) {
            P curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == color) {
                        if (!checked[nx][ny]) {
                            checked[nx][ny] = true;
                            queue.offer(new P(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static void weakness(int x, int y) {
        Queue<P> queue = new LinkedList<>();
        checked[x][y] = true;
        queue.offer(new P(x, y));

        while (!queue.isEmpty()) {
            P curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                        if (!checked[nx][ny]) {
                            checked[nx][ny] = true;
                            queue.offer(new P(nx, ny));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int normal = 0; // 정상인 카운트
        int count = 0; // 적록색 카운트

        map = new char[n][n];
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R' && !checked[i][j]) {
                    bfs(i, j);
                    normal ++;
                }
                else if (map[i][j] == 'G' && !checked[i][j]) {
                    bfs(i, j);
                    normal ++;
                }
                else if (map[i][j] == 'B' && !checked[i][j]) {
                    bfs(i, j);
                    normal ++;
                }
            }
        }

        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((map[i][j] == 'R' || map[i][j] == 'G') && !checked[i][j]) {
                    weakness(i, j);
                    count ++;
                }
                else if (map[i][j] == 'B' && !checked[i][j]) {
                    bfs(i, j);
                    count ++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(normal + " " + count);
        bw.flush();
        bw.close();
    }
}
