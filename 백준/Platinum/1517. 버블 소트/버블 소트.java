import java.io.*;
import java.util.StringTokenizer;

/**
 * N(정렬할 수 개수)
 * A(정렬할 배열 선언하기)
 * tmp(정렬할 때 잠시 사용할 임시 배열 패턴 선언하기)
 * for(N의 개수만큼) {
 *     A 배열 선언하기
 * }
 *
 * 병합 정렬 함수 수행하기
 * 결괏 값 출력하기
 *
 * // 병합 정렬 수행하기
 * 병합 정렬(s, e) {
 *     s(시작점), e(종료점), m(중간점)
 *     // 재귀함수 형태로 구현하기
 *     병합 정렬(s, m)
 *     병합 정렬(m + 1, e)
 *     for (s ~ e) {
 *         tmp 배열 저장하기
 *     }
 *
 *     // 두 그룹을 병합하는 로직
 *     index1 -> 앞쪽 그룹 시작점
 *     index2 -> 뒤쪽 그룹 시작점
 *     while(index1 <= 중간점 && index2 <= 종료점) {
 *         뒤쪽 데이터 값이 더 작아 선택될 때
 *         swap이 일어났다고 가정하고,
 *         현재 남아있는 앞쪽 데이터 개수만큼 결괏 값을 더함
 *     }
 *     반복문의 끝난 후 남아 있는 데이터 정리하기
 * }
 */
public class Main {
    static int[] A, tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e){
        if (s >= e) return; // 재귀함수 종료 조건

        int m = (s + e) / 2;

        mergeSort(s, m);
        mergeSort(m + 1, e);

        for(int i = s; i <= e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while(index1 <= m && index2 <= e){
            if(tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                result = result + index2 - k; // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
