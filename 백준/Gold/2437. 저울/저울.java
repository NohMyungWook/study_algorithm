import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, sum;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[N + 1];

        input[N] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        if (input[0] > 1) {
            System.out.print(1);
            System.exit(0);
        }

        for (int i = 0; i < N; i++) {
            sum += input[i];
            if (sum + 1 < input[i+1]) {
                System.out.print(sum + 1);
                System.exit(0);
            }
        }
    }
}