package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1003 {
    public static void initCnt(List<Integer> cntList) {
        int sum ;
        for (int i = 2; i < 41; i++) {
            sum = cntList.get(i-1) + cntList.get(i-2);
            cntList.add(sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrList = new ArrayList<>();
        List<Integer> zeroCntList = new ArrayList<>(Arrays.asList(1, 0));
        List<Integer> oneCntList = new ArrayList<>(Arrays.asList(0, 1));

        initCnt(zeroCntList);
        initCnt(oneCntList);

        int testCnt = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testCnt; i++) {
            arrList.add(Integer.parseInt(br.readLine().trim()));
        }

        for (Integer n : arrList) {
            System.out.println(zeroCntList.get(n) + " " + oneCntList.get(n));
        }
    }
}
