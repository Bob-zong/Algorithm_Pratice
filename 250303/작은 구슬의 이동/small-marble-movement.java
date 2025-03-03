import java.util.*;
import java.io.*;

public class Main {
    public static int n , t;
    public static int nx, ny;
    public static int[][] answer;
    public static Map<String, Integer> map;

    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1 , 0};

    public static boolean inRange(int x, int y){
        return ( 1 <= x && x <= n && 1 <= y && y <= n);
    }

    public static void move(int x, int y, int t, String dir){
        nx = x; 
        ny = y;

        int dir_num = map.get(dir);
        while(t-- > 0){
                x = nx + dx[dir_num];
                y = ny + dy[dir_num];
                if(inRange(x,y)){
                    nx = x;
                    ny = y;
                }else{
                    dir_num = 3 - dir_num; 
                }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();

        map.put("U", 0);
        map.put("D", 3);
        map.put("R", 1);
        map.put("L", 2);


        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int row, col;

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        String dir = st.nextToken();

        move(row, col, t, dir);

        System.out.print(nx + " " + ny);


    }
}