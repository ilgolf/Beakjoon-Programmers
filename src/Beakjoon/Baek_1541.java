package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        String[] cal = br.readLine().split("-");

        for (int i = 0; i < cal.length; i++) {
            int temp = 0;
            String[] plus = cal[i].split("\\+");

            for (int j = 0; j < plus.length; j++) {
                temp += Integer.parseInt(plus[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
