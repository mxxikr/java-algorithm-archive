import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 */

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int now) {
        visited[now] = true;

        for (int next: graph[now]) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}