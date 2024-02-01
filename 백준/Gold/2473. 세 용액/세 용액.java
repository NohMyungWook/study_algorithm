import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        List<Long> input = Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong)
                .sorted()
                .collect(Collectors.toList());

        long[] answer = new long[3];

        long min = Long.MAX_VALUE;
        long low, high;

        for (int i = 0; i < N; i++) {
            low = i + 1;
            high = N - 1;
            while (low < high) {
                long sum = input.get(i) + input.get((int) low) + input.get((int) high);

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = input.get(i);
                    answer[1] = input.get((int) low);
                    answer[2] = input.get((int) high);
                }
                if (sum > 0) high--;
                else if (sum < 0) low ++;
                else break;
            }
        }
        System.out.print(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}