import java.util.*;
import java.io.*;
class Meteeing implements Comparable <Meteeing> {
    int s, e;

    public Meteeing(int s, int e){
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meteeing m) {
        if(this.e != m.e) {
            return this.e - m.e;
        }else{
            return this.s - m.s;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Meteeing[] answer = new Meteeing[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            answer[i] = new Meteeing(s, e);
        }

        Arrays.sort(answer); 

        int currTime = -1;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(currTime <= answer[i].s ){
                currTime = answer[i].e;
                ans++;
            }
        }

        System.out.print(n-ans);
    }
}