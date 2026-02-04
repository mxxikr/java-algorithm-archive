import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * Document 클래스 선언(원래 위치, 우선 순위)
 * T(테스트 케이스 갯수 입력 받기)
 *
 * while (T-- > 0) {
 *     int N (문서의 개수 입력 받기)
 *     int M (궁금한 문서 위치)
 *     Queue<Document> q 선언
 *
 *     for (int i = 0; i < N; i++) {
 *         int priority = // 우선 순위 입력 받기
 *         q.add(new Document(index, priority)) // 큐 채우기
 *
 *     }
 *
 *     count 선언(출력 순서)
 *
 *     while(!q.isEmpty) {
 *         Document check = q.poll() // 가장 앞 꺼내기
 *         boolean isMax = true;
 *
 *         for (Document doc: q) { // 꺼낸 수와 비교해서 더 큰 수인지 확인
 *              if (doc.priority > check.priority) {
 *                  isMax = false; // 더 큰수가 있다면 false처리
 *                  break;
 *              }
 *         }
 *
 *         if(isMax == false) { // 확인 결과가 false이면
 *             q.addLast(check) // 뒤로 보냄
 *         } else { // 꺼낸 수가 더 크면
 *             count++; // 인쇄 횟수 출력
 *             if (check.index == M) { // 만약 꺼낸수의 인덱스가 궁금한 문서위치와 같다면
 *                 count 출력 // 인쇄 횟수 출력
 *                 break;
 *             }
 *         }
 *      }
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        class Document {
            int index;
            int priority;

            public Document(int index, int priority) {
                this.index = index;
                this.priority = priority;
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Document> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Document check = queue.poll();
                boolean isMax = true;

                for (Document d : queue) {
                    if (d.priority > check.priority) {
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    queue.add(check);
                } else {
                    count++;
                    if (check.index == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}