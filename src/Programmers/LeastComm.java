package Programmers;

public class LeastComm {

    static int GCD(int n1, int n2) {
        if (n2 == 0) return n1;

        return GCD(n2, n1 % n2);
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int j : arr) {
            int prev = GCD(answer, j);

            answer = answer * j / prev;
        }

        return answer;
    }
}
