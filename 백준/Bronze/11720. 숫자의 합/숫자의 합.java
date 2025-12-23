import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문자열 형태로 입력 값 받은 후 문자 배열로 변환 -> 문자 배열 값을 순서대로 읽어 숫자로 변환해 더해야함
 * 문자열을 숫자형으로 변경하려면 문자 - 48 혹은 문자 - 0 연산
 *
 * =======의사 코드==========
 * N 값 입력 받기
 * 길이 N의 숫자 입력 받아 String형 변수 sNum에 입력 받기
 * sNum을 다시 char []형 변수 cNum에 변환하여 저장하기
 * int형 변수 sum 선언하기
 * for(cNum 길이만큼 반복하기)
 * {
 *      배열의 각 자리 값을 정수형으로 변환하여 sum에 더하여 누적하기
 * }
 * sum 출력하기
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String sNum = br.readLine();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }
        System.out.println(sum);
    }
}