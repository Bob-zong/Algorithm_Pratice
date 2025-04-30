import java.util.*;
import java.io.*;

public class Main {
    public static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[] aArr = new int[a];
        int[] bArr = new int[b];
        HashSet<Integer> aSet = new HashSet<>();
        // HashSet<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
            aSet.add(aArr[i]);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }


        int ans = a + b;
        for(int i = 0; i < b; i++){
            if(aSet.contains(bArr[i]))
                ans -= 2;
        }

        System.out.print(ans);


        
    }
}