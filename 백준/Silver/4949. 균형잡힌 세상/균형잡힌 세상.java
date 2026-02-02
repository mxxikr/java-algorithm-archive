import java.io.*;
import java.util.Stack;

/**
 * ==== 의사 코드 ====
 * StringBuilder sb 선언(정답 담을 변수)
 *
 * while(true) {
 *      String line = 한줄 읽기
 *      if(line.equals("."){
 *          break;
 *      }
 *      stack<Character> 선언 // 새로운 문장 만날 때마다 초기화
 *      check = false; // 새로운 문장 만날 때마다 초기화
 *      for (char c : line.toCharArray(){
 *          if ("(") {
 *              stack.push(c)
 *          } else if ("[") {
 *              stack.push(c)
 *          } else if (")") {
 *              if(stack.isEmpty || stack.peak() != "(") {
 *                  check = true;
 *                  break;
 *                } else {
 *                  stack.pop()
 *                }
 *           } else if ("]") {
 *              if(stack.isEmpty || stack.peak() != "[") {
 *                  check = true;
 *                  break;
 *                } else {
 *                  stack.pop()
 *                }
 *          }
 *      }
 *          if (!check && stack.isEmpty()) { // 한줄 다 앍고나서 판정
 *              sb.append("yes\n")
 *          } else {
 *              sb.append("no\n")
 *          }
 *      }
 *      sb 출력
 *  }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean check = false;

            for (char c : line.toCharArray()) {
                switch (c) {
                    case '(': case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.empty() || stack.peek() != '(') {
                            check = true;
                        } else {
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.empty() || stack.peek() != '[') {
                            check = true;
                        } else {
                            stack.pop();
                        }
                        break;
                }
            }

            if (!check && stack.empty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}