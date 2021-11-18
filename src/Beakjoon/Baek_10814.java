package Beakjoon;

/**
 *
 * 정렬 재정의 문제
 * 숫자순 우선 정렬 후 가입 순
 *
 */

import java.io.*;
import java.util.*;

public class Baek_10814 {

    static class P {
        int age;
        String name;

        public P(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<P> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new P(age, name));
        }

        list.sort((Comparator.comparingInt(o -> o.age)));

        for (P res : list) {
            System.out.println(res.age + " " + res.name);
        }
    }
}
