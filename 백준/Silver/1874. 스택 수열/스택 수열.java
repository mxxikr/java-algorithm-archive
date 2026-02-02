import java.io.*;
import java.util.Stack;

/**
 * ==== 의사 코드 ====
 * N(수열 개수 입력 받기)
 * stack<Integer> 선언
 * StringBuilder sb 선언
 * int count = 1
 *
 * for (int i = 0; i < N; i++) {
 *      int target = 입력 받기
 *      while (count <= target) {
 *          stack.push(count);
 *          sb.append("+\n")
 *          count++;
 *      }
 *      if( stack.peek() == target) {
 *          stack.pop()
 *          sb.append("-\n")
 *      } else {
 *          System.out.print("NO")
 *          return;
 *      }
 * }
 * System.out.prinln(sb)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            while (count <= target) {
                stack.push(count);
                sb.append("+\n");
                count++;
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}