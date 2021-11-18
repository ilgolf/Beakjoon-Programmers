package Beakjoon;

import java.io.*;
import java.util.*;

/**
 * 스택에 각 명령어와 각 시간 초를 저장하고 시간이 지났을 때 조건에 따라 pop해준다.
 * 이동 시 벽에 걸리거나 자기 자신 (2)에 걸리면 종료
 */

public class Beak_3190 {

    static class Command {
        int sec;
        String str;

        public Command(int sec, String str) {
            this.sec = sec;
            this.str = str;
        }
    }

    static class P {
        int x, y, dir;

        public P(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int n, k, l;
    static int[][] map;
    static int[][] moving = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우 -> 하 -> 좌 -> 상
    static Queue<Command> cmd = new LinkedList<>();
    static List<P> snake = new ArrayList<>();

    /**
     * Queue에 각 명령어와 각 시간 초를 저장하고 시간이 지났을 때 조건에 따라 pop해준다.
     * 이동 시 벽에 걸리거나 자기 자신 (2)에 걸리면 종료
     */

    // 처음엔 오른쪽으로 가면서 0부터 시작
    static int moveSnake() {
        int count = 0;
        int nDir = 0;
        int x = 0, y = 0;
        snake.add(new P(0, 0, 0));

        while (true) {
            count ++;

            int nx = x + moving[nDir][0];
            int ny = y + moving[nDir][1];

            if (!isFinish(nx, ny)) return count;

            if (map[nx][ny] == 1) {
                snake.add(new P(nx, ny, nDir));
                map[nx][ny] = 0;
            }
            else {
                snake.add(new P(nx, ny, nDir));
                snake.remove(0); // 꼬리 제거
            }

            x = nx;
            y = ny;

            if (!cmd.isEmpty()) {
                if (count == cmd.peek().sec) {
                    nDir = validDir(nDir) % 4;
                }
            }
        }
    }

    private static boolean isFinish(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return false;
        }
        for (P s : snake) {
            if (s.x == nx && s.y == ny) return false;
        }

        return true;
    }

    static int validDir(int dir) {
        Command c = cmd.poll();

        return c.str.equals("L") ? dir + 1 : dir + 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            cmd.offer(new Command(x, c));
        }

        System.out.println(moveSnake());
    }
}
