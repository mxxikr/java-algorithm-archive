import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(명령 수 입력 받기)
 * Deque 선언하기
 * sb 선언하기
 *
 * for (i = 0; i < N; i++){
 *     String command = StringTokenizer로 입력받기
 *     switch(command) {
 *         case "push":
 *              큐.add(st.token);
 *              break;
 *         case "pop":
 *              sb.append(큐.isEmpty ? -1 : 큐.poll()).append("\n);
 *              break;
 *         case "size":
 *              sb.append(큐.size).append("\n)
 *              break;
*          case "empty":
 *              sb.append(큐.isEmpty ? 1 : 0).append("\n)
 *              break;
 *         case "front":
 *              sb.append(큐.isEmpty ? -1 : 큐.peek()).append("\n)
 *              break;
 *         case "back":
 *              sb.append(큐.isEmpty ? -1 : 큐.peekLast()).append("\n)
 *              break;
 *     }
 * }
 *
 * sb 출력하기
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    q.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                    break;

                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}