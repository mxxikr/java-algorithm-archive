import java.io.*;
import java.util.*;

/**
 * ==== 의사 코드 ====
 * N (기록 수 입력받기)
 * HashSet 선언하기
 * for (0부터 N까지) {
 *     log (출입기록 입력 받기)
 *     logKey (StringTokenizer로 입력 받기)
 *     logValue (StringTokenizer로 입력 받기)
 *     // logValue가 "enter"
 *      // hashSet.add(logkey)
*      // logValue가 "leave"
 *       // hashSet.remove(logkey)
 * }
 *
 * ArrayList에 set 담기
 * 내림차순 정렬 후 출력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String log = br.readLine();
            StringTokenizer st = new StringTokenizer(log);
            String logKey = st.nextToken();
            String logValue = st.nextToken();

            if (logValue.equals("enter")) {
                set.add(logKey);
            } else if (logValue.equals("leave")) {
                set.remove(logKey);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list,  Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}