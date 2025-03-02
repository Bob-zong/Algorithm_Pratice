import java.util.*;
import java.io.*;

public class Main {
    public static int dir_num = 0;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static int[] dir = new int[]{0, 1, 2, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        // System.out.println(st.countTokens());
        // while (tokenizer.hasMoreTokens()) {
        //     String token = tokenizer.nextToken();
        //     System.out.println(token);
        // }
        char[] arr = str.toCharArray();
        int x = 0, y = 0;
        for(char ch : arr){
            if(ch == 'L')
                dir_num = (dir_num + 3) % 4;
            else if(ch == 'R')
                dir_num = (dir_num + 1) % 4;
            else{
                x += dx[dir_num];
                y += dy[dir_num];
            }
        }

        
        // while(st.hasMoreTokens()){
        //     System.out.println("1");
        //     String str = st.nextToken();
        //     if(str.equals("L"))
        //         dir_num = (dir_num + 3) % 4;
        //     else if(str.equals("R"))
        //         dir_num = (dir_num + 1) % 4;
        //     else{
        //         x += dx[dir_num];
        //         y += dy[dir_num];
        //     }
        // }
        System.out.printf("%d %d", x, y);
        
    }
}