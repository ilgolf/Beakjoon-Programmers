package Programmers;

import java.util.Arrays;

public class FileSort {

    static int isNumber(String str, String head) {
        String temp = "";

        for (int i = head.length(); i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch) && temp.length() < 5) {
                temp += ch;
            } else {
                break;
            }
        }

        return Integer.parseInt(temp);
    }

    public static String[] solution(String[] files) {

        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();

            int num1 = isNumber(o1, head1);
            int num2 = isNumber(o2, head2);

            if (head1.compareTo(head2) == 0) { return num1 - num2; }

            return head1.compareTo(head2);
        });

        return files;
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(Arrays.toString(solution(files)));
    }
}
