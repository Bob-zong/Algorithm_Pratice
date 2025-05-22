import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String f = br.readLine();
        String s = br.readLine();

        char[] ff = f.toCharArray();
        char[] ss = s.toCharArray();

        int[] arr = new int[ff.length];

        int ans = 0;

        //arr이 0이면 다르다, 1이면 같다

        if(ff[0] != ss[0]){
            arr[0] = 0;
            ans++;
        }
        else{
            arr[0] = 1;
        }

        for(int i = 1;i<ff.length;i++){
            if(ff[i] == ss[i]){
                arr[i] = 1;
            }
            else{
                if(arr[i-1] == 1) ans++;
            }

           // System.out.println(ff.length);

        }

        System.out.println(ans);

    }
}
출처: https://ethereal-coder.tistory.com/162 [잔디는 개발잔디:티스토리]