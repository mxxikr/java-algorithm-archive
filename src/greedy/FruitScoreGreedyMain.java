package greedy;

import java.util.Scanner;

/**
 * 오늘도 열심히 과일을 주워 먹고 있는 원숭이는 점프를 하다가 과일을 가장 효율적으로 먹으면 편하겠다는 생각을 하게 되었다.
 * 과일의 종류가 아래와 같이 있다고 할 때, 원숭이는 지정된 점수를 달성하기 위해서 최소 몇 개의 과일을 먹어야 할까?
 *
 * 과일 이름 점수
 * 왕사과 100점
 * 별 바나나 50점
 * 노랑 복숭아 5점
 * 일반 포도 1점
 *
 * # 예시 1
 * 156점을 달성해야 하는 상황일 때, 100점 과일 1개, 50점 과일 1개, 5점 과일 1개, 1점 과일 1개로,
 * 총 4개의 과일로 주어진 점수를 최소 과일로 달성할 수 있다.
 * 그러므로 return하는 값은 4 입니다.
 *
 * # 예시 2
 * 319점을 달성해야 하는 상황일 때, 100점 과일 3개, 50점 과일 0개, 5점 과일 3개, 1점 과일 4개로,
 * 총 10개의 과일로 주어진 점수를 최소 과일로 달성할 수 있다.
 * 그러므로 return하는 값은 10 입니다.
 * 달성해야 하는 점수 score가 주어졌을 때,
 * 최소로 먹어야 하는 과일 개수를 반환하는 solution 함수를 완성해주세요.
 *
 * # 제한사항
 * 달성해야 하는 점수 score는 1이상 1,000,000 이하입니다
 */
public class FruitScoreGreedyMain {
    public static int solution(int score, int[] fruitScores) {
        int count = 0;
        for (int i = 0; i < fruitScores.length; i++) {
            if (score >= fruitScores[i]) {
                count += score / fruitScores[i];
                score = score % fruitScores[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score =sc.nextInt();
        int[] fruitScores = {100, 50, 5, 1}; // 과일 점수 배열

        System.out.println(solution(score, fruitScores));
    }
}