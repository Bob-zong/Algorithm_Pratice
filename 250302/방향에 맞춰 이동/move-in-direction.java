import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = new int[]{1,0,-1,0};
    public static int[] dy = new int[]{0,-1,0,1};

    public static int getDir(String dir){
        if(dir.equals("E"))
            return 0;
        else if(dir.equals("S"))
            return 1;
        else if(dir.equals("W"))
            return 2;
        else
            return 3;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int dir_num = 0;
        int nx = 0, ny = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            
            dir_num = getDir(dir);
            nx += dist * dx[dir_num];
            ny += dist * dy[dir_num];
        }

        System.out.print(nx + " " + ny);
    }
}