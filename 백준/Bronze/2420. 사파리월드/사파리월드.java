import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(br.readLine().trim().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(Math.abs(input[0] - input[1]));
    }
}