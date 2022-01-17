package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Beak_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
        boolean flag = true;

        int answer = 0;

        int nums = 1;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '(') {
                stack.add(cur);
                nums *= 2;
            }
            else if (cur == '[') {
                stack.add(cur);
                nums *= 3;
            }
            else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    answer += nums;
                }
                if (!stack.isEmpty()) stack.pop();
                nums /= 2;
            }
            else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    answer += nums;
                }
                if (!stack.isEmpty()) stack.pop();
                nums /= 3;
            }
            else {
                System.out.println(0);
                return;
            }
        }

        if (!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
