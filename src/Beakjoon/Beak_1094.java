package Beakjoon;

import java.io.*;

/**
 * 2^5 ~ 2^0 까지 비트가 존재 for문을 6번 돈다.
 * ex) 23같은 경우 비트로 나타내면 0010111 이라면 여기서 1의 개수만 찾아주면 끝!
 */

public class Beak_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < 7; i++) {
            if ((x & (1 << i)) > 0) {
                result ++;
            }
        }

        System.out.println(result);
    }
}
