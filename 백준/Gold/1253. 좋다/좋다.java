import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(수의 개수)
 * A(수 데이터 저장 배열)
 * for(N만큼 반복하기) {
 * 	A 배열에 데이터 저장
 * }
 *
 * A 배열 정렬하기
 *
 * for(k를 0부터 N까지 반복) {
 * 	변수 초기화하기(찾고자 하는 값 find, 포인터 i, 포인터 j)
 * 	while(i < j) {
 * 		if(A[i] + A[j] == 찾고자 하는 값)
 * 			두 포인터 i, j가 k가 아닐 때 결괏값에 반영 및 while문 종료하기
 * 			두 포인터 i, j가 k가 맞을 때 포인터 변경 및 계속 수행하기
 * 		else if (A[i] + A[j] < 찾고자 하는 값) 포인터 i 증가
 * 		else 포인터 j 감소
 * 	    }
 * }
 *
 * 좋은 수의 개수 출력하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        int Result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(A);

        for (int K = 0; K < N; K++) {
            int i = 0, j = N - 1;
            long find = A[K];

            while (i < j) {
                if (A[i] + A[j] == find) {
                    if (i != K && j != K) { // find는 서로 다른 두 수의 합이어야함을 체
                        Result++;
                        break;
                    } else if (i == K) {
                        i++;
                    } else if (j == K) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(Result);
    }
}