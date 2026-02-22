import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line =  br.readLine();
        int countA = 0;
        for (char c:  line.toCharArray()) { // a 개수 먼저 세기
            if (c == 'a') {
                countA++;
            }
        }

        int n = line.length();
        int min = Integer.MAX_VALUE; // 최솟값

        String doubled = line + line; // 원형 처리

        for (int i = 0; i < line.length(); i++) { // 시작점부터 끝까지 돌기
            int countB = 0;
            for (int j = i; j < i + countA; j++) {
                if (doubled.charAt(j) == 'b') {
                    countB++;
                }
            }
            min = Math.min(min, countB);
        }

        System.out.println(min);
    }
}