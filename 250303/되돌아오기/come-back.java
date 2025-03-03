import java.util.*;
import java.io.*;

public class Main {
    public static int n, time, currX, currY;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static Map<String, Integer> map;
    public static int[][] answer;

    public static boolean check(int x, int y){
        if(x == 0 && y == 0)
            return true;
        return false;
    }

    public static boolean move(int x, int y, int dir_num, int dist){
        for(int i = 0; i < dist; i++){
            currX = currX + dx[dir_num];
            currY = currY + dy[dir_num];
            time += 1;

            if(check(currX, currY)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        time = 0;
        answer = new int[1000][1000];

        map = new HashMap<>();
        map.put("E", 0);
        map.put("S", 1);
        map.put("W", 2);
        map.put("N", 3);

        n = Integer.parseInt(br.readLine());
        currX = 0;
        currY = 0;
        int ans = 0;
        boolean condition = false;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int dir_num = map.get(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(move(currX, currY, dir_num, dist)){
                condition = true;
                break;
            }
        }
        
        if(condition){
            System.out.print(time);
        }
        else{
            System.out.print("-1");
        }
    }
}