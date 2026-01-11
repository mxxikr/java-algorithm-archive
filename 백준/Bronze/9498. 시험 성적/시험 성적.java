import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.parseInt(st.nextToken());

        String result = null;

        if (90 <= N && N <= 100) {
            result = "A";
        } else if (80 <= N && N <= 89) {
            result = "B";
        } else if (70 <= N && N <= 79) {
            result = "C";
        }  else if (60 <= N && N <= 79) {
            result = "D";
        }   else {
            result = "F";
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }
}