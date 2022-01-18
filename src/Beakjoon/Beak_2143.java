package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2143 {

    static int t, n, m;
    static long[] a, b;
    static List<Long> listA = new ArrayList<>();
    static List<Long> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력 받기
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        
        a = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        b = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 구간 합으로 sub 배열 만들어주기
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                listA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                listB.add(sum);
            }
        }

        // 정렬해주기
        Collections.sort(listA);
        listB.sort(Collections.reverseOrder());

        int left = 0, right = 0;
        long count = 0;

        while (left < listA.size() && right < listB.size()) {
            long sum = listA.get(left) + listB.get(right);

            // sum == t, left += leftCount, right -= rightCount, count ++, 같은 것 만큼 연산
            if (sum == t) {
                long leftCount = 0, rightCount = 0;
                long aIdx = listA.get(left), bIdx = listB.get(right);

                // 같은 숫자가 있다면 같은 결과가 나온다.
                while (left < listA.size() && Objects.equals(listA.get(left), aIdx)) {
                    leftCount ++;
                    left ++;
                }

                while (right < listB.size() && Objects.equals(listB.get(right), bIdx)) {
                    rightCount ++;
                    right ++;
                }

                // 같은 결과가 나온 수만큼 더하기
                count += leftCount * rightCount;
            }

            // sum > t, right ++
            else if (sum > t) {
                right ++;
            }

            // sum < t, left ++
            else {
                left ++;
            }
        }

        System.out.println(count);
    }
}
