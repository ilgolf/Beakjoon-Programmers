package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_3955 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            st = new StringTokenizer(br.readLine());
            // X : 인당 나눠줄 사탕의 수
            // Y : 사탕 봉지의 수
            // A * X + 1 = B * y
            // Ax + By = C의 형태로 변환
            // -Ax + By = 1
            // A(-x) + By = 1의 형태로 변환
            long a = Long.parseLong(st.nextToken()); // 파티원
            long b = Long.parseLong(st.nextToken()); // 들어있는 사탕 수

            long x, y, d;

            EGResult egResult = extendedGCD(a, b);

            // 1. 해 검증
            // D = gcd(A, B) = egcd(A, B),r
            d = egResult.r;
            // AX + BY = C 일때 C % D == 0 이어야 해를 가질 수 있음 : 베주 항등식
            // C % D != 0 -> 해가 없음
            if (d != 1) {
                result.append("IMPOSSIBLE").append('\n');
                continue;
            } else {
                long x0, y0;

                // 2. 초기 해 구하기
                // x0 = s * c / D
                // y0 = t * c / D
                x0 = egResult.s;
                y0 = egResult.t;

                // 3. 일반 해 구하기
                // x = x0 + B / D * k
                // y = y0 - A / D * k


                // 4. k의 범위
                // x < 0
                // x0 + B * k < 0
                // k < -x0 / B

                // 0 < y < 1e9
                // 0 < y0 - A / D * k <= 1e9
                // -y0 < -A * k <= 1e9 - y0
                // (y0 - 1e9) / A <= k < y0 / A

                // (y0 - 1e9) / A <= k < y0 / A
                //                   k < -x0 / B  <- ceil - 1
                long kFromY = (long) Math.ceil((double) y0 / (double) a) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) b) - 1;
                long k = Math.min(kFromX, kFromY);

                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) a);

                // 5. 만족하는 K가 있는지 찾고 k를 통해 y를 구한다.
                if (kLimitFromY <= k) {
                    result.append(y0 - a * k).append('\n');
                } else {
                    result.append("IMPOSSIBLE").append('\n');
                }
            }
        }

        System.out.println(result);
    }

    static EGResult extendedGCD(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 % r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }

        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }
}