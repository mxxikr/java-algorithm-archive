package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 용감한 쿠키는 평소 사용하는 파일 내 문자열 검색 툴 grep보다 더 빠른 속도를 자랑하는 ack나 ag같은 다양한 툴들이 있다는 것을 들었다.
 * 자신만의 dgrep을 만들어 널리 세상을 이롭게 하고 싶다고 생각하게 된 용감한 쿠키는 그 첫 단계로 멀티스레드로 동작하는 grep을 직접 만들어보기로 결심하였다.
 * 원하는 스펙에 맞는 파일 내 문자열 검색 툴을 만들어보자.
 *
 * 입력 형식
 *  - dgrep {keyword} {relative path}
 *
 * 출력 형식
 *  - 파일의 각 line에 keyword가 있는 경우, 해당 파일과 줄 번호를 출력한다.
 *
 * 조건
 * 1. relative path가 디렉토리인 경우 디렉토리 내 모든 파일에 대해 검사를 진행한다.
 * 2. relative path 내에 또 다른 디렉토리가 존재하는 경우, 각 디렉토리 내 모든 파일에 대한 검사 또한 진행한다.
 * 3. 멀티 스레드를 이용하여 최대한 빠르게 작업을 완료하도록 작성한다.
 * 4. 동일한 파일에 대한 검사 결과는 한 번에 출력되어야 한다.
 * 5. Directory 내 symlink는 없다고 가정한다.
 * 6. 파일들은 모두 UTF8 인코딩으로 작성된 Text파일이라고 가정한다.
 */
public class multiThreadGrepMain {
    public static void collectFiles(Path startPath, List<Path> fileList) throws IOException {
        // startPath가 디렉토리 내부의 모든 파일과 하위 디렉토리를 반복적으로 탐색
        if (Files.isDirectory(startPath)){
            try (DirectoryStream<Path> dirStrem = Files.newDirectoryStream(startPath)) {
                for (Path path : dirStrem) {
                    collectFiles(path, fileList); // 재귀 호출
                }
            }
        } else {  // startPath가 파일인 경우, fileList에 파일 경로 추가
            fileList.add(startPath);
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        // 입력 파싱
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine().trim();
        String[] token = inputString.split(" ");

        if (token.length != 3) {
            System.err.println("Invalid Input");
            System.exit(1);
        }
        String keyword = token[1]; // 키워드 추출
        Path startPath = Paths.get(token[2]); // 시작 경로 추출

        // 파일 리스트 수집
        List<Path> fileList = new ArrayList<>();
        collectFiles(startPath, fileList);

        // 사용 가능한 CPU 코어 수만큼 스레드 풀 생성
        int THREADS = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);

        // 각 파일별로 worker 할당
        List<Future<List<String>>> futures = new ArrayList<>();

        // 각 파일에 대해 키워드 검색 작업을 스레드풀에 제출하고 결과를 Future로 받음
        for(Path path : fileList){
            Future<List<String>> future = pool.submit(() -> {
              List<String> result = new ArrayList<>();

              try (BufferedReader br = Files.newBufferedReader(path)) { // BufferedReader로 파일을 한 줄씩 읽음
                String line;
                int lineNum = 1; // 현재 줄번호
                while ((line = br.readLine()) != null) { // 파일 끝까지 파일 한줄씩 읽음
                    if(line.contains(keyword)) {
                        result.add(path + " : " + lineNum +  " : " + line);
                    }
                    lineNum++; // 파일 줄 기록
                }
              } catch (IOException e) {

              }
              return result;
            });
            futures.add(future); // Future 리스트에 추가
        }

        // 각 Future로부터 해당 파일의 검색 결과를 받아 한 줄씩 출력
        for(Future<List<String>> future: futures){
            List<String> resultList = future.get();
            
            for(String result : resultList){
                System.out.println(result); // 결과 출력
            }
        }
        
        pool.shutdown(); // 스레드풀 종료
    }
}