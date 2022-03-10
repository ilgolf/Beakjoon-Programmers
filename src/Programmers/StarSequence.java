package Programmers;

public class StarSequence {

    public int solution(int[] a) {
        int answer = -1;

        int[] count = new int[a.length + 1];

        for (int val : a) { count[val] ++; }

        for (int i = 0; i < count.length; i++) {
            if (count[i] * 2 <= answer) continue;
            int star = 0;

            for (int j = 0; j < a.length - 1; j++) {
                if ((a[j] == i || a[j + 1] == i) && (a[j] != a[j + 1])) {
                    star += 2;
                    j ++;
                }
            }

            answer = Math.max(answer, star);
        }

        return answer;
    }
}
