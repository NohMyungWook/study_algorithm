import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNAndK = br.readLine().trim().split(" ");
        int N = Integer.parseInt(inputNAndK[0]);
        int K = Integer.parseInt(inputNAndK[1]);
        int second;

        //선제 조건
        if (N > K) {
            System.out.print(N - K);
        }
        else if (N == K) {
            System.out.print(0);
        }
        else {
            second = getSecond(N, K);
            System.out.print(second);
        }
    }

    public static int getSecond(int n, int k) {
        int second = 0;
        List <Integer> checkList = new ArrayList<>();
        boolean[] isVisited = new boolean[100001];
        Arrays.fill(isVisited, false);
        checkList.add(n);

        while (true) {
            second++;
            int size = checkList.size();
            for (int i = 0; i < size; i ++) {
                int nowValue = checkList.get(0);
                isVisited[nowValue] = true;
                // 3갈래 중 값이 존재하면 탈출
                if (nowValue - 1 == k || nowValue + 1 == k || nowValue * 2 == k) {
                    return second;
                }

                if (nowValue - 1 >= 0 && !isVisited[nowValue - 1]) {
                    isVisited[nowValue - 1] = true;
                    checkList.add(nowValue - 1);
                }
                if (nowValue + 1 <= 100000 && !isVisited[nowValue + 1] ) {
                    isVisited[nowValue + 1] = true;
                    checkList.add(nowValue + 1);
                }
                if (nowValue * 2 <= 100000 && !isVisited[nowValue * 2] ) {
                    isVisited[nowValue * 2] = true;
                    checkList.add(nowValue * 2);
                }
                checkList.remove(0);
            }
        }
    }
}