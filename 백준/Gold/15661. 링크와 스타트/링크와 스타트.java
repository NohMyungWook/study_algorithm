import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visit;
    public static int N;
    public static int min = Integer.MAX_VALUE;
    public static int[][] data;

    public static void main(String[] args) throws IOException {
        // 입력란
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // data 변환 과정 : data를 중앙 대각선 기준으로 대칭되게 합친다.
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                data[i][j] = data[i][j] + data[j][i];
            }
        }
        
        makeTeam(0);
        System.out.print(min);
    }

    public static void makeTeam(int check) {
        if (check == N) {
            getSum();
            return;
        }

        visit[check] = true;
        makeTeam(check + 1);
        visit[check] = false;
        makeTeam(check + 1);
    }

    public static void getSum() {
        int linkTeamSum = 0;
        int startTeamSum = 0;

        //get linkTeamSum
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (visit[i] && visit[j]) {
                    startTeamSum += data[i][j];
                }
                else if(!visit[i] && !visit[j]) {
                    linkTeamSum += data[i][j];
                }
            }
        }

        min = Math.min(Math.abs(startTeamSum - linkTeamSum), min);

        if (min == 0) {
            System.out.print(0);
            System.exit(0);
        }
    }
}