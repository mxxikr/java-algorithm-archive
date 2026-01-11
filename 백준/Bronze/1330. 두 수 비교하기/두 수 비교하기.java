import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A =  Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        String result;

        if (A > B) {
            result = ">";
        } else if (A < B) {
            result = "<";
        } else {
            result = "==";
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }
}