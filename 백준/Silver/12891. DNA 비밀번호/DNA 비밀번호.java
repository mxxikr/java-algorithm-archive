import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * 초기화 단계
 * 0부터 P-1까지의 문자열을 먼저 훑으면서 초기 상태를 만듬
 * 이 상태에서 이미 조건이 맞는지 확인하고 결과 값에 반영함
 *
 * 슬라이딩 단계
 * 한 칸 이동할 때마다 Add 함수로 오른쪽 문자를 더함
 * Remove 함수로 왼쪽 문자를 뻼
 *
 * 매 이동마다 checkSecret == 4인지 검사하여 정답을 카운트한다
 * ==== 의사 코드 ====
 * S(문자열 크기) P(부분 문자열의 크기)
 * A(문자열 데이터)
 * checkArr(비밀번호 체크 배열)
 * myArr(현재 상태 배열)
 *
 * checkSecert(몇 개의 문자와 관련 된 개수를 충족했는지 판단하는 변수)
 * P 범위(0~P-1)만큼 S 배열에 적용하고, 유효한 비밀 번호인지 판단하기
 * for(i를 P에서 S까지 반복) {
 * 	j 선언(i - P)
 * 	// 이 부분은 함수로 별도 구현
 * 	한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기 유효한 비밀번호인지(checkSecret == 4) 판단해 결괏 값에 업데이트 하기
 * }
 * 결괏 값 출력하기
 *
 * 별도 함수
 * Add(문자, 더하기 함수)
 * {
 * 	새로 들어온 문자를 myArr에 업데이트 하거나 checkSecret 값 변경하기
 * }
 *
 * Remove(문자 빼기 함수)
 * {
 * 	제거 되는 문자를 myArr에 업데이트 하거나 checkSecret 값 변경하기
 * }
 */
public class Main {
    static int checkArr[];
    static int myArr[];
    static int checkSecert;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 문자열 크기
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 크기
        int Result = 0;
        char[] A = new char[S]; // 문자열 데이터
        checkArr = new int[4]; // 비밀 번호 체크 배열
        myArr = new int[4]; // 현재 상태 배열

        checkSecert = 0;
        A =  br.readLine().toCharArray();
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st2.nextToken());
            if(checkArr[i] == 0) {
                checkSecert++; // 이미 충족했으므로
            }
        }

        for (int i = 0; i < P; i++) { // 초기 P 부분 문자열 처리 부분
            Add(A[i]);
        }

        if (checkSecert == 4) { // 충족 됐으면 더 계산하지 않음
            Result++;
        }

        // 슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecert == 4) { // 4자리 수와 관련된 크기가 모두 충족할 때 유효한 비밀 번호
                Result++;
            }
        }

        System.out.println(Result);
        br.close();
    }

    // 새로 들어온 문자열 처리하는 함수
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecert++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecert++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecert++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecert++;
                }
                break;

        }
    }

    // 제거 되는 문자열 처리하는 함수
    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecert--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecert--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecert--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecert--;
                }
                myArr[3]--;
                break;

        }
    }
}