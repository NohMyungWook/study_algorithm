import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean check(long mid, List<Long> line, int n) {
        long sum = 0;
        for (long i : line) {
            sum += (i / mid);
        }
        return sum >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> line = new ArrayList<>();
        long lo = 1, hi = Integer.MAX_VALUE + 1L;
        long mid;

        String[] first = br.readLine().trim().split(" ");

        int k = Integer.parseInt(first[0]); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(first[1]); // 필요한 랜선의 개수
        for (int i = 0; i < k; i++) {
            line.add(Long.parseLong(br.readLine().trim()));
        }

        while (lo + 1 < hi) {
            mid = lo + hi >> 1;
            if (check (mid, line, n)) lo = mid;
            else hi = mid;
        }
        System.out.print(lo);
    }
}