import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, maxLen = 0;
        int[] count = new int[11]; // 1 ~ 10번 숫자 개수 세는 변수

        for (int i = end; end < N; end++) {
            count[A[end]]++; // 현재 숫자 체크

            int min = getMin(count); // 최소값 계산
            int max = getMax(count); // 최대값 계산

            while (max - min > 2) { // 차이가 2보다 클 경우
                count[A[start]]--; // 맨 앞 내보내기
                start++; // 시작점 앞으로 당기기

                min = getMin(count); // 최소값 재계산
                max = getMax(count); // 최대값 재계산
            }
            maxLen = Math.max(maxLen, end - start + 1); // 지금 구간 길이와 최고 길이 비교
        }
        System.out.println(maxLen);

    }

    private static int getMin(int[] count) {
        int min = 0;
        for (int i = 1; i <= 10; i++) { // 1번부터 보면서 가장 작은 숫자 확인
            if (count[i] > 0) {
                min =  i;
                break;
            }
        }
        return min;
    }

    private static int getMax(int[] count) {
        int max = 0;
        for (int i = 10; i >= 0; i--) { // 10번부터 보면서 가장 큰 숫자 확인
            if (count[i] > 0) {
                max =  i;
                break;
            }
        }
        return max;
    }

}