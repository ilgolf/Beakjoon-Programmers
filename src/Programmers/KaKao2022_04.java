package Programmers;

import java.util.Arrays;

/**
 * 전형적인 BackTracking 문제
 * 10개의 배열을 만든 후 해당 max 값과 배열을 저장한다.
 */
public class KaKao2022_04 {

    static int max = 0; // 라이언이 어피치를 이길 수 있는 최대 점수
    static int[] result = {-1};
    static int[] ryan = new int[11];

    public static int[] solution(int n, int[] info) {
        int[] ryan = new int[11]; // 점수를 담을 List배열

        comb(1, n, info); // depth, r, ryan

        return result;
    }

    private static void comb(int depth, int n, int[] info) {
        // 1. 체크인 (생략)

        // 2. 목적지인가?
        if (depth == n + 1) {
            isDifference(ryan, info);
            return;
        }

        // 4. 연결 된 곳을 순회
        for (int i = 0; i <= 10 && ryan[i] <= info[i]; i++) {
            // 1. 체크인
            ryan[i] ++;

            // 2. 간다.
            comb(depth + 1, n, info);

            // 3. 체크아웃
            ryan[i] --;
        }

    }

    private static void isDifference(int[] ryan, int[] info) {
        int peachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue;

            if (info[i] < ryan[i]) {
                ryanScore += (10 - i);
            }
            else {
                peachScore += (10 - i);
            }
        }

        if (ryanScore > peachScore) {
            if (ryanScore - peachScore >= max) {
                result = ryan.clone();
                max = ryanScore - peachScore;
            }
        }
    }
}
