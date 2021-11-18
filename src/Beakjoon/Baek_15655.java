package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_15655 {

    static int[] arr, temp;
    static boolean[] checked;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    static void search(int depth, int start) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                sb.append(temp[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!checked[i]) {
                checked[i] = true;
                temp[depth] = arr[i];
                search(depth + 1, i + 1);
                checked[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        checked = new boolean[n];
        temp = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        search(0, 0);
        System.out.println(sb);
    }
}
