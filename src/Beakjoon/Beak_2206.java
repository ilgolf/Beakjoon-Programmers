package Beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_2206 {

    static class P {
        int x,y;
        int dist;
        int broken;

        public P(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    static int n, m;
    static int[][] map;
    static int[][] checked;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int bfs() {
        Queue<P> queue = new LinkedList<>();
        checked[0][0] = 0;
        queue.offer(new P(0, 0, 1, 0));

        while (!queue.isEmpty()) {
            P curr = queue.poll();

            if (curr.x == n - 1 && curr.y == m - 1) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (checked[nx][ny] <= curr.broken) continue;

                if (map[nx][ny] == 0) {
                    checked[nx][ny] = curr.broken;
                    queue.offer(new P(nx, ny, curr.dist + 1, curr.broken));
                }
                else if (map[nx][ny] == 1) {
                    if (curr.broken == 0) {
                        checked[nx][ny] = curr.broken + 1;
                        queue.offer(new P(nx, ny, curr.dist + 1, curr.broken + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        checked = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                checked[i][j] = Integer.MAX_VALUE;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }
}
