import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(학생들의 수 입력 받기)
 * Queue<Integer> q 선언
 * StringTokenizer 선언
 * Deque<Integer> stack 선언
 * for (i =0; i < N; i++) { // 큐 채우기
 *     q.add(st.token)
 * }
 * int check = 1
 *  while (!q.isEmpty) {
 *      if (!stack.isEmpty && stack.peek == check) {
 *          stack.pop()
 *          check++
 *          continue;
 *      }
 *     int person= q.poll()
 *     if (person == check) {
 *         check++
 *     } else {
 *         stack.push(person);
 *     }
 *  }
 *
 * while(!stack.isEmpty) {
 *     if (!stack.isEmpty && stack.peek == check) {
 *          stack.pop()
 *          check++
 *      } else {
 *          break;
 *      }
 *  }
 *  if (check == N + 1) {
 *      "Nice"
 *  } else {
 *      "Sad"
 *  }
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        int check = 1;
        while (!q.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == check) {
                stack.pop();
                check++;
                continue;
            }
            int person = q.poll();

            if(person == check) {
                check++;
            } else {
                stack.push(person);
            }
        }

        while(!stack.isEmpty()) {
            if (stack.peek() == check) {
                stack.pop();
                check++;
            } else {
                break;
            }
        }

        if (check == N + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }

}