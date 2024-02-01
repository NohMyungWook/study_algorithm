import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] cache = new int[1001][10001];

    public static int bino(int n, int k) {
        if (k == 0 || n == k) return 1;

        if (cache[n][k] != -1) return cache[n][k] % 10007;

        return cache[n][k] = bino(n - 1, k - 1) % 10007 + bino(n - 1, k) % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        for (int i = 0; i< 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                cache[i][j] = -1;
            }
        }

        System.out.print(bino(n, k) % 10007);
    }
}
