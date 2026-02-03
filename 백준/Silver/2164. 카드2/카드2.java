import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(명령 수 입력 받기)
 * Deque 선언하기
 * for (i = 1; i <= N; i++) {
 *     q.add(i)
 * }
 *
 * while (q.size() > 1) {
 *     q.poll()
 *     q.add(q.poll())
 * }
 *
 * q.peek() 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Deque<Integer> q =  new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.peek());

    }
}