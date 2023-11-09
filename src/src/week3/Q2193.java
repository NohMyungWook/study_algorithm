package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Integer> intArr = new ArrayList<>(n);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max, answer = 0;

        String[] input = br.readLine().trim().split(" ");
        for (String s : input) {
            intArr.add(Integer.parseInt(s));
        }

        for (int i = 0; i < n; i++) {
            max = 1;
            for (int j = i-1; j >= 0; j--) {
                if (intArr.get(j) < intArr.get(i)) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        for (int i : dp) {
            answer = Math.max(answer, i);
        }
        System.out.print(answer);
    }
}
