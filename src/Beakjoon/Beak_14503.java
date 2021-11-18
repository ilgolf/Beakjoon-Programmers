package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 현재 위치를 청소한다.
 * 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
 *      a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 *      b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 *      c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 *      d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 */

public class Beak_14503 {

    static class Robot {
        int x, y; // 로봇 위치
        int direction; // 방향

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int n, m;
    static int[][] map;  // 0: 길, 1: 벽
    static boolean[][] checked;
    static int[][] moving = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 북, 1: 동, 2: 남, 3: 서
    static int count = 0;

    static void clean(int x, int y, int d) {

       if (map[x][y] == 0) {
           map[x][y] = 2;
           count ++;
       }

       boolean flag = false;
       int origin = d;
        for (int i = 0; i < 4; i++) {
            int nDir = (d + 3) % 4;
            int nx = x + moving[nDir][0];
            int ny = y + moving[nDir][1];

            if (isValid(nx, ny)) continue;

            if (map[nx][ny] == 0) {
                clean(nx, ny, nDir);
                flag = true;
                break;
            }
            d = (d + 3) % 4;
        }

        if (!flag) {
            int nDir = (origin + 2) % 4;
            int nx = x + moving[nDir][0];
            int ny = y + moving[nDir][1];

            if (!isValid(nx, ny)) {
                if (map[nx][ny] != 1) {
                    clean(nx, ny, origin);
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        checked = new boolean[n][m];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 시작 위치
        int c = Integer.parseInt(st.nextToken()); // 시작 위치
        int d = Integer.parseInt(st.nextToken()); // 방향

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);

        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
