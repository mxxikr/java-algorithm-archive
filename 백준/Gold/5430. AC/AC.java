import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * T(테스트 케이스 개수 입력 받기)

 * while (T-- > 0) {
 *      String function(함수 입력 받기)
 *      int n (배열 개수 입력받기)
 *      덱 선언하기
 *
 *      String inputString = (배열 문자열 입력 받기)
 *      if (n > 0) { // 입력 받은 문자열 파싱해서 덱 저장
 *          String s = inputString.subString(1, inputString.length() -1);
 *          StringTokenizer st =  new StringTokenizer(s, ",");
 *          while (st.hasMoreToken()) {
 *              q.add(st.token())
 *          }
 *      }
 *
 *      boolean isForward = true; // 방향 상태 체크
 *      boolean isError = false; // 에러 발생 여부
 *
 *      for (int i = 0; i < function.length(); i++) {
 *
 *          if (function.charAt(i) == "R") {
 *              isForward = !isForward;
 *          } else if (function.charAt(i) == "D") {
 *              if (q.isEmpty) {
 *                  isError = true;
 *                  break;
 *              } else if (isForward) {
 *                  q.popFirst();
 *              } else if (!isForward) {
 *                  q.popLast();
 *              }
 *          }
 *      }
 *      if (!isError) {
 *          StringBuilder sb = new StringBuilder("[";
 *
 *          while (!q.isEmpty) { // 큐가 비어있지않다면
 *                  //방향에 맞춰 숫자를 꺼냄
 *                  String num = isForward ? q.pollFirst() : q.pollLast(); // 방향 맞춰서 꺼내야함
 *                  sb.append(num)
 *
 *                   if (!q.isEmpty) { // 마지막 숫자가 아니라면 붙임
 *                         sb.append(", ")
 *                  }
 *              }
 *          sb.append("]")
 *          sout(sb);
 *
 *      } else {
 *          sout("error")
 *      }
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String func =  br.readLine();
            int n =  Integer.parseInt(br.readLine());
            String inputString = br.readLine();

            Deque<Integer> q =  new ArrayDeque<>();

            if (n > 0) {
                String s = inputString.substring(1, inputString.length() - 1);
                StringTokenizer st = new StringTokenizer(s, ",");

                while (st.hasMoreTokens()) {
                    q.add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean isForward = true;
            boolean isError = false;

            for (int i = 0; i < func.length(); i++) {

                if (func.charAt(i) == 'R') {
                    isForward = !isForward;;
                } else if (func.charAt(i) == 'D') {
                    if (q.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isForward) {
                        q.pollFirst();
                    } else if (!isForward) {
                        q.pollLast();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");

                while (!q.isEmpty()) {
                    int num = isForward ? q.pollFirst() : q.pollLast();
                    sb.append(num);

                    if (!q.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}