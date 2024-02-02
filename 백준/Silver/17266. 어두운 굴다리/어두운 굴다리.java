import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] x;
    static int MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        x = new int[M];

        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        MIN = Math.max(x[0], N - x[M - 1]);

        for (int i = 1; i < M; i++) {
            int dis = (x[i] - x[i - 1] + 1) / 2;
            MIN = Math.max(MIN, dis);
        }

        System.out.print(MIN);
    }
}