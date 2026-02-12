import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]); // 작은 숫자가 앞에 와서 빨리 온 사람부터 내보냄

        int N = Integer.parseInt(st.nextToken()); // 포크
        int M = Integer.parseInt(st.nextToken()); // 나이프
        int K = Integer.parseInt(st.nextToken()); // 손님 수

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 도착 시간
            int l = Integer.parseInt(st.nextToken()); // 먹는 시간
            int a = Integer.parseInt(st.nextToken()); // 메뉴(0: 샐러드, 1: 메인)
            while (!pq.isEmpty() && pq.peek()[0] <= t) { // 현재 시간 기준 식사를 마친 손님의 식기구 회수
                int[] out = pq.poll();
                N += out[1];
                M += out[2];
            }

            if (a == 1) { // 메인 요리일 때
                if (N >= 1 && M >= 1) { // 포크, 나이프 둘다 하나 이상 있어야함
                    bw.write("Yes\n");
                    N--;
                    M--;
                    pq.add(new int[]{t + l, 1, 1}); // 나갈 시간, 포크, 나이프 수 기록
                } else {
                    bw.write("No\n");
                }
            } else if (a == 0) { // 샐러드일 때
                if (N >= 1) { // 포크 하나 이상 있어야 함
                    bw.write("Yes\n");
                    N--;
                    pq.add(new int[]{t + l, 1, 0}); // 나갈 시간, 포크 수 기록
                } else {
                    bw.write("No\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}