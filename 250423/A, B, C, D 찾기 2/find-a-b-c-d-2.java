import java.util.*;
import java.io.*;

public class Main {
    public static int[] answer;
    public static int a, b, c, d;

    public static boolean checkValue() {
        int[] tempArr = new int[]{a, b, c, d, a+b, b+c, c+d, d+a, a+c, b+d,a+b+c,a+b+d, a+c+d, b+c+d, a+b+c+d};
        Arrays.sort(tempArr);
        for(int i = 0; i < 15; i++){
            if(tempArr[i] != answer[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[15];

        for(int i = 0; i < 15; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }    

        Arrays.sort(answer);
        a = answer[0];
        b = answer[1];

        for(int i = b; i <= 40; i++){
            for(int j = b; j <= 40; j++){
                c = i;
                d = j;
                if(checkValue()){
                    System.out.printf("%d %d %d %d", a,b,c,d);
                    System.exit(0);
                }
            }
        }


    }
}