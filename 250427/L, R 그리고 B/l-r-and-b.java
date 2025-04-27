import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[][] answer = new char[10][10];
        int Lrow = 0, Lcol = 0, Rrow = 0, Rcol = 0, Brow = 0, Bcol = 0;

        for(int i = 0; i < 10; i++){
            String str = br.readLine();
            for(int j = 0; j < 10; j++){
                answer[i][j] = str.charAt(j);
                if(answer[i][j] == 'B'){
                    Brow = i;
                    Bcol = j;
                }
                if(answer[i][j] == 'R'){
                    Rrow = i;
                    Rcol = j;
                }

                if(answer[i][j] == 'L'){
                    Lrow = i;
                    Lcol = j;
                }
            }
        }        
        int len = 0;
        // System.out.printf("%d %d %d %d %d %d",Lrow , Lcol , Rrow , Rcol , Brow , Bcol);
        if(((Brow == Rrow && Rrow == Lrow) || (Bcol == Rcol && Rcol == Lcol)) &&
            (
            ((Rrow < Brow && Rrow > Lrow) || (Rrow < Lrow && Rrow > Brow)) 
            ||
            ((Rcol < Bcol && Rcol > Lcol) || (Rcol < Lcol && Rcol > Bcol))    
            )
         ){
            len = Math.abs(Lrow-Brow) + Math.abs(Lcol-Bcol) - 1;
            len += 2;     
        }else{
            len = Math.abs(Lrow-Brow) + Math.abs(Lcol-Bcol) - 1;
        }
        System.out.print(len);
    }
}