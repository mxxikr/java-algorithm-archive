import java.io.*;
import java.util.Arrays;

/**
 * 정렬 전 인덱스에서 정렬 후 인덱스를 빼면 버블 정렬의 횟수가 나옴
 *
 * ==== 의사 코드 ====
 * N(데이터 개수) A(데이터 배열, 단 클래스를 데이터로 담는 배열)
 * for (N만큼 반복하기) {
 *     A 배열 저장하기
 * }
 * A 배열 정렬하기
 * for (N만큼 반복하기) {
 *     A[i]의 정렬전 index - 정렬 후 index 계산의 최댓값을 찾아 저장하기
 * }
 * 최댓 값 + 1을 정답으로 출력하기
 *
 * 별도 클래스 선언하기
 * mData(데이터 표현) {
 *     index, value를 가지며
 *     value 기준 오름차순 정렬 함수 Comparable 구현하기
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(bufferedReader.readLine()), i);
        }
        Arrays.sort(A); // A 배열 정렬
        int Max = 0;
        for (int i = 0; i < N; i++) {
            if (Max < A[i].index - i) { // 정렬 전 index - 정렬 후 index 계산의 최댓 값 저장하기
                Max = A[i].index - i;
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(Max + 1));

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    static class mData implements Comparable<mData> {
        int index;
        int value;

        public mData(int value, int index) {
            super();
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(mData o) {
            return this.value - o.value;  // value 기준 오름차순 정렬하기
        }
    }
}