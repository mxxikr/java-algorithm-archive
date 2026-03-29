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

        int left = 0;
        int right = N - 1;
        int minAbsSum = Integer.MAX_VALUE;

        int resultLeft = 0, resultRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minAbsSum) {
                minAbsSum = Math.abs(sum);
                resultLeft = left;
                resultRight = right;
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else if (sum == 0) {
                break;
            }
        }
        System.out.println(arr[resultLeft] + " " + arr[resultRight]);
    }
}