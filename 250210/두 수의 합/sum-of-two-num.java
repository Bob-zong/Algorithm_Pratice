import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static boolean[] visited;
    public static List<Integer> arrList = new ArrayList<>();
    public static int cnt;
    public static int[] answer;
    public static int print(){
        int sum = 0;

        for(int i = 0; i < arrList.size(); i++){
            sum += arrList.get(i);
        }
        
        return sum;
    }

    public static void choose(int currNum, int idx){
        if(currNum == 2){
            int num = print();
            // System.out.println("value: " + num);
            if(num == k){
                cnt += 1;
            }
            return;
        }

        for(int i = idx; i < n; i++){
            if(visited[i])
                continue;

            arrList.add(answer[i]);
            visited[i] = true;
            choose(currNum + 1, i+1);
            arrList.remove(arrList.size()-1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        // String.valueOf(str) -> 문자열을 정수로
        // Integer.toString(num) -> 정수를 문자열로
        
        
        cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        
        choose(0, 0);

        System.out.print(cnt);


    }
}