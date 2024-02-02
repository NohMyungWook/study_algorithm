import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] input;

    static void swap(int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    static boolean next_permutation() {
        int i = N - 1;
        while (i > 0 && input[i - 1] <= input[i]) i--;
        if (i <= 0) return false;
        int j = N - 1;
        while (j >= 0 && input[j] >= input[i - 1]) j--;
        swap(i - 1, j);
        j = N - 1;
        while (i < j) {
            swap(i++, j--);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (next_permutation()) {
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(input[i]).append(" ");
            }
        }
        else {
            sb.append(-1);
        }
        System.out.print(sb);
    }
}