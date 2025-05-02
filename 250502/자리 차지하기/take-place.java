import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> s = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= n; i++)
            s.add(i);

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            Integer seat = s.floor(num);
            if(seat != null){
                s.remove(num);
                cnt++;
            }
                
            else
                break;   
            
        }       

        System.out.print(cnt);
    }
}