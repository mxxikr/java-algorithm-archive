import java.io.*;
import java.util.Stack;

/**
 * ==== 의사 코드 ====
 * N(입력 개수 입력 받기)
 * StringBulder 선언
 * for (int i = 0; i < N; i++) {
 *     String line = 한줄 읽기
 *     Stack<Character> stack 선언
 *     boolean check = false;
 *     for (Line을 한글자씩 확인){
 *        if ("("면) {
 *            stack.push("(")
 *        } else if (")"라면) {
 *           if (stack.isEmpty() {
 *               check = true;
 *               break;
 *            } else {
 *               stack.pop(); // 짝꿍 빼기
 *            }
 *        }
 *     }
 *     if (isError가 true거나 stack이 비어있지않다면) {
 *        sb.append("NO\n")
 *     } else {
 *        sb.append("YES\m")
 *     }
 *  }
 *   StringBuilder 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = false;

            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        check = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (check == true || !stack.isEmpty()) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }
}