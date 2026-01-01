import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(숫자의 개수) K(K번째 수)
 * A(숫자 데이터 저장 배열)
 *
 * for(N만큼 반복하기) {
 *     A 배열 저장하기
 * }
 * 퀵 소트 함수 실행하기
 * K 번째 데이터 출력
 *
 * [별도의 함수 구현 부분]
 * 퀵 소트 함수(시작, 종료, K) {
 *     피벗 구하기 함수(시작, 종료)
 *     if (피벗 == K) 종료
 *     else if(K < 피벗) 퀵 소트 수행하기 (시작, 피벗 - 1, K)
 *     else 퀵 소트 수행하기 (피벗 + 1, 종료, K)
 * }
 *
 * 피벗 구하기 함수(시작, 종료) {
 *     데이터가 두개인 경우는 바로 비교하여 정렬
 *     M(중앙 값)
 *     중앙 값을 시작 위치와 swap
 *     pivot(피벗)을 시작 위치 값 A[S]로 저장
 *     i(시작점), j(종료점)
 *     while (i<=j) {
 *         피벗보다 큰 수 나올 때까지 i++
 *         피벗보다 작은 수 나올 때까지 j--
 *         찾은 i와 j를 swqp
 *     }
 *     피벗 데이터를 나눠진 두 그룹 경계 index에 저장하기
 *     경계 index 리턴
 * }
 */
public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = N - 1;

        int result = quickSort(start, end, K - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int quickSort(int start, int end, int K) {
        // 재귀 탈출
        if (start >= end) return A[start];

        int pivotIndex = findPivot(start, end);

        if (pivotIndex == K) {
            return A[pivotIndex];
        } else if (pivotIndex > K) {
            return quickSort(start, pivotIndex - 1, K);
        } else {
            return quickSort(pivotIndex + 1, end, K);
        }
    }

    private static int findPivot(int start, int end) {
        int mid = (start + end) / 2;

        swap(start, mid); // 중앙 값과 맨 앞 값 변경

        int piovt = A[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= j && piovt > A[i]) {
                i++;
            }
            while (j >= i && piovt < A[j]) {
                j--;
            }
            if (i <= j) {
                swap(i++, j--); // 다음 탐색을 위해 이동
            }
        }
        swap(start, j);
        return j;
    }

    private static void swap(int i, int j) {
        int temp = A[i]; // 중앙 값과 맨 앞 값 변경
        A[i] = A[j];
        A[j] = temp;
    }

}