import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] originStr = br.readLine().toCharArray();
        char[] targetStr = br.readLine().toCharArray();

        int cnt = 0;
        int len = originStr.length;

        for(int i = len-1; i >= 0; i--){

            if(originStr[i] != targetStr[i]){
                cnt++;
                for(int j = i; j >= 0; j--){
                    if(originStr[j] == 'H'){
                        originStr[j] = 'G';
                    }else originStr[j] = 'H';
                }
            }
        }
        System.out.print(cnt);
    }
}