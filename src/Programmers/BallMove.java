package Programmers;

public class BallMove {

    public long solution(int n, int m, int x, int y, int[][] queries) {
        long rs = x, re = x, cs = y, ce = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int way = queries[i][0], step = queries[i][1];

            switch (way) {
                case 0:
                    if (cs > 0) cs += step;
                    ce = Math.min(m - 1, ce + step);
                    break;
                case 1:
                    if (ce < m - 1) ce -= step;
                    cs = Math.max(0, cs - step);
                    break;
                case 2:
                    if (rs > 0) rs += step;
                    re = Math.min(n -1, re + step);
                    break;
                default:
                    if (re < n - 1) re -= step;
                    rs = Math.max(0, rs - step);
                    break;
            }

            if (rs >= n || re < 0 || cs >= m || ce < 0) return 0;
        }

        return (re - rs + 1) * (ce - cs + 1);
    }
}
