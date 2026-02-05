import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(큐의 크기 입력 받기)
 * M(뽑아내려고 하는 수의 개수 입력 받기)
 * LinkedList<Integer> LinkedList q 선언
 * count = 0 // 출력 횟수 저장
 * for (1부터 N + 1까지) { // 큐 채우기
 *     q.add(i)
 * }
 * for (0부터 M까지) {
 *     int check = st.token
 *     int targetIndex = q.indexOf(check) // 찾는 숫자 현재 위치
 *     int middleIndex = q.size() / 2 // 현재 줄의 중간 지점
 *
 *     if (targetIndex <= middleIndex ){
 *          while (q.peekFirst() != check ) {
 *              // 왼쪽으로 한칸 이동
 *              q.addLast(q.pollFirst)
 *              count++
 *           }
 **     } else {
 *          while (q.peekFirst() != check ) {
 *              // 왼쪽으로 한칸 이동
 *              q.addFirst(q.pollLast)
 *              count++
 *          }
 *     }
 *
 *     if (q.peekFirst() == check) {
 *         q.pollFirst
 *     }
 * }
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q =  new LinkedList<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int check =  Integer.parseInt(st.nextToken());
            int targetIndex = q.indexOf(check);
            int middleIndex = q.size() / 2;

            if (targetIndex <= middleIndex) {
                while (q.peekFirst() != check) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            } else {
                while (q.peekFirst() != check) {
                    q.addFirst(q.pollLast());
                    count++;
                }
            }

            if (q.peekFirst() == check) {
                q.pollFirst();
            }
        }

        System.out.println(count);
    }
}