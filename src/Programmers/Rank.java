package Programmers;

import java.util.Arrays;

public class Rank {

    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] boxing = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            boxing[result[0]][result[1]] = true;
        }

        System.out.println(Arrays.deepToString(boxing));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    boxing[j][k] = boxing[j][i] && boxing[i][k];
                }
            }
        }

        System.out.println(Arrays.deepToString(boxing));

        for (int i = 0; i <= n; i++) {
            int result = 0;
            for (int j = 0; j <= n; j++) {
                if (boxing[i][j] || boxing[j][i]) {
                    result++;
                }
            }
            if (result == n) answer ++;
        }

        return answer;
    }
}
