package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 영희는 소풍 가는 것을 참 좋아합니다. 소풍에 가면 친구들과 홍차를 마시고 마들렌을 나누어 먹으며 수다를 떨며 놀곤 합니다.
 * 그래서 소풍을 갈 때마다 마들렌을 쉽게 가져갈 수 있도록 주머니에 미리 나누어 담아둡니다.
 * 영희는 마들렌에 대해서는 까다로운 입맛을 가지고 있어서, 다섯 가지 종류의 마들렌만을 준비해놓습니다.
 * 어느 날, 언제나와 같이 소풍을 가려고 준비하던 영희는, 소풍에 여느 때보다 많은 친구들이 참석하게 된다는 것을 알게 되었습니다.
 * 그래서 최대한 많은 마들렌 주머니를 가져가고 싶었던 동시에, 모든 주머니의 마들렌을 꺼내서 모았을 때,
 * 어떤 한 가지 맛의 마들렌을 다른 마들렌의 개수를 모두 합친 것보다 많이 가져가고 싶어졌습니다.
 *
 * 영희는 마들렌 주머니를 담아가야 했기 때문에, 얼마나 많은 마들렌 주머니를 가져가야할지 문득 궁금해졌습니다.
 * 여러분이 영희를 도와주세요!
 *
 * # 예시 1
 * ["cab", "adaaa", "e"] 라는 입력이 들어왔다고 가정합니다.
 * 여기서 세 개의 주머니를 모두 선택하면 a 마들렌이 5개이고, 나머지 마들렌은 4개가 되므로 조건에 부합합니다.
 * 그러므로 return하는 값은 3 입니다.
 *
 * # 예시 2
 * ["aabb", "baba"]라는 입력이 들어왔다고 가정합니다.
 * 여기서는 어떠한 조합으로 주머니를 선택해도 a 마들렌과 b 마들렌의 개수가 똑같으므로 한 가지 맛의 마들렌을 다른 마들렌 개수를 합한 것 보다 많이 가져갈 수 없습니다.
 * 그러므로 return하는 값은 0 입니다.
 *
 * 마들렌 주머니의 내용물들 pouches가 주어졌을 때,
 * 가장 많이 가져갈 수 있는 마들렌 주머니 개수를 반환하는 solution 함수를 완성해주세요.
 *
 * # 제한사항
 * 마들렌의 종류는 a, b, c, d, e의 문자로 표현됩니다.
 * 하나의 마들렌 주머니의 내용물은, 마들렌 문자들이 합쳐진 하나의 문자열로 표현됩니다.
 * 마들렌 주머니들의 목록 pouches는 문자열의 리스트입니다.
 * 마들렌 주머니 속 마들렌을 모두 합친 개수는 200,000을 넘지 않습니다.
 * 모든 마들렌 주머니에는 최소 1개 이상의 마들렌가 들어 있습니다.
 */
public class maxSelectMain {
    /**
     * 목표 : 가져갈 수 있는 최대 주머니 개수 구하기ㅎ
     */
    static String[] madelens = new String[]{"a", "b", "c", "d", "e"};

    public static int solution(String[] pouches) {
        int maxCount = Integer.MIN_VALUE;

        for(String madelen: madelens) {  // 각 마들렌 종류에 대해
            List<Integer> diffList = new ArrayList<>(); // 각 주머니의 기여도(= 메인 개수 - 나머지 개수) 저장
            int[] mainArr = new int[pouches.length]; // 각 주머니의 메인(기준 마들렌) 개수 배열
            int[] subArr = new int[pouches.length];  // 각 주머니의 다른 마들렌(서브) 개수 배열

            for (int i = 0; i < pouches.length; i++) { // 주머니 속 마들렌
                String pouch = pouches[i];  // 현재 주머니
                int mainCount = 0; // 현재 마들렌 종류와 같은 마들렌 개수를 세기 위한 변수
                int subCount = 0; // 현재 마들렌 종류와 다른 마들렌 개수를 세기 위한 변수
                for (char c : pouch.toCharArray()) { // 주머니속 마들렌을 하나씩 확인
                    if (c == madelen.charAt(0)) { // 주머니속 마들렌이 현재 마들렌 종류와 같다면
                        mainCount++; // 현재 마들렌 종류의 개수를 증가
                    } else {
                        subCount++;
                    }
                }
                mainArr[i] = mainCount; // i번째 주머니의 메인 개수 저장
                subArr[i] = subCount; // i번째 주머니의 서브 개수 저장
                diffList.add(mainCount - subCount); // 기여도(메인 - 서브) 저장

            }
            // 기여도가 큰 순서대로 주머니 인덱스를 정렬 (내림차순)
            List<Integer> sortedIdx = new ArrayList<>();
            for (int i = 0; i < diffList.size(); i++) sortedIdx.add(i);
            sortedIdx.sort((i1, i2) -> diffList.get(i2) - diffList.get(i1));

            int totalMain = 0;  // 선택한 주머니에서 기준 마들렌 누적합
            int totalSub = 0;   // 선택한 주머니의 나머지 마들렌 누적합
            int count = 0;      // 선택 가능한 주머니의 개수

            // 정렬된 주머니를 하나씩 차례로 선택
            for (int idx : sortedIdx) {
                int m = mainArr[idx];
                int s = subArr[idx];
                // 기준 마들렌 총합 > 나머지 마들렌 총합 성립하면 선택
                if (totalMain + m > totalSub + s) {
                    totalMain += m; // 기준 마들렌 누적
                    totalSub += s;  // 나머지 누적
                    count++;        // 주머니 개수 +1
                } else {
                    break;          // 조건을 더 이상 만족하지 못하면 중단
                }
            }
            // 여러 종류(a~e) 중 가능한 최대 개수를 갱신
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] pouches = input.split(" ");

        System.out.println(solution(pouches));
    }
}