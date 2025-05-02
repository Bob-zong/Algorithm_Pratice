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

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!s.contains(num)){
                s.add(num);
                cnt++;
            }else{
                if(s.lower(num) != null && num - s.lower(num) > 1){
                    s.add(num-1);
                    cnt++;
                }
                else{
                    break;
                }
            }
                
            
        }       

        System.out.print(cnt);
    }
}