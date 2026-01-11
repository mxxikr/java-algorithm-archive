import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * 시간 A 입력 받기
 * 분 B 입력 받기
 * 요리 시간 M 받기
 *
 * totalTime = (A * 60) + B + M
 *
 * A += (totalTime / 60) % 24
 * B += (totalTime % 60)
 *
 * A + " " + B 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        int totalTime = (A * 60) + B + M;

        A = (totalTime / 60) % 24;
        B = (totalTime % 60);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(A + " " + B);

        bw.flush();
        bw.close();
        br.close();
    }
}