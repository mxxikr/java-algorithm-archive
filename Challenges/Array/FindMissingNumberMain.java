package Array;

import java.util.Scanner;

/**
 * # 문제 설명
 * 수학자는 숫자 모양 사탕을 모으는 취미가 있다.
 * 바구니에 한가득 숫자 모양 사탕을 싣고 싱글벙글하며 집에 가던 수학자는, 실수로 발을 헛디뎌 넘어져버리고 말았다!
 * 쏟아진 숫자 모양 사탕들을 다시 주워담아 보았지만, 개수를 세어 보니 딱 하나가 모자라다는 것을 알게 되었다.
 * 다행히도 수학자의 바구니에는 원래 있던 숫자 모양 사탕듣의 목록이 적혀 있다.
 *
 * 수학자를 도와, 수학자가 잃어버린 숫자 모양 사탕을 찾아주자!
 * 쏟기 전의 숫자 모양 사탕 배열 s1과 주워담은 후의 숫자 모양 사탕 배열 s2가 주어졌을 때, 사라진 숫자 모양 사탕을 반환하는 함수 solution을 작성하라.
 *
 * # 제한사항
 * s1의 길이는 1 이상 1,000 이하이다.
 * 각각의 숫자 모양 사탕은 0 이상 2³⁰ 이하의 정수이며, 각각의 숫자 모양 사탕은 고유하다(즉, 중복되는 숫자 모양 사탕은 없다).
 * s2에서 각 숫자 모양 사탕의 놓인 순서는 s1와 다를 수 있다.
 *
 * # 입출력 예
 * s1 : [4,99,2,6,7,13,88,76]
 * s2 : [6,88,13,4,99,2,7]
 * result : 76
 */
public class FindMissingNumberMain {
    public static int solution(int[] s1, int[] s2) {
        int s1Sum = 0;
        int s2Sum = 0;

        for (int n : s1) {
            s1Sum += n; // s1의 모든 숫자 모양 사탕의 합
        }

        for (int n : s2) {
            s2Sum += n; // s2의 모든 숫자 모양 사탕의 합
        }

        return s1Sum - s2Sum; // s1에서 s2를 뺀 값이 잃어버린 숫자 모양 사탕
    }

    public static int[] parseArray(String s) {
        s = s.replace("[", "").replace("]", "").replace(" ", "");
        if (s.isEmpty()) {
            return new int[0];
        }

        String[] tokens = s.split(",");

        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1Str = sc.nextLine();
        String s2Str = sc.nextLine();

        int[] s1 = parseArray(s1Str);
        int[] s2 = parseArray(s2Str);

        System.out.println(solution(s1, s2));
    }
}