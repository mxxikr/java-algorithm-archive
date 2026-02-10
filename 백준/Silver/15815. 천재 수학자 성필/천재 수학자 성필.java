import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * String line 입력 받기
 * Deque<Integer> stack 선언
 *
 * for (i= 0; i < line.length(); i++) {
 *      char c = line.charAt(i);
 *      if (c >= '0' && c <= '9') { // 숫자일 경우
 *          stack.push(c - '0') // 스택에 넣음
 *      } else { // 문자
 *          fist = stack.pop()
 *          second = stack.pop()
 *          case "+"
 *              stack.push(second + first)
 *          case "-"
 *              stack.push(second - first)
 *          case "*"
 *              stack.push(second * first)
 *           case "/"
 *              stack.push(second / first)
 *
 *      }
 * }
 * sout(stack.pop())
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < line.length(); i++) {
            char c =  line.charAt(i);
            if (c >= '0' && c <= '9') { 
                stack.push(c - '0');
            } else {
                int first = stack.pop();
                int second = stack.pop();
                switch(c) {
                    case '+':
                        stack.push(second + first);
                        break;
                    case '-':
                        stack.push(second - first);
                        break;
                    case '*':
                        stack.push(second * first);
                        break;
                    case  '/':
                        stack.push(second / first);
                        break;
                        
                }
            }
        }
        System.out.println(stack.pop());

    }

}