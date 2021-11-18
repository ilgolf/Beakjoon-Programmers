package Programmers;

public class BinaryGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder("0");
        int count = 0;

        while (str.length() < (t * m + p)) {
            StringBuilder binaryNum = new StringBuilder();
            int num = count ++;

            while (num != 0) {
                if (num % n >= 10) {
                    binaryNum.append((char) (num % n + 55));
                } else {
                    binaryNum.append(num % n);
                }
                num /= n;
            }
            str.append(binaryNum.reverse());
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < t; i++) {
            answer.append(str.toString().charAt(m * i + p - 1));
        }

        return answer.toString();
    }
}
