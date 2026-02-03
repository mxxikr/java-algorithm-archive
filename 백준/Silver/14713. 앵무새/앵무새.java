import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(앵무새 수 입력받기)
 * queue<String>[] 선언
 *
 * for (i = 0; i < N; i++;) {
 *     String lines = br.readline()
 *     // 문장을 공백으로 쪼개서 큐에 순서대로 add
 * }
 *
 * String target = br.readline(); // 받아 적은 문장 입력 받기
 * String[] targetWords = target.split(" ");
 *
 * for (String word: targetWord) {
 *     boolean found = false;
 *     for (int i = 0; i < N; i++){
 *         //  i번째 앵무새의 큐가 안비어있고 peek가 현재 word와 같다면 그 단어를 poll
 *         // found = true로 변경
 *         break; // 다음 단어로 이동
 *     }
 *
 *     if(!found) {
 *         Impossible 출력
 *         return;
 *     }
 * }
 *
 * for (int i = 0; i < N; i++) {
 *     if (!q[i].isEmpty) {
 *         Impossible 출력
 *         return;
 *     }
 * }
 * Possible 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Queue<String>[] q = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            q[i] = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                q[i].add(st.nextToken());
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalWords = st.countTokens();
        String[] targetWords = new String[totalWords];

        for (int i = 0; i < totalWords; i++) {
            targetWords[i] = st.nextToken();
        }

        for (String word : targetWords) {
            boolean  found = false;

            for (int i = 0; i < N; i++) {
                if (!q[i].isEmpty() && q[i].peek().equals(word)) {
                    q[i].poll();
                    found = true;
                    break;
                }

            }
            if (!found) {
                System.out.println("Impossible");
                return;
            }

        }
        for (int i = 0; i < N; i++) {
            if (!q[i].isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }


        System.out.println("Possible");

    }
}