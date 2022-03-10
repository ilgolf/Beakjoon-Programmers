package Programmers;

public class CollectSticker {

    /**
     * index == 1 : dp[i] = max(dp[i], dp[i - 1])
     * index != 1  : dp[i] = max(dp[i - 1], dp[i - 2] + dp[i])
     */
    public int solution(int[] sticker) {
        int[] dpZero = new int[sticker.length];
        int[] dpOne = new int[sticker.length];

        // 1부터 시작
        dpZero[0] = sticker[0];
        dpZero[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            dpZero[i] = Math.max(dpZero[i - 1], dpZero[i - 2] + sticker[i]);
        }

        // 2부터 시작
        dpOne[0] = 0;
        dpOne[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dpOne[i] = Math.max(dpOne[i - 1], dpOne[i - 2] + sticker[i]);
        }

        return Math.max(dpZero[sticker.length - 2], dpOne[sticker.length - 1]);
    }
}
