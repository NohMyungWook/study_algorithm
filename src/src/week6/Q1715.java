package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Long> input = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            input.add(Long.parseLong(br.readLine().trim()));
        }

        long sum;
        long accumulatedSum = 0;
        while(input.size() > 1) {
            sum = input.poll() + input.poll();
            accumulatedSum += sum;
            input.add(sum);
        }
        System.out.print(accumulatedSum);
    }
}
