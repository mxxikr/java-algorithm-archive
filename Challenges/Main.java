import java.io.*;
import java.util.*;

/**
 N(질의 요청 개수)
 우선순위 큐 선언
 - 절댓값 기준으로 정렬되도록 설정하기
 - 단, 절댓값이 같으면 음수 우선 정렬하기

 for(N만큼 반복)
 {
 요청이 0일 때: 큐가 비어있으면 0, 비어 있지 않으면 큐의 front 값 출력하기(poll())
 요청이 1일 때 : 새로운 데이터를 우선순위 큐에 더하기(add())
 }
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =  Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 == abs2) return o1 >  o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
                else return abs1 - abs2; // 절댓값을 기준으로 정렬하기
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (pq.isEmpty()) {
                    bw.write(String.valueOf(0));
                } else {
                    bw.write(String.valueOf(pq.poll())); // 숫자를 문자열로 변환
                }
                bw.newLine(); // 줄바꿈 추가
            } else {
                pq.add(request);
            }
        }
        
        // flush()와 close() 호출
        bw.flush();
        bw.close();
        br.close();
    }}