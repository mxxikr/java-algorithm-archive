import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 * N(정점의 개수)
 * M(간선의 개수)
 *
 * for (i = 1; i <= N; i++) {
 *     graph[i] = ArrayList<>(); // 초기화
 * }
 *
 * for (i = 0; i < M; i++) {
 *     int u = 입력 받은 값
 *     int v = 입력 받은 값
 *
 *     graph[u].add(v)
 *     graph[v].add(u)
 * }
 *
 * count = 0;
 * for (i = 1; i <= N; i++){
 *     if (visited[i] == false) {
 *         count++
 *         dfs(i)
 *     }
 * }
 *
 * dfs(int now) {
 *     visited = true;
 *     for (int next: graph[now] {
 *          if (visited[next] == false) {
 *              dfs(next)
 *          }
 *     }
 * }
 */

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            if  (visited[i] == false) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int now) {
        visited[now] = true;

        for (int next : graph[now]) {
            if (visited[next] == false) {
                dfs(next);
            }
        }
    }
}