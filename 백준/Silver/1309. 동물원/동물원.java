import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void init(List<Integer> cntList) {
        int sum ;
        for (int i = 2; i < 100001; i++) {
            sum = cntList.get(i-1) * 2 + cntList.get(i-2);
            cntList.add(sum % 9901);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> cache = new ArrayList<>(Arrays.asList(3, 7));

        init(cache);

        int number = Integer.parseInt(br.readLine().trim());
        System.out.println(cache.get(number-1));
    }
}
