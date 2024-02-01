import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        List<Integer> arrList = new ArrayList<>();

        for(int i=0; i < 9; i++){
            arrList.add(Integer.parseInt(br.readLine()));
            sum += arrList.get(i);
        }

        boolean flag = false;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum- arrList.get(i)-arrList.get(j) == 100){
                    arrList.set(i, -1);
                    arrList.set(j, -1);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Collections.sort(arrList);

        for (int i = 2; i < arrList.size(); i++ ) {
            System.out.println(arrList.get(i));
        }
    }
}