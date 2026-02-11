import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * 방문배열, 인접 리스트 배열 선언
 * N(정점 개수) M(간선 개수) start(시작 정점 번호) 입력 받기
 * 인접리스트 배열 N+1 크기 선언
 * for (int i가 1부터 N + 1 까지) {
 *     A[i] = ArrayList<>()
 * }
 *
 * for (int i 0부터 M까지) { 그래프 채우기
 *     int S = 입력받기
 *     int E = 입력받기
 *     A[S].add[E] 양방향으로 채우기
 *     A[E].add[S]
 * }
 *
 * for (int i가 1부터 N + 1 까지) {
 *     Collections.sort(A[i]) 오름차순 정렬
 * }
 *
 * 방문배열 N+1초기화
 * DFS(start)
 * System.out.println()
 * 방문배열 N+1초기화
 * BFS(start)
 *
 * DFS(int start) {
 *     방문체크 true;
 *     방문한 노드 바로 출력
 *
 *     for(int i: A[start]) { 인접 리스트 확인
 *         만약 방문하지 않았다면
 *         DFS(i)
 *     }
 * }
 *
 * BFS(int start) {
 *      큐 선언
 *      큐에 노드 추가
 *      방문 체크
 *      while 큐가 비어있지않다면 반복 {
 *          큐에서 노드 꺼내서
 *          꺼낸 노드 출력
 *          for(int i : A[nowNode]) { 꺼낸 노드 방문
 *              만약 방문하지 않았다면
 *              큐에 추가
 *              방문 처리
 *          }
 *      }
 * }
 */

public class Main {
    static boolean visited[];
    static ArrayList<Integer> A[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { // 그래프 채우기
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]); // 오름차순 정렬
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화
        DFS(start);

        sb.append("\n");

        visited = new boolean[N + 1]; // 방문 배열 출력
        BFS(start);
        
        System.out.println(sb.toString());
    }

    private static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int nowNode = q.poll();
            sb.append(nowNode).append(" ");
            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private static void DFS(int start) {
        sb.append(start).append(" ");
        visited[start] = true;

        for (int i:A[start]) {
            if (!visited[i]) { // 방문 안했던 노드들 방문
                DFS(i);
            }
        }
    }
}