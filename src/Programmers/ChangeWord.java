package Programmers;

public class ChangeWord {

    static int answer;
    static boolean[] checked;

    static void dfs(int count, String target, String present, String[] words) {
        if (present.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!checked[i] && check(target, words[i])) {
                checked[i] = true;
                dfs(count + 1, target, words[i], words);
                checked[i] = false;
            }
        }
    }

    static boolean check(String presentWord, String nextWord) {
        int count = 0;

        for (int i = 0; i < presentWord.length(); i++) {
            if (presentWord.charAt(i) != nextWord.charAt(i)) {
                count ++;
            }
        }

        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {
        answer = 51;

        checked = new boolean[words.length];
        dfs(0, target, begin, words);
        return answer == 51 ? 0 : answer;
    }
}
