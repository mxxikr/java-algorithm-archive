import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N(수빈이 현재 위치 입력받기)
 * K(동생 현재 위치 입력받기)
 * visited[100001] 저장소 배열 생성
 * Queue<Integer>> 대기열 생성
 *
 * q.push(N) // 출발지 입력
 * visited[N] = 1 // 방문 체크
 * bfs(N)
 *
 * bfs(int start) {
 *   while(!q.isEmpty) { // 큐가 빌때까지
 *     int check = q.poll() // 큐의 맨 앞을 꺼내옴
 *     if (check == K) { // 목적지와 같다면
 *          System.out.println(visited[check] - 1); // 현재 위치 시간 출력
 *          // 종료
 *     }
 *
 *     int[] nextPosition = {check -1, check + 1, check * 2} // 다음으로 갈 수 있는 위치
 *
 *     for (int next: nextPosition) {
 *         if (next >= 0 && next <= 100000) { // 배열 인덱스 넘어가지 않도록 검사
 *             if (visited[next] == 0) { // 안가봤다면
 *                 visited[next] = visited[check] + 1; // 현재 시간 +1초 체크
 *
 *                 q.add(next) // 다음 턴에서 다시 탐색
 *             }
 *         }
 *     }
 *   }
 * }
 */

public class Main {
    static int K;
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];


        q.add(N);
        visited[N] = 1;
        bfs(N);

    }

    private static void bfs(int start) {
        while (!q.isEmpty()) {
            int check = q.poll();

            if (check == K) {
                System.out.println(visited[check] - 1);
                return;
            }

            int[] nextPosition = {check + 1, check - 1, check * 2};

            for (int next : nextPosition) {
                if (next >= 0 && next <= 100000) {
                    if (visited[next] == 0) {
                        visited[next] = visited[check] + 1;

                        q.add(next);
                    }
                }
            }
        }
    }
}