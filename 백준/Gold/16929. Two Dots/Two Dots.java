import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static String[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int startX, startY;
    static boolean hasCycle = false;

    static void dfs(int x, int y, int cnt) {
        int nextX, nextY;
        //종료 조건
        if (hasCycle) return;
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            //만약 그래프의 범위를 벗어난다면
            //범위를 벗어나는 경우, continue
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            // 점 4개를 방문 하고 이후 처음 지점으로 돌아온다면
            if (cnt >= 4 && nextX == startX && nextY == startY) {
                hasCycle = true;
                return;
            }
            // 다음이 갈 수 있는 지점이고, 아직 방문하지 않았다면 방문
            if (Objects.equals(graph[nextX][nextY], graph[x][y]) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, cnt + 1);
                visited[nextX][nextY] = false;
            }

        }
    }

    static void initVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] input;

        graph = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            System.arraycopy(input, 0, graph[i], 0, M);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                initVisited();
                startX = i;
                startY = j;
                visited[i][j] = true;
                dfs(i, j, 1);
                if (hasCycle) {
                    System.out.print("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.print("No");
    }
}