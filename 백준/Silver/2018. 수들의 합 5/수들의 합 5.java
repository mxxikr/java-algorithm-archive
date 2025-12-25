import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 투 포인터 공싱
 * if sum > N 면 sum = sum - start_index; start_index++; (구간 범위 축소 및 start_index 오른쪽 이동)
 * if sum < N 면 end_index++; sum = sum + end_index; (end_index 오른쪽 이동 및 구간 범위 확장)
 * if sum == N 면 end_index++; sum = sum + end_index; count++; (다음 탐색 위해 end_index 이동 및 결과 카운트 증가)
 *
 * ==== 의사 코드 ====
 * N 변수 저장
 * 사용 변수 초기화 (count = 1, sum = 1, start_index = 1, end_index = 1;)
 *
 * while(end_index != N){
 *     if (sum == N) count 증가, end_index 증가, sum값 변경
 *     else if (sum > N) sum값 변경 start_index 증가
 *     else if (sum < N) end_index 증가, sum값 변경
 * }
 *
 * count 출력하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        int count = 1, sum = 1, start_index = 1, end_index = 1;

        while (end_index != N) {
            if (sum == N) { // 현재 연속 합이 N과 같은 경우
                end_index++;
                sum = sum + end_index;
                count++;
            } else if (sum > N) { // 현재 연속 합이 N보다 큰 경우
                sum = sum - start_index;
                start_index++;
            } else if (sum < N) { // 현재 연속 합이 N보다 작은 경우
                end_index++;
                sum = sum + end_index;
            }

        }

        System.out.println(count);
    }

}