package Beakjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_1259 {

    static String reverse(String n) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();

        for (char ch : n.toCharArray()) {
            deque.offer(ch);
        }

        for (int i = 0; i < n.length(); i++) {
            str.append(deque.pollLast());
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = "";

        while(true) {
            n = br.readLine();
            
            if(n.equals("0")) {
                break;
            }
            
            String reverseN = reverse(n);

            if(n.equals(reverseN)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}
