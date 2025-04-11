import java.util.*;
import java.io.*;

public class Main {
    // 각 시간에 위치를 저장해놓자
    // 1 ~ 1000까지 각 시간에서 위치가 더 큰 친구를 명예의 전당에 올려
    // 누가 더 멀리 있는지 비교 -> O(1)
    public static int[] aPos;
    public static int[] bPos;

    public static int n, m;
    public static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        cnt = 0;

        int aCurrTime = 1;
        int aCurrPos = 0;
        int bCurrTime = 1;
        int bCurrPos = 0;

        aPos = new int[1000001];
        bPos = new int[1000001];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = aCurrTime; j < aCurrTime + t; j++){
                aPos[j] = aCurrPos + v;
                aCurrPos += v;
            }

            aCurrTime += t;
        }    

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = bCurrTime; j < bCurrTime + t; j++){
                bPos[j] = bCurrPos + v;
                bCurrPos += v;
            }

            bCurrTime += t;
        }    

        int currHead = -1;

        for(int i = 1; i <= 1000; i++){
            int head = 0;

            if(aPos[i] > bPos[i]){
                 head = 1;
            }
            else if(aPos[i] < bPos[i]){
                head = 2;
            }
            else if(aPos[i] == bPos[i]){
                 head = 3;
            }

            if(currHead != head && aPos[i] != 0){
                cnt += 1;
                currHead = head;
            }
                
        }

        System.out.print(cnt);

    }
}