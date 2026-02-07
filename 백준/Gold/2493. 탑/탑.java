import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(탐 개수 입력 받기)
 * stack 선언
 * StringBuilder sb 선언
 * class Tower 정의(index, height)
 *
 * 한줄 읽기
 * for ( int i = 0; i < N; i++ {
 *     height = 토큰 가져오기
 *
 *     while(스택이 비어있지않다면) {
 *         if (stack.peek().height) > height) { // 스택의 맨 뒤 높이와 현재 탑의 높이를 비교했을 때 현재 탑이 더 작으면
 *            sb.append(stack.peek().index).append(" ") // 레이저를 받을 수 있으므로 스택의 맨 뒤 탑을 추가
 *            break // 찾았으므로 종료
 *         } else  { // 현재 탑이 더 크면 앞에는 작은 탑이라는 얘기
 *             stack.pop() // 작은 탑 제거
 *
 *         }
 *     }
 *     if (stack.isEmpty) { // 나보다 작은 탑만 있으므로 비어있음
 *         sb.append("0")
 *     }
 *     stack.push(new Tower(i, height))
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        class Tower{
            int index;
            int height;

            public Tower(int index, int height) {
                this.index = index;
                this.height = height;
            }
        }

        Stack<Tower> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().height > height) {
                    sb.append(stack.peek().index).append(' ');
                    break;
                } else {
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                sb.append("0").append(' ');
            }

            stack.push(new Tower(i + 1, height));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}