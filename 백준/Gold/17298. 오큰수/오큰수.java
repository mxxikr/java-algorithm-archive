import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * N(수열개수) A[](수열 배열) ans[](정답 배열)
 * 수열 배열 채우기
 * 최초 스택 초기화 하기
 *
 * for(N만큼 반복) {
 * 	while(스택이 비어있지 않고, 현재 수열의 값이 top에 해당하는 수열보다 클 때까지) {
 * 		pop()
 * 		정답 배열에 오큰수를 현재 수열로 저장하기
 * 	    }
 * 	현재 수열을 스택에 push()
 * }
 *
 * while(스택이 빌 때까지) {
 * 	스택에 있는 인덱스의 정답 배열에 -1 저장하기
 * }
 * 정답 배열 출력하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputArray = new int[N]; // 수열 배열 생성
        int[] answerArray = new int[N]; // 정답 배열 생성

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 항상 스택이 비어있으므로 최초 값을 Push해 초기화

        for (int i = 1; i < N; i++) {
            // 스택이 비어있지 않고, 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경
            while (!stack.empty() && inputArray[stack.peek()] < inputArray[i]) {
                answerArray[stack.pop()] = inputArray[i]; // 정답 배열에 오큰수를 현재 수열로 저장하기
            }
            stack.push(i); // 신규 데이터 push
        }
        //
        while (!stack.empty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌때까지
            answerArray[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(answerArray[i] + " ");
            // 출력한다
        }

        bw.write("\n");
        bw.flush();
    }
}