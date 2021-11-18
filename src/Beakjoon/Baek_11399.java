package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i + 1; j++) {
                sum += people[j];
            }
            result += sum;
        }

        System.out.println(result);
    }
}
