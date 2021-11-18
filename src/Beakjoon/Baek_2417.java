package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2417 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long min = Long.MAX_VALUE;
        long num = Long.parseLong(br.readLine());
        long left = 0L;
        long right = num;

        while(left <= right) {

            long mid = ((right + left) / 2);
            long value = (long)Math.pow(mid, 2);

            if(value >= 0) {
                if(value >= num) {
                    min = Math.min(min, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(min);
    }
}
