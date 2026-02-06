import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(단어 수 입력 받기)
 * count 좋은 단어 카운트 변수 선언
 *
 * for (int i = 0; i < N; i++) {
 *     // word = 단어 한줄 읽기
 *     // stack 선언하기
 *     for ( char c : word.toCharArray) {
 *          if (stack.isEmpty || stack.peek() != c) {
 *              stack.push(c)
 *          } else {
 *              stack.pop()
 *          }
 *     }
 *     // 스택이 비어있다면 좋은단어 카운트 증가
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c );
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}