package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1002 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append('\n');
            } 
            else if(distance > (int)(Math.pow(r1 + r2, 2))) {
                sb.append(0).append('\n');
            }
            else if(distance < (int)(Math.pow(r2 - r1, 2))) {
                sb.append(0).append('\n');
            }
            else if(distance == (int)(Math.pow(r2 - r1, 2))) {
                sb.append(1).append('\n');
            }
            else if(distance == (int)(Math.pow(r2 + r1, 2))) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }

        System.out.println(sb);
    }
}