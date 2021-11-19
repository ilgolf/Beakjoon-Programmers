package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!queue.isEmpty() && priorities[i] == queue.peek()) {
                    if (location == i) {
                        return answer;
                    }
                    queue.poll();
                    answer ++;
                }
            }
        }

        return answer;
    }
}
