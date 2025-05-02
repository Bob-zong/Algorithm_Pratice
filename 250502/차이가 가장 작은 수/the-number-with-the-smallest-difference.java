import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            s.add(num);
            
            Integer nextValue = s.higher(num);
            Integer prevValue = s.lower(num);

            if(nextValue != null) {
                int diff = nextValue - num;
                if(diff < minDiff && diff >= m)
                    minDiff = diff; 
            }

            if(prevValue != null) {
                int diff = Math.abs(prevValue - num);
                // System.out.println(diff);
                if(diff < minDiff && diff >= m)
                    minDiff = diff; 
            }
        }
        if(minDiff != Integer.MAX_VALUE)
            System.out.print(minDiff);
        else
            System.out.print(-1);
        
    }
}