import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line =  br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(arr[N - 1][M - 1]);
    }
}