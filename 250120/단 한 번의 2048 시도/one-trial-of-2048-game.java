import java.util.*;
import java.io.*;

public class Main {
    public static int[][] answer = new int[4][4];
    // public static int[] dx = new int[]{1, 0, -1 ,0};
    // public static int[] dy = new int[]{0, 1, 0, -1};

    public static int getDirNum(char dir){
        if(dir == 'D')
            return 0;
        else if(dir == 'R')
            return 1;
        else if(dir == 'U')
            return 2;
        else
            return 3;
    }

    public static void moveArr(int dirNum){
        //아래로 미는 경우
        if(dirNum == 0){
            for(int j = 0; j < 4; j++){
                for(int i = 2; i >= 0; i--){
                    if(answer[i+1][j] == 0){
                        answer[i+1][j] = answer[i][j];
                        answer[i][j] = 0;
                    }
                }
            }
        }
        // 오른쪽으로 미는 경우
        else if(dirNum == 1){
            for(int i = 0; i < 4; i++){
                for(int j = 2; j >= 0; j--){
                    if(answer[i][j+1] == 0){
                        answer[i][j+1] = answer[i][j];
                        answer[i][j] = 0;
                    }
                }
            }
        }//위로 미는 경우
        else if(dirNum == 2){
            for(int j = 0; j < 4; j++){
                for(int i = 1; i < 4; i++){
                    if(answer[i-1][j] == 0){
                        answer[i-1][j] = answer[i][j];
                        answer[i][j] = 0;
                    }
                }
            }
        }//왼쪽으로 미는 경우
        else{
            for(int i = 0; i < 4; i++){
                for(int j = 1; j < 4; j++){
                    if(answer[i][j-1] == 0){
                        answer[i][j-1] = answer[i][j];
                        answer[i][j] = 0;
                    }
                }
            }
        }

    }
    public static void mergeArr(int dirNum){
        //아래로 
        if(dirNum == 0){
            for(int j = 0; j < 4; j++){
                for(int i = 2; i >= 0; i--){
                    if(answer[i+1][j] == answer[i][j]){
                        answer[i+1][j] = answer[i][j] * 2;
                        answer[i][j] = 0;
                    }
                }
            }
        }
        // 오른쪽
        else if(dirNum == 1){
            for(int i = 0; i < 4; i++){
                for(int j = 2; j >= 0; j--){
                    if(answer[i][j+1] == answer[i][j]){
                        answer[i][j+1] = answer[i][j] * 2;
                        answer[i][j] = 0;
                    }
                }
            }
        }//위로
        else if(dirNum == 2){
            for(int j = 0; j < 4; j++){
                for(int i = 1; i < 4; i++){
                    if(answer[i-1][j] == answer[i][j]){
                        answer[i-1][j] = answer[i][j] * 2;
                        answer[i][j] = 0;
                    }
                }
            }
        }//왼쪽
        else{
            for(int i = 0; i < 4; i++){
                for(int j = 1; j < 4; j++){
                    if(answer[i][j-1] == answer[i][j]){
                        answer[i][j-1] = answer[i][j] * 2;
                        answer[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        char dir;

        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                answer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dir = br.readLine().charAt(0);
        int dirNum = getDirNum(dir);
        
        moveArr(dirNum);
        mergeArr(dirNum);
        moveArr(dirNum);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                bw.write(String.valueOf(answer[i][j] + " "));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
}