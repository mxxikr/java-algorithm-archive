import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * N(카드의 개수) myQueue(카드 저장 자료 구조)
 * for(카드 개수만큼 반복)
 * {
 * 	큐에 카드 저장하기
 * }
 *
 * while(카드가 1장 남을 때까지)
 * {
 * 	맨 위의 카드를 버림: poll()
 * 	맨 위의 카드를 가장 아래의 카드 밑으로 이동: poll() -> add()
 * }
 * 마지막으로 남은 카드 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> myQueue = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) { // 카드를 큐에 저장하기
            myQueue.add(i);
        }

        while (myQueue.size() > 1) { // 카드가 한장 남을 떄까지
            myQueue.poll(); // 맨 위 카드를 버림
            myQueue.add(myQueue.poll()); // 맨 위 카드를 가장 아래 카드 밑으로 이동
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(myQueue.poll())); // 숫자 값을 문자열로 변환하여 출력
        bw.newLine(); // 표준 출력 형식에 맞게 개행 추가

        bw.flush(); // 버퍼의 내용을 출력 스트림으로 내보냄
        bw.close(); // BufferedWriter 닫기 (자동으로 flush 포함)
        br.close(); // BufferedReader 닫기
    }
}