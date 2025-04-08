import java.util.*;
import java.io.*;

public class Main {
    // 최대 10이니까 1~10번 shift 할 때 각 길이를 구해보는거임
    // 10 * for(int i = 1; i < len; i++){}
    // if(str[i] != str[i-1])
    public static char[] charArr;
    public static String str;

    public static void shift() {
        int len = charArr.length;

        char temp = charArr[len-1];

        for(int i = len-1; i > 0; i--)
            charArr[i] = charArr[i-1];
        
        charArr[0] = temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int minScale = Integer.MAX_VALUE;

        str = br.readLine();
        charArr = str.toCharArray();
        
        int len = str.length();


        for(int k = 0; k < len; k++){
            shift();
            char currCh = charArr[0];
            int cnt = 0;
            for(int i = 0; i < len; i++){
                if(currCh == charArr[i]){
                    cnt += 1;
                }
                else{
                    sb.append(currCh).append(cnt);
                    currCh = charArr[i];
                    cnt = 1;
                }
        }

            
                sb.append(currCh).append(cnt);
            

            minScale = Math.min(minScale, sb.length());
            // System.out.println("크기: " + minScale + " " + sb);
            sb.delete(0, sb.length());
        }
        

        System.out.print(minScale);
        



    }
}