import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0; // 몸에 남은 알코올 양
        int count = 0; // 유지한 시간

        for (int i = 0; i < N; i++) {
            sum += arr[i]; // 알코올 섭취

            if (i >= L) { // 알코올 섭취 횟수가 일정 시간보다 커지면
                sum -= arr[i - L]; // 오래된 알코올 제거
            }

            if (sum >= 129 && sum <= 138) { // 혈중 알코올 농도 체크
                count++;
            }
        }

        System.out.println(count);
    }
}