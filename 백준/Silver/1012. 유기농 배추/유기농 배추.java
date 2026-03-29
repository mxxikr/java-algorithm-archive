import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =  Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int count = 0;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) { // 새로운 배추 덩어리를 발견 시
                        count++; // 지렁이 추가

                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[] {i, j}); // 해당 위치를 시작점으로
                        visited[i][j] = true;

                        while (!q.isEmpty()) {
                            int[] current = q.poll();
                            int y = current[0];
                            int x = current[1];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 1 && !visited[ny][nx]) {
                                    visited[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}