import java.util.*;
import java.io.*;

public class Main {
    public static int n , m;
    public static int[][] answer;
    public static int MaxScore;
    public static void simulation(){
        MaxScore = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                for(int x = i; x < n; x++){
                    for(int y = j; y < m; y++){
                        MaxScore = Math.max(MaxScore, getScore(i, j, x, y));
                    }
                }
            }
        }
    }

    public static int getScore(int x1, int y1, int x2, int y2){
        int area1 = getArea(x1, y1, x2, y2);
        int sumMax = Integer.MIN_VALUE;
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int x = i; x < n; x++){
                    for(int y = j; y < m; y++){
                        if(!overlapped(x1, y1, x2, y2, i, j, x, y)){
                            sumMax = Math.max(sumMax, area1 + getArea(i, j, x, y));
                        }
                    }
                }
            }
        }

        return sumMax;
    }

    public static int getArea(int x1, int y1, int x2, int y2){
        int sum = 0;

        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                sum += answer[x][y];
            }
        }

        return sum;
    }

    public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        boolean[][] visited = new boolean[n][m];
        for (int k=x1; k<=x2; k++) {
            for (int l=y1; l<=y2; l++) {
                visited[k][l] = true;
            }
        }

        for (int k=x3; k<=x4; k++) {
            for (int l=y3; l<=y4; l++) {
                if (visited[k][l]) return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        System.out.print(MaxScore);
        
    }
}