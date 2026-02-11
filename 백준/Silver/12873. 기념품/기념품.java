import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N 참가자수 입력 받기
 * ArrayList list 선언
 *
 * for (int i = 1; i <= N; i++) {
 *     list.add(i)
 * }
 *
 * long t = 1; 1단계부터 시작
 * int currentIndex = 0 술래
 *
 * while (list.size() > 1) {
 *     long jump = (t * t * t - 1) % lise.size() 술래가 이동해야할 칸 수
 *     currentIndex = (currentIndex + jump) % list.size() 현재 위치에서 이동할 위치 구하기
 *     list.remove(currentIndex) 그 위치 사람 제거
 *
 *     t++; 다음 단계로 이동
 * }
 *
 * 리스트에 남은 한명 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        long t = 1;
        int currentIndex = 0;

        while (list.size() > 1) {
            long jump = (long) (t * t * t - 1) % list.size();
            currentIndex = (int) ((currentIndex + jump) % list.size());
            list.remove(currentIndex);

            t++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((String.valueOf(list.get(0))));
        bw.flush();
        bw.close();
    }
}