import java.util.*;
import java.io.*;

public class Main {
    // while로 n/2 까지 돌리면서 길이를 찾는다.
    // for 1 ~ n 까지 돌리면서 똑같은 문자열이 있는지 찾는다.
    // 
    public static final int MAXNUM = Integer.MAX_VALUE;

    public static int n;
    public static char[] answer;
    public static int minLength;
    public static List<Character> charList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        minLength = MAXNUM;

        answer = new char[n];

        String str = br.readLine();

        answer = str.toCharArray();

        charList = new ArrayList<>();

        for(char c : answer)
            charList.add(c);
        int ans = 0;

        for(int i = 1; i < n; i++){ // 길이가 1 ~ n 까지
            boolean twice = false;

            for(int j = 0; j <= n - i; j++){
                for(int k = j + 1; k <= n-i; k++){
                    boolean isSame = false;

                    if(str.substring(j, j+i).equals(str.substring(k, k+i)))
                        isSame = true;
                    if(isSame)
                        twice = true;

                }
                
                
            }

            if(twice)
                ans = i+1;
        }
        System.out.print(ans);

        
    }
}