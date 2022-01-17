package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Beak_8979 {

    static class Nation implements Comparable<Nation> {
        int gold, silver, bronze, idx;

        public Nation(int gold, int silver, int bronze, int idx) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.idx = idx;
        }

        @Override
        public int compareTo(Nation o) {
            if (o.gold == this.gold) {
                if (o.silver == this.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Nation> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Nation target = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            if (idx == k) {
                target = new Nation(gold, silver, bronze, idx);
            }

            queue.offer(new Nation(gold, silver, bronze, idx));
        }

        int rank = 1;
        while (!queue.isEmpty()) {
            Nation cur = queue.poll();

            if (checkRank(cur, target)) {
                System.out.println(rank);
                break;
            }

            rank ++;
        }
    }

    private static boolean checkRank(Nation cur, Nation prev) {
        return cur.gold == prev.gold && cur.silver == prev.silver && cur.bronze == prev.bronze;
    }
}
