import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력 받기

        while (T-- > 0) { // 테스트 케이스 수 만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
            int M = Integer.parseInt(st.nextToken()); // 배열 B의 크기
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // A 배열의 물고기 크기 읽어오기
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) { // B 배열의 물고기 크기 읽어오기
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A); // 오름차순 정렬
            Arrays.sort(B);

            int index = 0; // B 배열 포인터
            int count = 0; // 정답

            for (int i = 0; i < N; i++) { // A 하나씩 꺼내서 B와 비교
                while (index < M && B[index] < A[i]) { // A의 현재 물고기가 B의 물고기보다 클 동안 반복
                    index++; // 포인터 이동
                }
                count += index; // while문 멈췄을 때 index 값은 현재 A[i]보다 작은 B 물고기들의 총 개수
            }
            System.out.println(count);
        }
    }
}