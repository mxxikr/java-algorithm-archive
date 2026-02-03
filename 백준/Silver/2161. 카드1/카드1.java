import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(카드 개수 입력 받기)
 * queue 선언하기
 * sb 선언하기
 * for (i가 1부터 N+1까지) {
 *     queue.add(i) // 큐 채우기
 * }
 *
 * while (큐가 1보다 클때) {
 *     sb.append(q.poll()).append(" ") // 맨 앞 꺼낸걸 sb에 추가
 *     queue.add(q.poll()) // 그다음은 큐 맨 끝에 추가
 * }
 * sb + q 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            sb.append(q.poll()).append(" ");
            q.add(q.poll());
        }

        sb.append(q.poll());
        
        System.out.println(sb);
    }
}