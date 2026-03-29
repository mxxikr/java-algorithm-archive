import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map  = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    int count = 1; // 현재 시작하는 집 포함
                    int[] dx = {0, 0, -1, 1};
                    int[] dy = {1, -1, 0, 0};

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                                count++;
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }


        Collections.sort(list); // 오름차순 정렬

        System.out.println(list.size()); // 총 단지 수
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // 각 단지별 집 수
        }
    }
}