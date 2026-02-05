import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(수열 크기 입력받기)
 * A[N] (숫자 넣을 배열 선언)
 * ans[N] (정답 배열 선언)
 *
 * for (i = 0; i < N; i++){
 *      A[i] = st.token();
 * }
 *
 * for (i = 0; i < N; i++){
 *      ans[i] = -1 // 정답 배열 초기화
 * }
 *
 * stack<Integer> 선언
 *
 * for (i = 0; i < N; i++){
 *      while (!stack.isEmpty) && A[stack.peek()] < A[i]{ // 스택이 비어 있지 않고 스택의 값보다 배열의 값이 더 클 경우
 *          int index = stack.pop();
 *
 *          ans[index] = A[i] // 정답 배열에 현재 배열의 값을 추가
 *      } // 스택이 비어있거나 스택의 값보다 배열의 값이 작은 경우
 *      stack.push(i); // 스택에 현재 배열의 인덱스 push
 * }
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int index = stack.pop();
                ans[index] = A[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}