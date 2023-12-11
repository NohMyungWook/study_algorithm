package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int share, sum = 0;

        List<Integer> moneys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            moneys.add(Integer.parseInt(br.readLine()));
        }

        for (int i = moneys.size() - 1; i >= 0; i--) {
            if (k / moneys.get(i) == 0)
                continue;
            share = k / moneys.get(i);
            k -= share * moneys.get(i);
            sum += share;
        }

        System.out.print(sum);
    }
}
