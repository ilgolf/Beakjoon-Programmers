package Programmers;

public class KaKao2022_06 {

    static int n, m;
    static int[][] prefixArr;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;
        m = board[0].length;

        prefixArr = new int[board.length + 1][board[0].length + 1];

        // 누적합
        for (int[] s : skill) {
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[0] == 1 ? -s[5] : s[5];

            prefixArr[r1][c1] += degree;
            prefixArr[r1][c2 + 1] -= degree;
            prefixArr[r2 + 1][c1] -= degree;
            prefixArr[r2 + 1][c2 + 1] += degree;
        }
        operate();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + prefixArr[i][j] > 0) {
                    answer ++;
                }
            }
        }
        return answer;
    }

    private void operate() {
        // 상하
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixArr[i][j] += prefixArr[i - 1][j];
            }
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                prefixArr[i][j] += prefixArr[i][j - 1];
            }
        }
    }
}
