import java.util.*;
import java.io.*;

public class Main {
    public static boolean checkOverLap(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        
        // 1번째 사각형이 더 오른쪽 / 위에 있는 경우
        if(x2 < a1 || a2 < x1 || b2 < y1 || y2 < b1)
            return false;
        
        return true;
            
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1, y1, x2, y2;
        int a1, b1, a2, b2;

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
         
        st = new StringTokenizer(br.readLine());

        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());

        if(checkOverLap(x1, y1, x2, y2, a1, b1, a2, b2))
            System.out.print("overlapping");
        else
            System.out.print("nonoverlapping");
    }
}