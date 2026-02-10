import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * S(문자열 입력 받기)
 * inTag = false 선언
 * stack 선언
 * StringBuilder 선언
 *
 * for (char c : S.toCharArray) {
 *      if (c == '<') { // 태그가 시작된 시점
 *          while(!stack.isEmpty) {
 *              sb.append(stack.pop()) // 쌓인 단어 뒤집기
 *          }
 *
 *          inTag = true; // 태그 처리
 *          sb.append(c) // 태그 추가
 *      } else if (c == '>') { // 태그 끝나는 시점
 *          inTag = false; // 태그 끝 처리
 *          sb.append(c) // 태그 추가
 *      } else { // 내용물 처리
 *          if (inTag) { //
 *              sb.append(c)
 *          } else {
 *              if (c == ' ' ) {
 *                  while(!stack.isEmpty) {
 *                  sb.append(stack.pop())
 *                  }
 *                  sb.append(c)
 *              } else {
 *                  stack.push(c)
 *              }
 *          }
 *      }
 * }
 *
 * // 스택 안에 남아있는 마지막 코드 꺼내기
 * while (!stack.isEmpty) {
 *     sb.append(stack.pop));
 * }
 *
 * sb 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        boolean inTag = false;
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c: line.toCharArray()) {
            if (c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else {
                if (inTag) {
                    sb.append(c);
                } else {
                    if (c == ' ') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

}