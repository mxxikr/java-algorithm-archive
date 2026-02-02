import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 *  N(지도 크기 입력 받기)
 *  int map[N][N] // 지도 변수 선언
 *  boolean visited[N][N] // 방문 체크 변수 선언
 *
 *  for (int i = 0; i < N; i++) { // 지도 채우기
 *      for (int j = 0; j < N; i++) {
 *          map[i][j] = 입력 받은 값 저장
 *  }
 *
 *  count = 0; // 단지 수
 *  ArrayList<Integer> answer = new ArrayList<>(); // 단지 내 집 개수 담기
 *
 *  for (int i = 0; i < N; i++) { // 지도 훑기
 *      for (int j = 0; j < N; i++) {
 *          if(map[i][j] == 1 이고 visited[i][j] == false이면) {
 *              count++; // 새로운 단지 추가
 *              houseCount = 0; // 이번 단지 집 개수 초기화
 *              dfs(i, j)
 *
 *              answer.add(houseCount);
 *          }
 *      }
*   }
 *
 *   dfs(int x, int y) {
 *       visited[x][y] = true;
 *       houseCount++;
 *
 *       dx = [-1, 1, 0, 0]
 *       dy = [0, 0, -1, 1]
 *
 *       for (int = 0; i < 4; i++) {
 *           nx = dx[i] + x
 *           ny = dy[i] + y
 *
 *           if (nx, ny가 지도 범위(0보다는 크고 N보다 작은지) 안에 있고) {
 *               if (map[nx][ny] == 1이고 visited[nx][ny] == false이면) {
 *                   dfs(nx, ny);
 *               }
 *           }
 *       }
 *   }
 *
 */

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int houseCount;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];



        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    houseCount = 0;
                    dfs(i, j);

                    answer.add(houseCount);
                }
            }
        }

        Collections.sort(answer);

        System.out.println(count);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        houseCount++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, - 1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}