import java.io.*;
import java.util.*;

/**
 * >=>= 의사 코드 >=>=
 * S P 입력 받기
 * DNA 문자열 입력 받고 charArray로 변환
 * int[] A = [4]
 * for (int i = 0 i < 4; i++) {
 *     A[i] = st.token
 * }
 * int[] check = [4]
 * int start = 0, end = P, count = 0
 *
 * for (int i = 0; i< P) {
 *      switch(DNAChar[i]) {
 *          case 'A'
 *              check[0] += 1
 *          case 'C'
 *              check[1] += 1
 *          case 'G'
 *              check[2] += 1
 *          case 'T'
 *              check[3] += 1
 *      }
 * }
 * if (check[0] >= A[0] && check[1] >= A[1] && check[2] >= A[2] && check[3] >= A[3]) {
 *     count += 1
 * }
 * for (int i = P; i < S; i++) {
 *      switch(DNAChar[i]) {
 *          case 'A'
 *              check[0]++
 *          case 'C'
 *              check[1]++
 *          case 'G'
 *              check[2]++
 *          case 'T'
 *              check[3]++
 *      }
 *
 *      switch(DNAChar[i - P]) {
 *          case 'A'
 *              check[0]--
 *          case 'C'
 *              check[1]--
 *          case 'G'
 *              check[2]--
 *          case 'T'
 *              check[3]--
 *      }
 *
 *      if (check[0] >= A[0] && check[1] >= A[1] && check[2] >= A[2] && check[3] >= A[3]) {
 *          count++
 *      }
 * }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] DNAChar =  br.readLine().toCharArray();
        int[] A = new int[4];
        int[] check = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = P, count = 0;

        for (int i = 0; i < P; i++) {
            switch (DNAChar[i]) {
                case 'A':
                    check[0]++;
                    break;
                case 'C':
                    check[1]++;
                    break;
                case 'G':
                    check[2]++;
                    break;
                case 'T':
                    check[3]++;
                    break;
            }
        }

        boolean isTrue = true;
        for (int i = 0; i < 4; i++) {
            if (check[i] < A[i]) {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            count++;
        }

        for (int i = P; i < S; i++) {
            switch (DNAChar[i]) {
                case 'A':
                    check[0]++;
                    break;
                case 'C':
                    check[1]++;
                    break;
                case 'G':
                    check[2]++;
                    break;
                case 'T':
                    check[3]++;
                    break;
            }

            switch (DNAChar[i - P]) {
                case 'A':
                    check[0]--;
                    break;
                case 'C':
                    check[1]--;
                    break;
                case 'G':
                    check[2]--;
                    break;
                case 'T':
                    check[3]--;
                    break;
            }

            isTrue = true;
            for (int j = 0; j < 4; j++) {
                if (check[j] < A[j]) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                count++;
            }
        }
        System.out.println(count);
    }
}