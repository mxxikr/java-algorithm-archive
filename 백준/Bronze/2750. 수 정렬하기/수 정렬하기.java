import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    /**
     * 배열을 절반으로 나누고 자기 자신을 다시 호출
     * @param array
     */
    private static void mergeSort(int[] array) {
        if(array.length <= 1) return; // 탈출 조건 - 배열의 크기가 1보다 작거나 같으면 이미 정렬 된 것으로 봄

        int mid = array.length/2; // 현재 배열의 가운데 인덱스
        int[] left = new int[mid];
        int[] right = new int[array.length-mid];

        System.arraycopy(array, 0 , left, 0, mid); // 왼쪽 배열을 나눔
        System.arraycopy(array, mid , right, 0, array.length-mid); // 오른쪽 배열을 나눔

        // 재귀 호출
        mergeSort(left);
        mergeSort(right);

        // 왼쪽과 오른쪽을 합침
        merge(array, left, right);
    }


    /**
     * 두개의 정렬 된 배열을 비교하여 하나의 정렬된 배열로 합침
     * @param left
     * @param right
     */
    private static void merge(int[] array, int[] left, int[] right) {
        // 배열에서 숫자를 꺼내야함 (위치 정보 필요)
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // 두 배열의 요소를 비교하며 작은 값을 결과 배열에 삽입
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) { // 이미 정렬되어있으므로 가장 앞에 있는 숫자끼리만 비교함
                array[resultIndex++] = left[leftIndex++]; // 값 넣은 후 인덱스 옮겨줘야함
            } else {
                array[resultIndex++] = right[rightIndex++];
            }
        }

        // 한쪽 소진 시 나머지 삽입
        while (leftIndex < left.length) {
            array[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            array[resultIndex++] = right[rightIndex++];
        }

    }
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터의 개수 N 읽기
        int n = Integer.parseInt(br.readLine());

        // N개의 수 읽기
        int[] arr =  new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (arr == null || arr.length == 0) return; // 배열이 비어있거나 요소가 하나라면 정렬 필요 없음

        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}