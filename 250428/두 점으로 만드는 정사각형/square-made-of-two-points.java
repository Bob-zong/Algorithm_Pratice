import java.util.*;
import java.io.*;

public class Main {
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

        int width = Math.max(x2, a2) - Math.min(x1, a1);
        int height = Math.max(y2, b2) - Math.min(y1, b1);

        int len = Math.max(width, height);

        System.out.print(len * len);
    }
}