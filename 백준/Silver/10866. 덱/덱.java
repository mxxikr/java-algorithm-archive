import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(명령어 갯수 입력 받기)
 * StringBuilder 선언
 *
 * for (0부터 N까지) {
 *     StringTokenizer 선언
 *     command = 명령어 입력 받기
 *     switch(command) {
 *         case "push_front":
 *              q.addFirst(st 입력받기)
 *              break
 *         case "push_back":
 *              q.addLast(st 입력받기)
 *              break
 *         case "pop_front":
 *              q.isEmpty ? -1 : q.pollFirst() 빼고 sb+"\n" 추가
 *              break
 *         case "pop_back":
 *              q.isEmpty ? -1 : q.pollLast() 빼고 sb+"\n" 추가
 *              break
 *         case "size":
 *              q.size()  sb+"\n" 추가
 *              break
 *         case "empty":
 *              q.isEmpty ? 1 : 0  sb+"\n" 추가
 *              break
 *         case "front":
 *              q.isEmpty ? -1 : q.peekFirst() sb+"\n" 추가
 *              break
 *         case "back":
 *              q.isEmpty ? -1 : q.peekLast() sb+"\n" 추가
 *              break
 *     }
 * }
 * sb 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(q.isEmpty() ? -1 : q.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}