import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * int[] dx = {0, 0, -1, 1}
 * int[] dy = {-1, 1, 0, 0}
 * int[][] field
 * boolean[][] visited
 *
 * T(테스트 케이스 개수 입력 받기)
 * while (T-- > 0) {
 *     StringTokenizer = br.line()
 *     int M = st.token // 가로 길이
 *     int N  = st.token // 세로 길이
 *     int k = st.token // 배추가 심어져이쓴 위치의 개수
 *
 *     field = new int[M][N]
 *     visited = new boolean[M][N]
 *     int warmCount = 0
 *
 *     for (int i = 0; i < K; i++) {
 *         st = br.line()
 *         int x = st.token()
 *         int y = st.token()
 *
 *         field[x][y] = 1
 *
 *     }
 *
 *     for (int i = 0; i < M; i++){
 *         for (int j = 0; j < N; ㅓ++) {
 *             //배추가 있고 지렁이가 안가봤다면
 *             if (field[i][j] == 1 && !visited[i][j]) {
 *                  warmCount++;    // 지렁이 추가
 *
 *                  dfs(i, j) // dfs 호출
 *             }
 *
 *         }
 *     }
 * }
 *
 * dfs (int x, int y) {
 *    visited[i][j] = true;   // 방문 표시
 *
 *    for (int i = 0;  i <  4; i++) { // 상하좌우 확인
 *        nx = x + dx[i] // 다음 x 좌표
 *        n = y + dy[i]  // 다음 y 좌표
 *
 *        if ( nx >= 0 && nx < M && ny >= 0 && ny < N) { // 밭 범위 벗어났는지 체크
 *            if (field[nx][ny] == 1 && !visited[nx][ny]) { // 배추가 있고 방문 전이라면
 *                  dfs(nx, ny)
 *            }
 *        }
 *    }
 * }
 */

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] field;
    static boolean[][] visited;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M =  Integer.parseInt(st.nextToken());
            N =  Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int[M][N];
            visited = new boolean[M][N];
            int warmCount = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        warmCount++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(warmCount);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}