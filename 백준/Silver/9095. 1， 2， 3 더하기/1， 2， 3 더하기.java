import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void init(List<Integer> cntList) {
        int sum ;
        for (int i = 3; i < 12; i++) {
            sum = cntList.get(i-1) + cntList.get(i-2) + cntList.get(i-3);
            cntList.add(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrList = new ArrayList<>();
        List<Integer> cache = new ArrayList<>(Arrays.asList(1, 2, 4));

        init(cache);

        int testCnt = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testCnt; i++) {
            arrList.add(Integer.parseInt(br.readLine().trim()));
        }

        for (Integer n : arrList) {
            System.out.println(cache.get(n-1));
        }
    }
}
