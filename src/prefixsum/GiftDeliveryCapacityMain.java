package prefixsum;

import java.util.Scanner;

/**
 * 12월 25일. 산타클로스는 아이들에게 선물을 배달하느라 여념이 없습니다.
 * 아이들 앞으로 보내지는 선물들이 항상 많아 매일매일이 정신없는 산타클로스.
 * 산타클로스는 선물을 배달하는 중간에 또다른 선물을 픽업해서 배송하고자 합니다.
 * 산타클로스가 최대로 들 수 있는 선물의 개수가 정수 capacity로, 배달 경로가 배열 routes로 입력이 주어집니다.
 * routes의 각 요소는 [giftNum, from, to]의 형태일 때, 산타클로스가 모든 경로를 단방향으로 거쳐 배달할 수 있을까요?
 *
 * # 예시 1
 * capacity = 9, routes = [[3,2,6],[5,1,4],[1,7,13]] 이라면
 * 산타클로스는 한번에 선물을 최대 9개까지 들 수 있으므로, 다음과 같이 배달합니다.
 * 산타클로스의 선물 배달_예시.png
 *
 * 1번 지점에서 5개의 선물을 픽업합니다.
 * 2번 지점에서 3개의 선물을 픽업합니다.
 * 4번 지점에서 5개의 선물을 배달 완료합니다.
 * 6번 지점에서 3개의 선물을 배달 완료합니다.
 * 7번 지점에서 1개의 선물을 픽업합니다.
 * 13번 지점에서 1개의 선물을 배달 완료합니다.
 * 산타클로스는 4번 지점에 도착할 때까지 총 8개의 선물을 들고 이동해야 합니다.
 * 1번 지점에서 5개의 선물을, 2번 지점에서 3개의 선물을 픽업했기 때문입니다.
 * 이때 산타클로스는 선물을 최대 9개까지 들 수 있으므로 능히 옮길 수 있습니다.
 * 7번 지점에서 13번 지점까지는 1개의 선물만 들고 있으면 되므로, 이 역시 문제가 없습니다.
 * 따라서 산타클로스는 모든 경로를 단방향으로 거쳐 선물을 배달할 수 있으므로 return하는 값은 true 입니다.
 *
 * 산타클로스가 최대로 들 수 있는 선물의 개수가 정수 capacity와, 배달 경로가 배열 routes로 입력이 주어질 때,
 * 산타클로스가 선물을 배달 할 수 있는 여부를 return하도록 solution 함수를 완성해주세요.
 *
 * # 제한 사항
 * capacity는 1 이상 100,000 이하입니다.
 * routes의 길이는 1 이상 1,000 이하입니다.
 * routes[i]의 길이는 3 입니다.
 * routes[i][0]인 giftNum은 1 이상 100 이하입니다.
 * routes[i][1], routes[i][2]인 from, to는 0 이상 1,000 이하입니다.
 * 모든 routes[i]에 대해서 routes[i][1] < routes[i][2]입니다.
 */
public class GiftDeliveryCapacityMain {
    private static boolean solution(int capacity, int[][] routes) {
        int now = 0; // 현재 들고 있는 선물의 개수
        int max = Integer.MIN_VALUE; // 최대 들고 있는 선물의 개수

        int[] tmp = new int[10002];
        for (int[] route : routes) {
            tmp[route[1]] += route[0]; // from 지점에서 선물 개수 증가
            tmp[route[2]] -= route[0]; // to 지점에서 선물 개수 감소
        }

        for (int i = 0; i < tmp.length; i++) {
            now += tmp[i]; // 현재 들고 있는 선물의 개수 업데이트
            if (now > capacity) { // 현재 들고 있는 선물의 개수가 capacity를 초과하면 false
                return false;
            }
            max = Math.max(max, now); // 최대 들고 있는 선물의 개수 업데이트
        }

        return max <= capacity; // 최대 들고 있는 선물의 개수가 capacity 이하인지 확인
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int[][] routes = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                routes[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(capacity, routes));
    }
}
