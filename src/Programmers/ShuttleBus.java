package Programmers;

import java.util.PriorityQueue;

public class ShuttleBus {

    static class Crew implements Comparable<Crew> {

        int h, m;

        public Crew(int h, int m) {
            if (m < 0) {
                m += 60;
                h --;
            }
            if (m >= 60) {
                m -= 60;
                h ++;
            }

            this.h = h;
            this.m = m;
        }

        @Override
        public int compareTo(Crew o) {
            if (this.h == o.h) return this.m - o.m;

            return this.h - o.h;
        }
    }

    static PriorityQueue<Crew> queue = new PriorityQueue<>();
    static String answer = "";

    static void bus(int n, int t, int m) {
        Crew crew = new Crew(9, 0);
        Crew corn = new Crew(9, 0);

        for (int i = 0; i < n; i++) {
            int people = 0;

            for (int j = 0; j < m; j++) {
                if (!queue.isEmpty()) {
                    Crew temp = queue.peek();

                    if (crew.compareTo(temp) >= 0) {
                        corn = queue.poll();
                        people ++;
                    }
                }

                if (i == n - 1 && people == m) {
                    corn = new Crew(corn.h, corn.m - 1);
                }
                else if (i == n - 1 && people < m) {
                    corn = new Crew(crew.h, crew.m);
                }
            }

            crew = new Crew(crew.h, crew.m + t);
        }

        answer += (corn.h < 10 ? "0" + corn.h : corn.h) + " : " + (corn.m < 10 ? "0" + corn.m : corn.m);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        for (String value : timetable) {
            String[] s = value.split(":");

            queue.offer(new Crew(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        bus(n, t, m);

        return answer;
    }
}
