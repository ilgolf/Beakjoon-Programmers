package Beakjoon;

import java.io.*;

public class Baek_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int n = Integer.parseInt(br.readLine());
        int check = 666;

        while(count < n) {
            String title = String.valueOf(check);

            if(title.contains("666")) {
                count ++;
            }
            check ++;
        }

        System.out.println(check - 1);
    }
}
