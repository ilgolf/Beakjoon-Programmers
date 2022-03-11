package Programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class NightShift {

    /**
     * 자 생각해보자, 숫자가 커질 수록 제곱 끼리의 차이가 커진다. 그렇기에 가장 큰수를 빼줘야한다.
     * for 문을 돌면서 n이 0이 될 때 까지 우선순위 큐에서 꺼내서 빼고 넣어주고를 반복하자
     * 그럼 답이 나올 것이다.
     */
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        for (int work : works) {
            queue.offer(work);
        }

        while (n > 0) {

            int work = queue.poll() - 1;
            queue.offer(work);

            n --;
        }

        while (!queue.isEmpty()) {
            answer += (long)(Math.pow(queue.poll(), 2));
        }

        return answer;
    }
}
