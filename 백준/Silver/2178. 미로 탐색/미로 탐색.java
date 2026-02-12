import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * dx, dy 선언(상하 좌우 탐색)
 * maze 선언 (데이터 저장 2차원 행렬)
 * visited 배열 선언
 * N, M 입력 받기
 *
 * maze 배열 채우기
 * for (int i 0부터 N까지) {
 *     한줄씩 읽기
 *     for (int j 0부터 M까지) {
 *          한글자씩 숫자로 바꿔 배열에 추가
 *     }
 * }
 *
 * 큐 선언(현재 위치)
 * BFS(0, 0)
 * maze[N-1][M-1] 출력
 *
 * BFS
 *      현재 위치 큐에 담기
 *      방문 체크
 *
 *      while(큐가 비어있지않으면) {
 *          int x, y = 큐를 꺼냄
 *          for (int i = 0부터 4까지) // 상하좌우 탐색
 *              nx = x + dx[i]
 *              ny = y + dy[i]
 *               nx >= 0 && nx < N && ny >= 0 && ny < M 인지 확인
 *                  방문하지않았고 벽이 아니라면
 *                       방문 체크
 *                          maze[nx][ny] = maze[x][y] + 1
 *                          q.add(nx, ny)
 * }
 */
public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] maze, visited;
    static int[] dx, dy;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze =  new int[N][M];
        visited =  new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    private static void BFS(int x, int y) {
        queue.add(new int[]{x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int k = 0; k < 4; k++) {
                int nx =  curX + dx[k];
                int ny =  curY + dy[k];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visited[nx][ny] == 0 && maze[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        maze[nx][ny] = maze[curX][curY] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

        }
    }
}