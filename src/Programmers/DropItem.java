package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DropItem {

    static class P {
        int x1, y1, x2, y2;

        public P(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static final int SIZE = 51 * 2;
    static int[][] map = new int[SIZE][SIZE];
    static int[][] moving = {{1, 0}, {-1, 0}, {-1, 0}, {1, 0}};
    static List<P> list;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer;
        list = new ArrayList<>();

        for (int[] rec : rectangle) {
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int ex = rec[2] * 2;
            int ey = rec[3] * 2;

            for (int i = sy; i <= ey; i++) {
                for (int j = sx; j <= ex; j++) {
                    map[i][j] = -1;
                }
            }

            list.add(new P(sx, sy, ex, ey));
        }

        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer;
    }

    private int bfs(int x, int y, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 1});
        map[y][x] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int px = cur[0];
            int py = cur[1];
            int move = cur[2];

            System.out.println("px = " + px + " py = " + py);

            if (px == tx && py == ty) {
                return (move / 2);
            }

            for (int[] ints : moving) {
                int nx = px + ints[1];
                int ny = py + ints[0];

                if (map[ny][nx] < 0 && isBoundary(nx, ny)) {
                    map[ny][nx] = move + 1;
                    queue.offer(new int[] {nx, ny, move + 1});
                }
            }
        }
        return -1;
    }

    private boolean isBoundary(int nx, int ny) {
        for (P p : list) {
             if (p.x1 < nx && p.y1 < ny && p.x2 > nx && p.y2 > ny) {
                 return false;
             }
        }
        return true;
    }
}
