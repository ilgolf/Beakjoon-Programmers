package Programmers;

import java.util.*;

public class DiskController {

    static class Disk {
        int start;
        int length;

        public Disk(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Disk> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.length));

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int sum = 0;
        int end = 0;
        int jobIdx = 0;

        while (count < jobs.length) {

            while (jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                queue.offer(new Disk(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx ++;
            }

            if (queue.isEmpty()) {
                end = jobs[jobIdx][0];
            } else {
                Disk cur = queue.poll();
                sum += cur.length + end - cur.start;
                end += cur.length;
                count ++;
            }
        }

        return sum / jobs.length;
    }
}