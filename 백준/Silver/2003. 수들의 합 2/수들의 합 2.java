import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNAndM = br.readLine().split(" ");
        int n = Integer.parseInt(inputNAndM[0]);
        int m = Integer.parseInt(inputNAndM[1]);

        List<Integer> input = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        input.add(0);
        int start = 0, end = 0, total = 0;
        int sum = input.get(start);

        while (start <= end && end < n) {
            if (sum < m) {
                sum += input.get(++end);
            } else if (sum == m) {
                total += 1;
                sum += input.get(++end);
            } else {
                sum -= input.get(start++);
                if (start > end) {
                    end = start;
                    sum = input.get(start);
                }
            }
        }
        System.out.print(total);
    }
}