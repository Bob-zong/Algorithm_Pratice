import java.util.*;
import java.io.*;
class Time implements Comparable<Time> {
    int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Time t){
        return this.end - t.end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Time> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer.add(new Time(s, e));
        }

        Collections.sort(answer);

        int ans = 1;
        int curTime = answer.get(0).end;
        for(int i = 1; i < n; i++){
            if(answer.get(i).start >= curTime) {
                ans += 1;
                curTime = answer.get(i).end;
            }
        }

        System.out.print(ans);
    }
}