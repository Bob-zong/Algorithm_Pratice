import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        
        
        int n1 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n1; i++)
            hs1.add(Integer.parseInt(st.nextToken()));
        
        int n2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[n2];

        for(int i = 0; i < n2; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        // boolean notExist = false;

        for(int i = 0; i < n2; i++){
            if(!hs1.contains(arr2[i]))
                System.out.print("0 ");
            else
                System.out.print("1 ");
        }



        
        
    }
}