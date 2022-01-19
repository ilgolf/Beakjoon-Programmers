package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_11279 {

    static class Heap {
        int[] arr;
        int index;

        public Heap (int size) {
            this.arr = new int[size];
        }

        // 삽입 연산
        public void insert(int val) {
            // 마지막 위치에 노드 삽입
            arr[++index] = val;

            // 추가된 노드와 부모노드 조건 확인
            for (int i = index; i > 1; i/=2) {
                if (arr[i / 2] < arr[i]) {
                    swap(i / 2, i);
                } else {
                    break;
                }
            }
        }

        // poll 연산
        public int poll() {
            if (index == 0) return 0;

            // 루트 노드 삭제 후 마지막 노드 삽입
            int root = arr[1];
            arr[1] = arr[index];
            index --;

            // 힙 조건 확인
            for (int i = 1; i * 2 <= index;) {
                // 양쪽 자식 노드가 더 작다면 탈출
                if (arr[i * 2] < arr[i] && arr[i * 2 + 1] < arr[i]) {
                    break;
                }

                // 오른쪽 자식 노드가 더 크다면 swap 후 밑으로
                else if (arr[i * 2 + 1] > arr[i * 2]) {
                    swap(i * 2 + 1, i);
                    i = i * 2 + 1;
                }

                // 왼쪽 자식 노드가 더 크다면 swap 후 밑으로
                else {
                    swap(i * 2, i);
                    i = i * 2;
                }
            }

            return root;
        }

        // swap 연산
        private void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Heap heap = new Heap(100001);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                System.out.println(heap.poll());
            } else {
                heap.insert(val);
            }
        }
    }
}
