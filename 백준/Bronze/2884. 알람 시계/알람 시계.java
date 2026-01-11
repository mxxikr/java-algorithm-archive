import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * 시간 H 입력 받기
 * 분 M 입력 받기
 *
 * if (M이 45보다 크거나 같을 경우) {
 *    M = M - 45
 * } else {
 *      if ( H == 0) {
 *          H = 23
 *      } else {
 *          H = H - 1
 *      }
 *    M = M + 60 -45
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M >= 45) {
            M -= 45;
        } else {
            if (H == 0) {
                H = 23;
            } else {
                H -= 1;
            }
            M = M  + 60 - 45;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(H + " " + M);
        bw.close();
        br.close();
    }
}