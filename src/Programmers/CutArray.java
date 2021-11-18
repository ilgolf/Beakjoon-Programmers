package Programmers;

import java.util.Arrays;

public class CutArray {

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        int i = 0;

        for (long idx = left; idx <= right; idx++) {
            int k = (int)(idx / n); // k 번째 열
            int l = (int)(idx % n); // k - l 번째 열

            answer[i ++] = Math.max(k + 1, l + 1);
        }

        return answer;
    }
}
