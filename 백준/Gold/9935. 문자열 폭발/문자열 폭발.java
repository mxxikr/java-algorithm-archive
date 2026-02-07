import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * StringOrigin = 검사할 문자열 입력 받기
 * StringCheck = 폭팔 문자열 입력받기
 * StringBuilder storage 선언 // StringOrigin 담는 용도
 *
 * for (char c : StringOrigin.toCharArray) {
 *     storage.append(c)
 *
 *     if (storage.length() >= StringCheck.length) {
 *          int startIndex = storage.length - StringCheck.length // 시작 인덱스
 *           boolean isMatch = true; // 일치한다 먼저 가정
 *          for (i = 0; i < StringCheck.length(); i++) { // 폭팔 문자열의 자릿수만큼
 *              if (storage.charAt(i + startIndex) != StringCheck.CharAt(i) { // 시작인덱스+i와 폭팔인덱스의 i 인덱스가 같지않으면
 *                  isMatch = false; // 매칭 실패
 *                  break;
 *              }
 *          }
 *          if (isMatch) { // 매칭 성공하면 삭제
 *               storage.delete(startIndex, startIndex + StringCheck.length)
 *           }
 *     }
 * }
 *
 * if (!storage.isEmpty) {
 *     storage 출력
 * } else {
 *     FRULA 출력
 * }
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String StringOrigin = br.readLine();
        String StringCheck =  br.readLine();
        StringBuilder storage = new StringBuilder();

        for (char c : StringOrigin.toCharArray()) {
            storage.append(c);

            if (storage.length() >= StringCheck.length()) {
                int startIndex = storage.length() - StringCheck.length();
                boolean isMatch = true;
                for (int i = 0; i < StringCheck.length(); i++) {
                    if (storage.charAt(i + startIndex) != StringCheck.charAt(i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    storage.delete(startIndex, startIndex + StringCheck.length());
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (storage.length() > 0) {
            bw.write(storage.toString());
        } else {
            bw.write("FRULA");
        }
        bw.flush();
        bw.close();
    }
}