package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2805 {
    public static boolean check(int mid, List<Integer> trees, int m) {
        int sum = 0;
        for (int i : trees) {
            int cut;
            if (mid > i) {
                cut = i;
            }
            else cut = i - mid;
            sum += cut;
        }
        return sum >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> trees = new ArrayList<>();
        List<Integer> cuts = new ArrayList<>();
        int lo = 0, hi = 2000000000;

        String[] first = br.readLine().trim().split(" ");
        String[] second = br.readLine().trim().split(" ");

        int n = Integer.parseInt(first[0]); // 나무의 개수
        int m = Integer.parseInt(first[1]); // 가져갈 최소 m
        for (String s : second) {
            trees.add(Integer.parseInt(s));

        }
        while (lo + 1 < hi) {
            int mid = lo + hi >> 1;
            System.out.println(check(mid, trees, m));
            if (check(mid, trees, m)) lo = mid;
            else hi = mid;
        }

        System.out.println(lo);

    }
}
