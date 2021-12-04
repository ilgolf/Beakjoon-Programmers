package Programmers;

import java.util.Stack;

public class ModifyTable {

    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> update = new Stack<>();

        int table = n;

        for (String c : cmd) {
            if (c.startsWith("C")) {
                update.push(k);
                table --;
                if (table == k) k--;
            }
            else if (c.startsWith("Z")) {
                int r = update.pop();
                if (k >= r) k++;
                table ++;
            }
            else if (c.startsWith("D")) {
                k += Integer.parseInt(c.split(" ")[1]);
            }
            else if (c.startsWith("U")) {
                k -= Integer.parseInt(c.split(" ")[1]);
            }
        }

        answer.append("O".repeat(Math.max(0, table)));

        while (!update.isEmpty()) {
            answer.insert(update.pop(), "X");
        }

        return answer.toString();
    }
}
