package Beakjoon;

import java.io.*;
import java.util.Stack;

/**
 *
 * 1234 -> 12 -> 1256 -> 12578 ->
 * 4,3,6,8,7,5,2,1
 *
 */

public class Baek_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while(n -- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(start < num) {
                for (int i = start + 1; i <= num; i++) {
                    stack.add(i);
                    sb.append('+').append('\n');
                }
                start = num;
            }
            else if (num != stack.peek()) {
                    System.out.printf("%s", "NO");
                    return;
            }


            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
