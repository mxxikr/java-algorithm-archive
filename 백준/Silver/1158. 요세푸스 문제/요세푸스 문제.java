import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(명령 수 입력 받기)
 * K(제거할 자리 수 입력 받기)
 * Dequeue 선언
 * sb 선언
 *
 * for (i = 1; i <= N; i++) [ // 큐에 숫자 넣기
 *      q.add(i)
 *  }
 *  sb.append("<");
 *  while (!q.isEmpty()) {
 *      for (int i = 0; i < K - 1; i++) {
 *          q.add(q.poll())
 *      }
 *      sb.append(q.poll());
 *
 *      if(!q.isEmpty()) {
 *          sb.append(", ")
 *      }
 *  }
 *  sb.append(">");
 *  sb 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q =  new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");

        while (!q.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll());

            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}