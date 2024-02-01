import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCities = Integer.parseInt(br.readLine().trim());
        List<Integer> distance = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> money = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long min = Integer.MAX_VALUE;
        long sum = 0;
        for(int i = 1; i < numberOfCities; i++) {
            min = Math.min(min, money.get(i - 1));
            sum += distance.get(i - 1) * min;
        }
        System.out.print(sum);
    }
}