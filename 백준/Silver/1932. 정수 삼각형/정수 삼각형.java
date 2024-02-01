import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrList = new ArrayList<>();
        int a, b;

        int n = Integer.parseInt(br.readLine().trim());
        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (String s : input) {
                arrList.add(Integer.parseInt(s));
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                cache[i][j] = arrList.get(cnt);
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                continue;
            }
            if (i == 1){
                cache[i][0] = cache[0][0] + cache[i][0];
                cache[i][1] = cache[0][0] + cache[i][1];
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    cache[i][j] = cache[i-1][j] + cache[i][j];
                    continue;
                }
                if (j == i) {
                    cache[i][j] = cache[i-1][j-1] + cache[i][j];
                    continue;
                }
                a = cache[i-1][j] + cache[i][j];
                b = cache[i-1][j-1] + cache[i][j];
                cache[i][j] = Math.max(a, b);
            }
        }
        int max = cache[n-1][0];
        for (int i = 1; i < cache.length; i++) {
            max = Math.max(max, cache[n-1][i]);
        }
        System.out.print(max);
    }
}