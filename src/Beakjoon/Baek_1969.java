package Beakjoon;

/**
 * 
 * 전형적인 완전 탐색 예상 복잡도 : O(N^2 + @)
 * 
 */

import java.io.*;
import java.util.*;

public class Baek_1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] dna = new String[n];
        int hd = 0;

        for(int i=0; i<n; i++) {
            dna[i] = br.readLine();
        }

        StringBuffer buffer = new StringBuffer();

        for(int i=0; i<m; i++) {
            int[] cnt = new int[4];

            for(int j=0; j<n; j++) {
                char ch = dna[j].charAt(i);

                switch(ch) {
                    case 'A' :
                        cnt[0] ++;
                        break;
                    case 'C' :
                        cnt[1] ++;
                        break;
                    case 'G' :
                        cnt[2] ++;
                        break;
                    case 'T' :
                        cnt[3] ++;
                        break;
                }
            }

            int idx = 0;
            int max = 0;
            for(int k=0; k<4; k++) {
                if(cnt[k] > max || (cnt[k] == max && k < idx)) {
                    max = cnt[k];
                    idx = k;
                }
            }

            switch (idx) {
                case 0 :
                    buffer.append('A');
                    break;
                case 1 :
                    buffer.append('C');
                    break;
                case 2 :
                    buffer.append('G');
                    break;
                case 3 : 
                    buffer.append('T');
                    break;
            }
            hd += n - max;
        }

        System.out.println(buffer.toString());
        System.out.println(hd);
    }
}