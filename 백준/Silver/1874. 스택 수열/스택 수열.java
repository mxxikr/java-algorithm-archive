import java.io.*;
import java.util.Stack;

/**
 * N(수열의 개수) A[](수열 배열)
 * 수열 배열 채우기
 * for(N만큼 반복)
 * {
 * 	if(현재 수열 값 >= 오름차순 자연수) {
 * 		while(값이 같아질 때까지) {
 * 			push()
 * 			(+)저장
 * 		}
 * 	    pop()
 * 	    (-) 저장
 *  } else(현재 수열 값 <  오름차순 자연수) {
 * 		pop()
 * 		if(스택 pop 결과 값 >  수열의 수) NO 출력
 * 		(-) 저장
 *  }
 * }
 *
 * if(NO 값을 출력한 적이 없으면) 저장한 값 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] =  Integer.parseInt(br.readLine());
        }

        StringBuffer buffer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int number = 1; // 오름차순 수
        boolean result = true;

        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 수열의 수
            if (su >= number) { // 현재 수열의 값 >= 오름차순 자연수: 값이 같아질 때까지 push() 수행
                while (su >= number) { // push()
                    stack.push(number++);
                    buffer.append("+\n");
                }
                stack.pop();
                buffer.append("-\n");
            } else { //현재 수열 값 < 오름차순 자연수: pop()를 수행해 수열 원소를 꺼냄
                int popNumber = stack.pop();
                // 스택의 가장 위의 수가 만들어야하는 수열의 수보다 크면 수열을 출력할 수 없음
                if (popNumber > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    buffer.append("-\n");
                }
            }
        }
        if (result) {
            bw.write(buffer.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}