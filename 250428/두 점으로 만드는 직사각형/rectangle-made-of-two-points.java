import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] line1 = new int[4];
        int[] line2 = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
           line1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            line2[i] = Integer.parseInt(st.nextToken());
        
        int minX, minY, maxX, maxY;

        minX = Math.min(line1[0], line2[0]);
        minY = Math.min(line1[1], line2[1]);
        maxX = Math.max(line1[2], line2[2]);
        maxY = Math.max(line1[3], line2[3]);
        int area = ((maxX - minX) * (maxY - minY));
        System.out.print(area);
    }
}