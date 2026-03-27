import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 최솟값 세팅
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int currentEven = Integer.MIN_VALUE;
        int currentOdd = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i % 2 == 0) { // 짝수라면

                if (currentEven != Integer.MIN_VALUE) { // 현재 짝수 - 직전 짝수 = 짝수 거리 후보
                    minEven =  Math.min(minEven, i - currentEven);
                }

                if (currentOdd != Integer.MIN_VALUE) { // 현재 짝수 - 직전 홀수 = 홀수 거리 후보
                    minOdd =  Math.min(minOdd, i - currentOdd);
                }
                currentEven = i;
            } else { // 홀수라면
                if (currentOdd != Integer.MIN_VALUE) { // 현재 홀수 - 직전 홀수 = 짝수 거리 후보
                    minEven =  Math.min(minEven, i - currentOdd);
                }

                if (currentEven != Integer.MIN_VALUE) { // 현재 홀수 - 직전 짝수 = 홀수 거리 후보
                    minOdd =  Math.min(minOdd, i - currentEven);
                }
                currentOdd = i;
            }
        }

        long resultEven = (minEven == Integer.MAX_VALUE) ? -1 : minEven;
        long resultOdd = (minOdd == Integer.MAX_VALUE) ? -1 : minOdd;

        System.out.println(resultEven +  " " + resultOdd);
    }
}