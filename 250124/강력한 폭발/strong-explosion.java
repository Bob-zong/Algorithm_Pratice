import java.util.*;
import java.io.*;

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    // public static ArrayList<Integer>
    public static int[][] answer;
    public static int[][] boom;
    public static int boomCnt;
    public static ArrayList<Pair> booms = new ArrayList<>();
    public static int boomedMax = 0;
    
    public static boolean inRange(int x, int y){
        return ( 0 <= x && x < n && 0 <= y && y < n);
    }

    //2번 폭탄 dx, dy
    public static int[] dx2 = new int[]{-1, 0, 1, 0};
    public static int[] dy2 = new int[]{0, 1, 0, -1};

    //3번 폭탄 dx, dy
    public static int[] dx3 = new int[]{-1, 1, 1, -1};
    public static int[] dy3 = new int[]{1, 1, -1, -1};

    public static void simulate(int type, int x, int y, int boomType){
        boom[x][y] += boomType;

        switch(type){
            
            case 1 :
                for(int i = x-2; i <= x+2; i++){
                    if(inRange(i, y))
                        boom[i][y] += boomType;
                }
                break;
            
            case 2 :
                for(int i = 0; i < 4; i++){
                    int nx = x + dx2[i];
                    int ny = y + dy2[i];
                    if(inRange(nx, ny))
                        boom[nx][ny] += boomType;
                }
                break;
            
            case 3:
                for(int i = 0; i < 4; i++){
                    int nx = x + dx3[i];
                    int ny = y + dy3[i];
                    if(inRange(nx, ny))
                        boom[nx][ny] += boomType;
                }
                break;

        }
    }

    public static void choose(int currNum){
        if(currNum == boomCnt){
            int boomedCnt = count();
            boomedMax = Math.max(boomedMax, boomedCnt);
            return;
        }

        Pair curr = booms.get(currNum);
        for(int i = 1; i <= 3; i++){
            simulate(i, curr.x, curr.y, 1);
            choose(currNum+1);
            simulate(i, curr.x, curr.y, -1);
        }
    }
    
    public static int count(){
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(boom[i][j] > 0)
                    sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        answer = new int[n][n];
        boom = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int input = Integer.parseInt(st.nextToken());
                answer[i][j] = input;
                if(input == 1)
                    booms.add(new Pair(i,j));
            }
        }
        
        boomCnt = booms.size();
        choose(0);
        System.out.print(boomedMax);


    }
}