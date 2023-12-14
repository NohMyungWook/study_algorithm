package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        String[] input;

        // 데드라인의 오름차순으로 정렬한다.
        PriorityQueue <int[]> data = new PriorityQueue<>(
                Comparator.comparingInt((int[] o) -> o[0])
        );

        PriorityQueue <Integer> answer = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            data.add(Arrays.stream(input).mapToInt(Integer::parseInt).toArray());
        }

        int[] temp;
        while (!data.isEmpty()) {
            temp = data.poll();
            answer.add(temp[1]);

            if (answer.size() > temp[0]) {
                answer.poll();
            }
        }

        System.out.print(answer.stream()
                .mapToInt(Integer::intValue)
                .sum()
        );
    }
}
