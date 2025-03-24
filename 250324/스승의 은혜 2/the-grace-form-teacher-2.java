import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int stuCost[] = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            stuCost[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stuCost);
        
        for(int i = 0; i < n; i++){
            stuCost[i] /= 2;
            int sum = 0;
            int stuNum = 0;

            for(int j = 0; j < n; j++){
                sum += stuCost[j];
                if(sum > money){
                    break;
                }
                stuNum = j+1;
                // System.out.println("stuNum: " + stuNum + " " + j);
            }
            stuCost[i] *= 2;
            max = Math.max(max,stuNum);
        }
        
        System.out.print(max);
    }
}