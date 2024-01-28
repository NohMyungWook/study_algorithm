import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static BigInteger K;
    static BigInteger[][] dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void makeDp() {
        dp = new BigInteger[N + 1][M + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], BigInteger.valueOf(1));
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                dp[i][j] = dp[i-1][j].add(dp[i][j - 1]);
            }
        }
    }

    static boolean isInDictionary(BigInteger k) {
        return dp[N][M].compareTo(k) >= 0;
    }

    static void recursive() {
        // 종료 조건
        if (N == 0) {
            for (int i = 0; i < M; i++) sb.append("z");
            return;
        }
        if (M == 0) {
            for (int i = 0; i < N; i++) sb.append("a");
            return;
        }

        // 위보다 작거나 같으면
        if (K.compareTo(dp[N - 1][M]) < 1) {
            // 위쪽 탐색
            sb.append("a");
            N--;
            recursive();
        }
        else {
            // 왼쪽 탐색
            sb.append("z");
            // k가 위의 경우의 수만큼 줄어야 함.
            K = K.subtract(dp[N - 1][M]);
            M--;
            recursive();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = new BigInteger(st.nextToken());

        arr = new int[N + M];

        makeDp();
        for (int i = 0; i < N; i++) arr[i] = 0;
        for (int i = N; i < N + M; i++) arr[i] = 1;

        if (isInDictionary(K)) {
            recursive();
            System.out.print(sb);
            System.exit(0);
        }
        System.out.print(-1);
    }
}