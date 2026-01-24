import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ==== 의사 코드 ====
 *
 * N(노드 개수) M(에지 개수)
 * A(그래프 데이터 저장 인접 리스트)
 * visited(방문 기록 저장 배열)
 * arrive(도착 확인 변수)
 *
 * for(N의 개수만큼 반복하기) {
 *     A 인접 리스트의 각 ArrayList 초기화하기
 * }
 *
 * for(M의 개수만큼 반복하기) {
 *     A 인접 리스트에 그래프 데이터 저장하기
 * }
 *
 * for(N의 개수만큼 반복하기) {
 *     각 노드마다 DFS 실행하기
 *      if(arrive) 반복문 종료 // depth가 5에 도달한 적이 있다면
 * }
 * if(arrive) 1 출력
 * else 0 출력
 *
 * // DFS 구현하기
 * DFS{
 *     if(깊이가 5 || arrive) {
 *         arrive = true;
 *         함수 종료
 *     }
 *
 *    방문 배열에 현재 노드 방문 기록하기
 *    현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS실행하기(호출마다 depth는 1씩 증가)
 * }
 */

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        arrive = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1); // depth 1부터 시작
            if(arrive) break;

        }

        if (arrive) {
            System.out.println("1");
        }
        else {
            System.out.println("0"); // 5의 깊이가 없다면 0 출력
        }
    }

    public static void DFS(int now, int depth) { // DFS 구현하기
        if (depth == 5) { // depth가 5가 되면 프로그램 종료
            arrive = true;
            return;
        }

        visited[now] = true;
        for  (int i : A[now]) {
            if(!visited[i]) {
                DFS(i, depth + 1); // 재귀 호출 될 때마다 depth를 1씩 증가
                if (arrive) return;
            }
        }
        visited[now] = false;
    }
}