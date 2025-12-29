package Dp;

import java.util.Arrays;
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
public class FruitScoreDPMain {
    public static int solution(int score, int[] fruit) {
        int[] dy = new int[score + 1];
        Arrays.fill(dy, Integer.MAX_VALUE); // dy 배열을 최댓 값으로 초기화
        dy[0] = 0;

        for (int j = 0; j < fruit.length; j++) {

            for (int i = 1; i <= score; i++) {
                if(i >= fruit[j] && dy[i - fruit[j]] != Integer.MAX_VALUE) { // 현재 점수가 과일의 점수보다 크거나 같고 이전 점수가 최댓값이 아닐 때
                    dy[i] = Math.min(dy[i], dy[i - fruit[j]] + 1); // 현재 점수는 이전 점수 + 1(과일 하나를 먹은 것) 중 최소값으로 갱신
                }
            }
        }

        return dy[score];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int[] fruit = new int[]{100, 50, 5, 1};

        System.out.println(solution(score, fruit));
    }
}