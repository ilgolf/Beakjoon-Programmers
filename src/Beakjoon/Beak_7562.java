package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_7562 {

    static class Chess {
        int x, y, cnt;

        public Chess(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int n;
    static int[][] map;
    static int[][] moving = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            resultBuilder.append(bfs(startX, startY, endX, endY)).append('\n');
        }

        System.out.println(resultBuilder.toString().trim());
    }

    private static int bfs(int sX, int sY, int eX, int eY) {
        Queue<Chess> queue = new LinkedList<>();

        // 1. 체크인
        queue.offer(new Chess(sX, sY, 0));
        map[sX][sY] = 1;

        while (!queue.isEmpty()) {
            Chess cur = queue.poll();

            // 2. 목적지 인가?
            if (cur.x == eX && cur.y == eY) {
                return cur.cnt;
            }

            // 2. 연결 된 곳을 순회
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + moving[i][0];
                int ny = cur.y + moving[i][1];

                // 3. 갈 수 있는가?
                if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
                if (map[nx][ny] == 1) continue;

                // 4. 간다.
                map[nx][ny] = 1;
                queue.offer(new Chess(nx, ny, cur.cnt + 1));
            }
        }

        return -1;
    }
}
