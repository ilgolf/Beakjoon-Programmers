package Programmers;

public class NomalSqauer {

    static long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static long solution(int w, int h) {
        long answer = 0;

        long num = gcd(w, h);

        answer = ((long) w * h) - ((w / num) + (h / num) - 1) * num;

        return answer;
    }
}
