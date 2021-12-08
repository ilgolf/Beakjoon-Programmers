package Programmers;

public class DriverGold {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = Long.MAX_VALUE;

        long left = 0L;
        long right = (long)(1e9 * 1e5 * 4 - 1e5); // 배달 최대 걸리는 시간

        long mid;

        // 이분 탐색 시작
        while (left <= right) {
            mid = (left + right) / 2;

            long gMin = 0, sMin = 0, gsMin = 0;

            for (int i = 0; i < t.length; i++) {
                long c = (long)Math.ceil((double)(mid / t[i]) / 2); // 옮길 수 있는 양

                long wt = c * w[i]; // 토탈 시간

                gMin += Math.min(g[i], wt); // 토탈 시간을 넘으면 안됨
                sMin += Math.min(s[i], wt);
                gsMin += Math.min(g[i] + s[i], wt); // 둘 이 합쳐서 가져갈 경우 최솟값이 나올 수 있으므로
            }

            // 각각 유효한 값인지 확인 후 정답 갱신 및 범위 축소
            if (a <= gMin && b <= sMin && (a + b) <= gsMin) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
