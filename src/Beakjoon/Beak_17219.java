package Beakjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> site = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            site.put(st.nextToken(), st.nextToken()); // 사이트, 비밀번호
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m - 1; i++) {
            result.append(site.get(br.readLine())).append('\n');
        }

        result.append(site.get(br.readLine()));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
