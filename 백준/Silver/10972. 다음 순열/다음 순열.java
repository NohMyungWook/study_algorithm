import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Integer> input = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (nextPermutation(input)) {
            for (Integer integer : input) {
                System.out.print(integer + " ");
            }
        }
        else {
            System.out.print(-1);
        }
    }
    public static boolean nextPermutation(List<Integer> input) {
        int i = input.size() - 1, j = input.size() - 1;
        // A[i - 1] < A[i]를 만족하는 가장 큰 i 선택
        while(i > 0 && input.get(i - 1) >= input.get(i)) i--;
        // i를 찾지 못했을 경우
        if (i <= 0) return false;
        // j >= i 이면서 A[j] > A[i - 1]를 만족하는 가장 큰 j 선택
        while(j >= 0 && input.get(j) <= input.get(i - 1)) j--;
        // A[i - 1]과 A[j]를 swap
        swap(input, i - 1, j);
        // A[i]의 순열을 뒤집음
        j = input.size() - 1;
        while (i < j) {
            swap(input, i++, j--);
        }
        return true;
    }
}