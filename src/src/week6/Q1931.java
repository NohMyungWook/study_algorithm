package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputN = br.readLine().trim();
        int n = Integer.parseInt(inputN);

        int[][] arr = new int[n][2];
        int count = 0;

        String[] input;

        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        //sort
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int finishTime = 0;

        for (int i = 0; i < n; i++) {
            int startTime = arr[i][0];
            if (finishTime <= startTime) {
                finishTime = arr[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}
