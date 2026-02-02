import java.io.*;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(입력 받기)
 * n (n + 1) /2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = (n * (n + 1)) / 2;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}