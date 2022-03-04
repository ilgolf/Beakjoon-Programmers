package Programmers;

public class KaKao2022_07 {

    static int[] dirX = {0, 0, 1, -1};
    static int[] dirY = {1, -1, 0, 0};
    static int max = (int)1e9;

    static class WF {
        boolean win;
        int cnt;

        public WF(boolean win, int cnt) {
            this.win = win;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        WF result = dfs(board, aloc, bloc, 1, 0);

        return result.cnt;
    }

    private WF dfs(int[][] board, int[] aloc, int[] bloc, int turn, int move) {
        int ax = aloc[0];
        int ay = aloc[1];

        int bx = bloc[0];
        int by = bloc[1];

        if ((turn > 0 && board[ax][ay] == 0) || (turn < 0 && board[bx][by] == 0)) {
            return new WF(false, move);
        }

        int win = max;
        int lose = 0;

        for (int i = 0; i < 4; i++) {
            if (turn > 0) {
                int nAX = ax + dirX[i];
                int nAY = ay + dirY[i];

                if (0 > nAX || nAX >= board.length || 0 > nAY || nAY >= board[0].length) {
                    continue;
                }

                if (board[nAX][nAY] == 0) {
                    continue;
                }

                board[ax][ay] = 0;

                WF b = dfs(board, new int[] {nAX, nAY}, bloc, -turn, move + 1);

                if (!b.win) {
                    win = Math.min(win, b.cnt);
                }
                else {
                    lose = Math.max(lose, b.cnt);
                }

                board[ax][ay] = 1;
            }
            else {
                int nBX = bx + dirX[i];
                int nBY = by + dirY[i];

                if (0 > nBX || nBX >= board.length || 0 > nBY || nBY >= board[0].length) {
                    continue;
                }

                if (board[nBX][nBY] == 0) {
                    continue;
                }

                board[bx][by] = 0;

                WF a = dfs(board, aloc, new int[] {nBX, nBY}, -turn, move + 1);

                if (!a.win) {
                    win = Math.min(win, a.cnt);
                }
                else {
                    lose = Math.max(lose, a.cnt);
                }
                board[bx][by] = 1;
            }
        }

        if (win == max && lose == 0) {
            return new WF(false, move);
        }
        else if (win != max) {
            return new WF(true, win);
        }
        else {
            return new WF(false, lose);
        }
    }
}
