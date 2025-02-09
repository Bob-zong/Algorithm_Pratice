import java.util.*;
import java.io.*;

public class Main {
    public static int n, m; 
    public static Map<String, Integer> map;
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
            // int num = Integer.parseInt(st.nextToken());
            map.put(str, i);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            for (Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            
            if(str.equals(key)){
                sb.append(map.get(key)).append("\n");
            }
            
            if(str.equals(String.valueOf(value))){
                sb.append(key).append("\n");
            }
        }
        }

        // for(int i = 0; i < m; i++){
        //     st = new StringTokenizer(br.readLine());
        //     String str = st.nextToken();
        //     if(map.containsKey(str)){
        //         sb.append(map.get(str)).append("\n");  
        //     }
        //     else{
        //         int idx = Integer.parseInt(str);
        //         sb.append(answer[idx]).append("\n");
        //     }
        // }
        System.out.print(sb);


    }
}

// c c -> 3 c
// for (Map.Entry<String, Integer> entry : grade.entrySet()) {
//             String key = entry.getKey();
//             Integer value = entry.getValue();
            
//             if (value == 90) {
//                 System.out.println("90점을 맞은 학생은 : " + key);
//             }
//         }