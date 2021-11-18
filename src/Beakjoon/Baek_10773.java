package Beakjoon;

/**
 *
 * 0 : pop, 1 ~ : offer
 *
 */

import java.io.*;
import java.util.Stack;

public class Baek_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
            }
            else {
                stack.add(num);
            }
        }

        int sum = 0;
        for (int val : stack) {
            sum += val;
        }

        System.out.println(sum);
    }
}
