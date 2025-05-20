import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] answer = new Integer[n];

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(answer, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String s1 = Integer.toString(a) + Integer.toString(b);
                String s2 = Integer.toString(b) + Integer.toString(a);

                return s2.compareTo(s1);
            }
        });
        
        
        for(int i = 0; i < n; i++){
            System.out.print(answer[i]);
        }


    }
}