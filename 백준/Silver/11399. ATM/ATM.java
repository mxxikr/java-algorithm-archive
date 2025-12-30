import java.io.*;
import java.util.StringTokenizer;

/**
 * 삽입 정렬 과정
 * 1. 현재 index 에 있는 데이터 값을 선택함
 * 2. 현재 선택한 데이터가 정렬 된 데이터 범위에 삽일 될 위치를 탐색
 * 3. 삽입 위치부터 index에 있는 위치까지 shift 연산 수행
 * 4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행함
 * 5. 전체 데이터의 크기만큼 index가 커질 때 까지, 즉 선택할 데이터가 없을 때까지 반복함
 *
 * 합 배열 공식
 * S[i] = S[i-1] + A[i]
 *
 * ==== 의사 코드 ====
 * N(사람 수)
 * A(자릿 수 별로 구분해 저장한 배열
 * S(A 합 배열: 각 사람이 인출을 완료하는데 필요한 시간을 저장하기
 *
 * for(N만큼 반복하기){
 *     A 배열 저장하기
 * }
 *
 * for(i: N만큼 반복하기){
 *     for(j: i - 1 ~ 0까지 뒤에서부터 반복하기) {
 *         현재 범위에서 삽입 위치 찾기
 *     }
 *
 *     for(j: i ~ insert_point + 1까지 뒤에서부터 반복하기) {
 *         삽입을 위해 삽입 위치에서 i까지 데이터를 한칸 씩 뒤로 밀기
 *     }
 *     삽입 위치에 현재 데이터 삽입하기
 *
 *     for(i:N만큼 반복하기) {
 *         A배열을 통한 합 배열 S 만들기
 *     }
 *
 *     S 배열의 각 데이터 값을 모두 합해 결과 출력하기
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] S = new int[N];

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = A[i]; // 현재 값
            for(int j = i - 1; j >= 0; j--){ // 앞(왼쪽)에 있는 값들을 뒤에서부터 훑어봄
                if(A[j] < A[i]){ // 현재 값보다 작은 수를 만났다면
                    insert_point = j + 1; // 작은 수 뒷자리에 추가해야함
                    break;
                }
                if (j == 0) { // 현재 값보다 작은 수가 없다면
                    insert_point = 0; // 맨 앞에 추가해야함
                }
            }

            // 현재 위치부터 시작해 들어갈 위치 전까지
            for(int j = i; j > insert_point; j--){
                A[j] = A[j - 1]; // 빈자리에 추가
            }
            A[insert_point] = insert_value;
        }

        // 합 배열 만들기
        S[0] = A[0]; // 첫번 째 사람은 자기 인출 시간만큼만 기다림

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i]; // 뒷사람 대기 시간 = 앞사람 대기 시간 + 내 인출 시간
        }

        int sum = 0; // 합 배열 총합 구하기
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(sum));

        bufferedWriter.flush();
        bufferedReader.close();
    }
}