import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        if (n == 1) {
            System.out.print(1);
        }
        else if( n == 2) {
            System.out.println(1);
        }
        else {
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.print(dp[n - 1]);
        }
    }
}
