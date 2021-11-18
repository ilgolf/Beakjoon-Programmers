package Beakjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_1991 {

    static class BinaryTree {
        char right, left;

        public BinaryTree(char right, char left) {
            this.right = right;
            this.left = left;
        }
    }

    static int n;
    static Map<Character, BinaryTree> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void preOrder(char start) {
        if (start == '.') {
            return;
        }

        sb.append(start);
        preOrder(tree.get(start).left);
        preOrder(tree.get(start).right);
    }

    static void inOrder(char start) {
        if (start == '.') {
            return;
        }

        inOrder(tree.get(start).left);
        sb.append(start);
        inOrder(tree.get(start).right);
    }

    static void postOrder(char start) {
        if (start == '.') {
            return;
        }

        postOrder(tree.get(start).left);
        postOrder(tree.get(start).right);
        sb.append(start);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // input : root, left, right
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(root, new BinaryTree(right, left)); // 'A' 부터 시작
        }

        preOrder('A');
        sb.append('\n');
        inOrder('A');
        sb.append('\n');
        postOrder('A');

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
