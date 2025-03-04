import java.util.*;
import java.io.*;

public class Main {
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = br.readLine();
        int x = 0, y = 0;
        int dir_num = 0;
        int time = 0;
        for(int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);

            if(ch == 'F'){
                x = x + dx[dir_num];
                y = y + dy[dir_num];
            }
            else if(ch == 'L'){
                dir_num = (dir_num + 3) % 4;
            }
            else if(ch == 'R'){
                dir_num = (dir_num + 1) % 4;
            }

            
            time += 1;
            // System.out.printf("X : %d Y: %d time: %d\n", x, y, time);
            if(x == 0 && y == 0){
                break;
            }

        }


        if(x == 0 && y == 0){
            System.out.print(time);
        }else{
            System.out.print("-1");
        }
    }
}