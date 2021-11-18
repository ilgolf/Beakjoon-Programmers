package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 2칸 위로, 1칸 오른쪽
 * 1칸 위로, 2칸 오른쪽
 * 1칸 아래로, 2칸 오른쪽
 * 2칸 아래로, 1칸 오른쪽
 */

public class Beak_1783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(1);
        }
        else if (n == 2) {
            System.out.println(Math.min((m+1)/2, 4));
        }
        else if (n > 3) {
            if (m < 7) {
                System.out.println(Math.min(m, 4));
            }
            else {
                System.out.println(m - 2);
            }
        }
    }
}
