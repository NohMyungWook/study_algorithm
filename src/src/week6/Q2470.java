package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        List<Integer> input = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int[] answer = new int[2];

        int low = 0, high = input.size() - 1;
        int min = Integer.MAX_VALUE;

        while (low < high) {
            int sum = input.get(low) + input.get(high);

            min = updateAnswer(min, sum, answer, low, high, input);
            if(min == 0) {
                break;
            }
            if (sum < 0) {
                low += 1;
            }
            else {
                high -= 1;
            }
        }
        System.out.print(answer[0] + " " + answer[1]);
    }

    public static int updateAnswer(int min, int sum, int[] answer, int low, int high, List<Integer> input) {
        if (sum < 0) sum *= -1;
        if (min > sum) {
            answer[0] = input.get(low);
            answer[1] = input.get(high);
            min = sum;
        }
        return min;
    }
}
