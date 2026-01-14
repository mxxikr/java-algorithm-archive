import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result = 0;

        if (A == B && B == C && A == C) {
            result = 10000 + A  * 1000;
        } else if (A == B || B == C) {
            result = 1000 + B * 100;
        } else if (A == C) {
            result = 1000 + C * 100;
        } else {
            result = Math.max(A, Math.max(B, C)) * 100;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}