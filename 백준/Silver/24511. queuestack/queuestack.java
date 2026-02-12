import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N 자료 구조 개수 입력 받기
 * int[N] A 선언
 * ArrayDeque check 선언
 * for (int i = 0; i < N; i++) {
 *     int queuestack = st.nextToken
 *     A[i] = queuestack
 * }
 *
 * for( int i : A) {
 *     int value = st.nextToken
 *     if (i == 0) {
 *        check.addFirst(value)
 *     }
 * }
 *
 * for (int 0; i < M; i++) {
 *      int C = st.token
 *     check.addLast(C)
 * }
 *
 * StringBuilder sb = new StringBuilder
 *
 * for (int 0; i <M; i++) {
 *      sb.append(check.poll()).append(" ")
 * }
 *
 * sb 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        ArrayDeque<Integer> check = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int queueStack = Integer.parseInt(st.nextToken());
            A[i] = queueStack;
        }

        st = new StringTokenizer(br.readLine());
        for (int a : A) {
            int value = Integer.parseInt(st.nextToken());
            if (a == 0) {
                check.addFirst(value);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int C = Integer.parseInt(st.nextToken());
            check.addLast(C);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(check.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }
}