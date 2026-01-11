import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int result = 0;
        if (x > 0 && y > 0) {
            result = 1;
        } else if (x > 0 && y < 0) {
            result = 4;
        } else if (x < 0 && y > 0) {
            result = 2;
        } else {
            result = 3;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}