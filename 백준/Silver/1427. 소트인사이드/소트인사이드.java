import java.io.*;
import java.util.Arrays;

/**
 * ==== 의사 코드 ====
 * str(정렬할 수)
 * A(자릿수 별로 구분해 저장한 배열)
 *
 * for(str 길이만큼 반복하기) {
 *     A 배열 저장 -> s.substring 사용하기
 * }
 *
 * for(i:0~ str의 길이만큼 반복하기) {
 *     for(j: i + 1 ~ str의 길이만큼 반복하기) {
 *         현재 범위에서 Max 값 찾기
 *     }
 *     현재 i의 값과 Max 값 중 Max 값이 더 크면 swap 수행하기
 * }
 * A 배열 출력하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int[] A = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            A[i] = Integer.parseInt(s.substring(i, i + 1));
        }

        for(int i = 0; i < s.length(); i++){ // 이번에 값을 채워 넣을 자리
            int Max = i; // 현재 위치가 가장 크다고 가정하고 시작

            for(int j = i + 1; j < s.length(); j++){ // 오른쪽 나머지 중에 가장 큰 수 찾기
                if(A[j] > A[Max]){ // 만약 j번째 값이 현재까지의 최댓 값 보다 크다면
                    Max = j; // 최댓 값의 위치를 j로 업데이트 함
                }
            }

            // i 번째 값과 오른쪽에서 찾은 진짜 최댓값의 자리를 바꿈
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < s.length(); i++) {
            bufferedWriter.write(String.valueOf(A[i]));
        }

        bufferedWriter.flush();
        bufferedReader.close();
    }
}