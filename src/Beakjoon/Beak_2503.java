package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_2503 {

    static class BaseBallData {
        int data;
        int strike;
        int ball;

        public BaseBallData(int data, int strike, int ball) {
            this.data = data;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static int n;
    static List<BaseBallData> inputData = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int data = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            inputData.add(new BaseBallData(data, strike, ball));
        }

        System.out.println(calBaseBall());
    }

    private static int calBaseBall() {
        int result = 0;

        for (int baseBall = 123; baseBall <= 987; baseBall++) {
            if (!checkSameNum(baseBall)) continue;

            int allTestPass = 0;

            for (int i = 0; i < n; i++) {
                int strikeCount = 0;
                int ballCount = 0;

                BaseBallData cur = inputData.get(i);
                String currentData = Integer.toString(cur.data);
                String myData = Integer.toString(baseBall);

                for (int j = 0; j < 3; j++) {
                    if (currentData.charAt(j) == myData.charAt(j)) {
                        strikeCount ++;
                    }
                }

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (myData.charAt(j) == currentData.charAt(k)) {
                            if (j != k) {
                                ballCount ++;
                            }
                        }
                    }
                }

                if (cur.strike == strikeCount && cur.ball == ballCount) {
                    allTestPass ++;
                }
            }

            if (allTestPass == n) {
                result ++;
            }
        }

        return result;
    }

    private static boolean checkSameNum(int num) {
        String numString = Integer.toString(num);

        if (numString.charAt(0) == numString.charAt(1)) {
            return false;
        }
        if (numString.charAt(1) == numString.charAt(2)) {
            return false;
        }
        if (numString.charAt(0) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0') {
            return false;
        }

        return true;
    }
}
