import java.io.*;

/**
 * ==== 의사 코드 ====
 * N(정렬할 수 개수)
 * A(정렬할 배열 선언하기)
 * tmp(정렬할 때 잠시 사용할 임시 배열 선언하기)
 *
 * for (N의 개수만큼)
 * {
 *     A 배열에 데이터 저장하기
 * }
 * 병합 정렬 함수 수행하기
 * 결괏 값 출력하기
 *
 * // 병합 정렬 수행하기
 * 병합 정렬(s, e) {
 *     s(시작점), e(종료점), m(중간점)
 *     // 재귀 함수 형태로 구현하기
 *      병합 정렬(s, m)
 *      병합 정렬(m + 1, e)
 *      for (s ~ e) {
 *          tmp 배열 저장하기
 *      }
 *
 *      // 두 그룹을 병합하는 로직
 *      index1 -> 앞쪽 그룹 시작점
 *      index2 -> 뒤쪽 그룹 시작점
 *      while(index1 <= 중간점 && index2 <= 종료점)
 *          양쪽 그룹의 index의 가리키는 값을 비교한 후 더 작은 수를 선택해 배열에 저장하고,
 *          선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
 *          반복문이 끝난 후 남아있는 데이터 정리하기
 * }
 */
public class Main {
    static int[] A;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(A[i]));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        // 재귀 함수 탈출 조건 : 시작점이 종료점보다 크거나 같으면 종료
        if (s >= e) return;

        // 중간점 m 계산
        int m = (s + e) / 2;

        mergeSort(s, m); // 왼쪽
        mergeSort(m + 1, e); // 오른쪽

        // 합치기
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        // 포인터 변수 설정
        int k = s; // 원본 배열 A에 값을 채워 넣을 현재 위치
        int index1 = s; // 앞쪽 그룹 시작점
        int index2 = m + 1; // 뒤쪽 그룹 시작점

        while(index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
