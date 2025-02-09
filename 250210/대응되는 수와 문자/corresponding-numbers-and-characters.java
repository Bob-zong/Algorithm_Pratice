import java.util.*;
import java.io.*;

public class Main {
    public static int n, m; 
    public static Map<String, String> map;
    public static String answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 문자열 입력 수
        m = Integer.parseInt(st.nextToken()); // 출력할 횟수

        map = new HashMap<>();
        answer = new String[n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            answer[i] = str;
            // int num = Integer.parseInt(st.nextToken());
            map.put(str, String.valueOf(i));
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(map.containsKey(str)){
                sb.append(map.get(str)).append("\n");  
            }
            else{
                int idx = Integer.parseInt(str);
                sb.append(answer[idx]).append("\n");
            }
        }
        System.out.print(sb);


    }
}

// c c -> 3 c