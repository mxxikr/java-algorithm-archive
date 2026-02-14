import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N, M 입력 받기
 * int[][] map 선언
 * 큐 선언
 * dx = {0, 0, -1, 1} 상하좌우 이동 변수 선언
 * dy = {1, -1, 0, 0}
 *
 * for (int i = 0부터 N까지) {
 *     for (int j = 0부터 M까지) {
 *         map[i][j] = st.token 입력 받기
 *         if (map[i][j]가 익은 토마토라면) {
 *             큐에 해당 위치 정보 담기
 *         }
 *     }
 * }
 *
 * int max = 0;
 *
 * BFS함수 호출
 * for (int i = 0부터 N까지) {
 *     for (int j = 0부터 M까지) {
 *          if(map[i][j] == 0) {
 *              -1 출력
 *              return
 *          } else if (max < map[i][j] ){
 *              max = map[i][j]
 *          }
 *     }
 *  }
 *
 *  max -1 출력
 *
 * BFS() {
 *      while(큐가 비어있지않을 동안) {
 *          int[] check = q.poll()
 *          int x = check[0]
 *          int y = check[1]
 *
 *          for (int i = 0 i < 4) {
 *              int nx = x + dx[i]
 *              int ny = y + dy[i]
 *
 *              if (nx >= 0 && nx < N && ny >=0 && ny <M){
 *                  if (map[nx][ny] == 0) {
 *                      map[nx][ny] = map[x][y] + 1
 *                      q.offer(new int[] nx, ny)
 *                  }
 *          }
 *      }
 * }
 */
public class Main {
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int max = 0;
        BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        System.out.println(max -1);
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int[] check = queue.poll();
            int x = check[0];
            int y = check[1];

            for (int i = 0; i < 4; i++) {
                int nx =  x + dx[i];
                int ny =  y + dy[i];

                if (nx >= 0 && nx < N && ny >=0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}