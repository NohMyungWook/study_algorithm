import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int SIZE = 201;

        long[][] dp = new long[SIZE][SIZE];
        int mod = 1000000000;

        // 2차원 배열 전부 1로 채우기
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(dp[i], 1L);
        }

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j - 1]) % mod;
            }
        }

        System.out.println(dp[numbers.get(0)][numbers.get(1)-1]);
    }
}