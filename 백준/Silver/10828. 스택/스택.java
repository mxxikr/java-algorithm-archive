import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(명령어 개수 입력 받기)
 * 스택 선언
 * Stringbuilder 선언 (정답 추가)
 * for (i = 0; i < N; i++){
 *     M(StringTokenizer로 명령어 입력 받기)
 *     case (명령어가 push라면):
 *         st에서 토큰 꺼내와서 stack 에 넣기
 *     case (명령어가 pop이라면):
*          if ( stack이 비어있다면 ) {
 *              -1 추가
 *         } else {
*              stack.pop 추가
 *         }
 *     case (명령어가 size라면):
 *         stack.size() 추가
 *     case (명령어가 empty라면):
 *         if ( stack이 비어있다면 ) {
 *            1 추가
 *         } else {
 *           0 추가
 *         }
 *     case (명령어가 top 이라면):
 *         if ( stack이 비어있다면 ) {
 *           -1 추가
 *         } else {
 *          stack.peek() 추가
 *         }
*       }
 *
 *      Stringbuilder 출력
 * }
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}