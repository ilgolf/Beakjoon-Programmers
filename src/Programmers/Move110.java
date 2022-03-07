package Programmers;

import java.util.Stack;

public class Move110 {

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }

        return answer;
    }

    private String solve(String s) {
        int cnt = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= 3) {
                char first = stack.pop();

                if (first != '0') {
                    stack.push(first);
                    continue;
                }

                char second = stack.pop();
                if (second != '1') {
                    stack.push(second);
                    stack.push(first);
                    continue;
                }

                char third = stack.pop();
                if (third != '1') {
                    stack.push(third);
                    stack.push(second);
                    stack.push(first);
                    continue;
                }

                cnt ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int pos = stack.size();
        boolean flag = false;

        // 맨 마지막 부터 0을 발견할 때 까지 위치 이동
        while (!stack.isEmpty()) {
            char pop = stack.pop();

            if (!flag && pop == '1') pos --;
            if (pop == '0') flag = true;

            sb.insert(0, pop);
        }

        String fix = "";
        for (int i = 0; i < cnt; i++) {
            sb.insert(pos, "110");
        }

        return sb.toString();
    }
}
