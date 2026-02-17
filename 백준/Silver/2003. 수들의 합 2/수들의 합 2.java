import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] check = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= M) { // 합이 M보다 크거나 같으면 시작인덱스를 오른쪽으로 이동해야함
                sum -= check[start]; // 인덱스가 이동하니 빼야함
                start++; // 인덱스 증가
            } else if (end == N) { // 합이 부족한데 종료 인덱스가 N이면 끝
                break;
            } else if (sum < M) { // 합이 부족하면 종료 인덱스를 오른쪽으로 이동
                sum += check[end]; // 오른쪽 인덱스가 추가되니 더해야함
                end++; // 인덱스 증가
            }

            if (sum == M) { // 합이 같으면
                count++;
            }
        }

        System.out.println(count);
    }
}