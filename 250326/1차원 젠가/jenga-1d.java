import java.util.*;
import java.io.*;

public class Main{
    public static int n;
    public static int[] answer;
    
    public static void cutArray(int start, int end){
        int tempArr[] = new int[n+1];
        int endIdx = 1;

        for(int i = start; i <= end; i++){
            answer[i] = 0;
        }

        for(int i = 1; i <= n; i++){
            if(answer[i] > 0)
                tempArr[endIdx++] = answer[i]; 
        }

        for(int i = 1; i <= n; i++){
            answer[i] = tempArr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        answer = new int[n+1];

        for(int i = 1; i <= n; i++){
            answer[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            cutArray(startIdx, endIdx);
        }

        int cnt = 0;
        for(int i : answer)
            if(i > 0)
                cnt += 1;
        sb.append(cnt).append("\n");
        for(int i : answer)
            if(i > 0)
                sb.append(i).append("\n");
        
        System.out.print(sb);
        
    }
}






// public class Main {
//     public static int n;
//     public static int[] answer;
//     public static int endOfArray;

//     public static void cutArray(int startIdx, int endIdx){
//         int[] tempArr = new int[n+1];
//         int endOfTempArray = 1;

//         for(int i = 1; i <= endOfArray; i++){
//             if( i < startIdx || i > endIdx)
//                 tempArr[endOfTempArray++] = answer[i];
//         }
        
        
//         for(int i = 1; i <= endOfTempArray; i++)
//             answer[i] = tempArr[i];

//         endOfArray = endOfTempArray-1;
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st;

//         n = Integer.parseInt(br.readLine());
//         answer = new int[n+1];
//         endOfArray = n;

//         for(int i = 1; i <= n; i++){
//             answer[i] = Integer.parseInt(br.readLine());
//         }
        
//         for(int k = 0; k < 2; k++){
//             st = new StringTokenizer(br.readLine());
//             int start = Integer.parseInt(st.nextToken());
//             int end = Integer.parseInt(st.nextToken());

//             cutArray(start, end);
//         }

//         System.out.println(endOfArray);
//         for(int i = 1; i <= endOfArray; i++)
//             System.out.println(answer[i]);
        
//     }
// }