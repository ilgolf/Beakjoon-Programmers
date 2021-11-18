package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * 소수 구하기 : 에라토스테네스의 체 문제
 * 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다. 그림에서 회색 사각형으로 두른 수들이 여기에 해당한다.
 * 2는 소수이므로 오른쪽에 2를 쓴다.
 * 자기 자신을 제외한 2의 배수를 모두 지운다.
 * 남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
 * 자기 자신을 제외한 3의 배수를 모두 지운다.
 * 남아있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
 * 자기 자신을 제외한 5의 배수를 모두 지운다.
 * 남아있는 수 가운데 7은 소수이므로 오른쪽에 7을 쓴다.
 * 자기 자신을 제외한 7의 배수를 모두 지운다.
 * 위의 과정을 반복하면 구하는 구간의 모든 소수가 남는다.
 *
 */

public class Baek_1929 {

    static boolean[] checked;

    static void getPrime() {
        checked[0] = checked[1] = true;

        for(int i = 2; i <= Math.sqrt(checked.length); i++) {
            if(checked[i]) continue;
            for(int j = i * i; j < checked.length; j += i) {
                checked[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        checked = new boolean[n + 1];
        getPrime();

        StringBuilder sb = new StringBuilder();

        for (int i = m; i <= n; i++) {
            if(!checked[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
