package Programmers;

import java.util.*;

public class DevelopPro {

    public static int[] solution(int[] progresses, int[] speeds) {
       Stack<Integer> stack = new Stack<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }

        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            int count = 1;

            int top = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= top) {
                count ++;
                stack.pop();
            }

            list.add(count);
        }

        int[] answer = new int[list.size()];

        int k = 0;
        for (Integer val : list) {
            answer[k ++] = val;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
