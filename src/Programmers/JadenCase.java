package Programmers;

public class JadenCase {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        s = s.toLowerCase();

        String[] str = s.split(" ");

        if (s.charAt(s.length() - 1) == ' ') {
            str[str.length - 1] += " ";
        }

        for (int i = 0; i < str.length - 1; i++) {
            answer.append(convert(str[i])).append(" ");
        }

        if (!str[str.length - 1].equals(" ")) {
            answer.append(convert(str[str.length - 1]));
        }

        return answer.toString();
    }

    private String convert(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && Character.isLetter(s.charAt(0))) {
                result.append(Character.toUpperCase(s.charAt(0)));
            }
            else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
