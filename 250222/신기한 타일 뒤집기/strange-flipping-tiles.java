import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int currIdx = 0;
        int lastIdx = 0;
        int firstIdx = 0;
        String str = " ";

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int tileNum = Integer.parseInt(st.nextToken()) -1;
            str = st.nextToken();
            
            if(str.equals("R")){
                currIdx += (tileNum);
            }
            else{
                currIdx -= tileNum;

            }

            lastIdx = Math.max(lastIdx, currIdx);   
            firstIdx = Math.min(firstIdx, currIdx);
        }

        if(str.equals("R")){
            System.out.printf("%d %d", lastIdx - currIdx, currIdx - firstIdx +1);
        }else{
            System.out.printf("%d %d", lastIdx - currIdx+1, currIdx - firstIdx);
        }
        

    }
}
