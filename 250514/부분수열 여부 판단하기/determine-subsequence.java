import java.util.*;
import java.io.*;

public class Main {
    public static int[] A;
    public static int[] B;
    public static int aLen, bLen;

    public static boolean isSubSequence() {
        int i = 1;
        // B의 원소를 기준으로
        // 순서대로 매칭이 가능한지를 확인합니다.
        for(int j = 1; j <= bLen; j++) {
            // A의 원소가 B의 j번째 원소와
            // 일치해지는 위치를 구해줍니다.
            while(i <= aLen && A[i] != B[j])
                i++;
            
            // 만약 수열 A에서 일치하는 원소를 찾지 못햇다면
            // 부분수열이 아닙니다.
            if(i == aLen + 1)
                return false;
            // 일치한다면
            // A 원소의 위치도 한칸 앞으로 이동시켜 줍니다.
            else
                i++;
        }
    
        // 전부 매칭하는게 가능했다면
        // 부분수열입니다.
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        aLen = Integer.parseInt(st.nextToken());
        bLen = Integer.parseInt(st.nextToken());

        A = new int[aLen+1];
        B = new int[bLen+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= aLen; i++)
            A[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= bLen; i++)
            B[i] = Integer.parseInt(st.nextToken());


        if(isSubSequence())
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}