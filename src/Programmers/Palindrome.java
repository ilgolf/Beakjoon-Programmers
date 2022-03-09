package Programmers;

public class Palindrome {

    public int solution(String s) {
        int answer = 0;

        char[] charArr = s.toCharArray();

        // 길이 하나 씩 탐색
        for (int length = charArr.length; length > 1; length--) {

            // 시작점
            for (int start = 0; start + length <= s.length(); start++) {
                boolean check = true;

                // 펠린드롬 유무 검사
                for (int i = 0; i < length / 2; i++) {
                    if (charArr[start + i] != charArr[start + length - i - 1]) {
                        check = false;
                        break;
                    }
                }

                if (check) return length;
            }
        }

        return answer;
    }
}
