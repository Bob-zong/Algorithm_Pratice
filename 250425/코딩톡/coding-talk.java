import java.util.*;
import java.io.*;

public class Main {
    // 읽음 처리를 해버려?
    public static final int MAX_M = 100;
    public static int n, m, p;
    public static int[] u = new int[MAX_M];
    public static char[] c = new char[MAX_M];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 명령 수 
        p = Integer.parseInt(st.nextToken()); // 확인이 필요한 메세지 번호

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            c[i] = st.nextToken().charAt(0);
            u[i] = Integer.parseInt(st.nextToken());
        }
        
        if(u[p-1] == 0)
            System.exit(0);
        
        // 각각의 사람에 대해서 채팅을 읽었는지 파악해보자
        for(int i = 0; i < n; i++){
            char person = (char)((int)'A' + i); //A부터 찾아보자
            boolean read = false;

            for(int j = 0; j < m; j++){
                if(j >= p-1 && c[j] == person)
                    read = true;
            }

            if(read == false)
                System.out.print(person + " ");
        }


    }
}