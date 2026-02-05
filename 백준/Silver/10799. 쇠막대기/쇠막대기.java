import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * line = 문자열 입력받음
 * stack 선언
 * count 선언
 *
 * for (int i = 0; i < line.length(); i++) { // 한글자씩 꺼냄
 *         if (line.charAt(i) == "(")
 *              stack.push(line.charAt(i)) // 그냥 넣기(막대기)
 *         else if (line.charAt(i) == ")")
 *              stack.pop()
 *              if (line.charAt(i-1) == "(") { // 앞이 ( 면 레이저
 *                   count+= stack.size()
 *              } else { // 앞이 )면 막대
 *                   count += 1
 *              }
 *     }
 * }
 * count 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push("(");
            } else if (line.charAt(i) == ')') {
                stack.pop();
                if (line.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}