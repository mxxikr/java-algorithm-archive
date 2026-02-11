import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N 참가자수 입력 받기
 * Student 클래스 선언 (name, point)
 * Queue<Student> q 선언
 *
 * for (int i=0부터 N까지) {
 *     String name = 입력 받기
 *     int point = 입력 받기
 *     q.add(new Student(name, point))
 * }
 *
 * while(q.size가 1일 때까지) {
 *     Student check = q.poll() 체크할 학생 먼저 큐에서 꺼냄
 *     이동 횟수 = (좋아하는 숫자 - 1) % 현재 큐에 남은 인원 // 좋아하는 숫자가 남은 인원보다 클 수도 있어 나머지 연산
 *     for (int i부터 이동횟수까지) {
 *         큐에 추가 // 최애 학생이 아니므로 큐에 추가
 *     }
 *     큐 꺼냄 (최애학생 찾아서 큐에서 제거)
 * }
 *
 * 마지막에 남은 큐 학생 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Student> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int point = Integer.parseInt(st.nextToken());
            q.add(new Student(name, point));
        }

        while (q.size() > 1) {
            Student find = q.poll();
            int x = (find.point - 1) % q.size();
            for  (int i = 0; i < x; i++) {
                q.add(q.poll());
            }
            q.poll();
        }

        System.out.println(q.peek().name);
    }

    private static class Student {
        String name;
        int point;

        public Student(String name, int point) {
            this.name = name;
            this.point = point;
        }
    }
}