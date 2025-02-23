import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    static final int MAX_NUM = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aLoc[] = new int [MAX_NUM + 1];
        int bLoc[] = new int[MAX_NUM + 1];
    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int timeA = 0;
        int aPos = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            while(time-- > 0){
                if(dir.equals("R")){
                    aLoc[++timeA] = ++aPos;
                    
                }else{
                    aLoc[++timeA] = --aPos;
                }
            }
        }

        int timeB = 0;
        int bPos = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            while(time-- > 0){
                if(dir.equals("R")){
                    bLoc[++timeB] = ++bPos;
                    
                }else{
                    bLoc[++timeB] = --bPos;
                }
            }
        }

        Arrays.fill(aLoc, timeA, MAX_NUM+1, aPos);
        Arrays.fill(bLoc, timeB, MAX_NUM+1, bPos);

        int cnt = 0;
        int maxTime = Math.max(timeA, timeB);
        int minTime = Math.min(timeA, timeB);

        for(int i = 1; i <= maxTime; i++){
            if(aLoc[i] == bLoc[i]){
                
                if(aLoc[i-1] != bLoc[i-1])
                    cnt +=1;           
            }
        }

        System.out.print(cnt);


    }
}