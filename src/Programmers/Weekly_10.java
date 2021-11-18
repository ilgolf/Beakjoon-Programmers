package Programmers;

import java.util.*;

/**
 * y = 2x + 4
 * y = 2x - 4
 * y = 1
 * 8y = 5x - 12
 * -8y = 5x + 12
 */

public class Weekly_10 {

    static class Point {
        long y,x;

        public Point(long y, long x) {
            this.y = y;
            this.x = x;
        }
    }

    public static String[] solution(int[][] lines) {
        PriorityQueue<Point> points = new PriorityQueue<>(((o1, o2) -> {
            if (o1.y == o2.y) return (int)(o2.x - o1.x);
            return (int)(o2.y - o1.y);
        }));

        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        for (int i = 0; i < lines.length - 1; i++) {

            long a = lines[i][0];
            long b = lines[i][1];
            long e = lines[i][2];
            long x,y;

            for (int j = i + 1; j < lines.length; j++) {
                long c = lines[j][0];
                long d = lines[j][1];
                long f = lines[j][2];

                long bottom = a * d - b * c;
                if (bottom == 0) continue;

                x = (b * f - e * d) / bottom;
                y = (e * c - a * f) / bottom;

                if ((double)(b * f - e * d) / bottom != x) continue;
                if ((double)(e * c - a * f) / bottom != y) continue;

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);

                points.add(new Point(y, x));
            }
        }

        String[] answer = new String[(int)(maxY - minY + 1)];

        String str = ".";
        StringBuilder sb = new StringBuilder(str.repeat((int)(maxX - minX + 1)));
        Arrays.fill(answer, sb.toString());

        long curY = points.peek() != null ? points.peek().y : 0L;

        while (!points.isEmpty()) {
            Point cur = points.remove();
            if(cur.y != curY) {
                answer[(int)-(curY - maxY)] = sb.toString();
                curY = cur.y;
                sb = new StringBuilder(str.repeat((int)(maxX - minX + 1)));
            }
            sb.replace((int)(cur.x - minX), (int)(cur.x - minX + 1), "*");
        }
        answer[(int)-(curY - maxY)] = sb.toString();

        return answer;
    }
}