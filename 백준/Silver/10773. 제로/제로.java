import java.io.*;
import java.util.Stack;

/**
 * ==== 의사 코드 ====
 * K(정수 개수 입력 받기)
 * Stack<Integer> 선언하기
 * int count = 0(최종 합 구하는 변수)
 *
 * for (i = 0; i < K; i++){
 *     int n = (숫자 한줄씩 입력 받기)
 *     if ( n == 0 {
 *          count -= stack.pop()
 *     } else {
 *          stack.push()
 *          count += n;
 *     }
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < K; i++) {
            int n =  Integer.parseInt(br.readLine());
            if (n == 0) {
                count -= stack.pop();
            } else {
                stack.push(n);
                count += n;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.close();
    }
}