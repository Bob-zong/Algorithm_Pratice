import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x, v;

    public Point(int x, int v) {
        this.x = x;
        this.v = v;
        
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Point> p = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();
        
        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int currX = 0;
        int currDir = 1;
        

        // O(n);
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            if(dir == 'R')
                currDir = 1;
            else
                currDir = -1;
            
            
            int startX, endX;

            startX = currX;
            endX = startX + currDir * x;

            if(endX < startX){
                p.add(new Point(startX, -1));
                p.add(new Point(endX, +1));     
            }
            else{
                p.add(new Point(startX, +1));
                p.add(new Point(endX, -1));   
            }
                     
            
            currX = endX;
        }

        // O(N * logN);
        Collections.sort(p);

        int sum = 0;
        int ans = 0;
        for(int i = 0; i < 2 * n; i++) {
            int x = p.get(i).x;
            int v = p.get(i).v;

            sum += v;
            // System.out.println(sum);
            if(sum >= k)
                ans += 1;
        }

        
        System.out.print(ans);

    }
}