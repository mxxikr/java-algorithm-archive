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

        long minAbsSum = Long.MAX_VALUE;
        int resultLeft = 0, resultRight = 0, resultfix = 0;

        for (int i = 0; i < N - 2 ; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < minAbsSum) {
                    minAbsSum = Math.abs(sum);
                    resultLeft = left;
                    resultRight = right;
                    resultfix = i;
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else if (sum == 0) {
                    break;
                }

            }
        }
        System.out.println(arr[resultfix] + " "  + arr[resultLeft] + " " + arr[resultRight]);
    }
}