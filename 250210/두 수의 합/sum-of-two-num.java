import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static boolean[] visited;
    public static List<Integer> arrList = new ArrayList<>();
    public static int cnt;
    public static int print(){
        int sum = 0;

        for(int i = 0; i < arrList.size(); i++){
            sum += arrList.get(i);
        }
        
        return sum;
    }

    public static void choose(int currNum){
        if(currNum == 3){
            int num = print();
            if(num == k){
                cnt += 1;
            }
            return;
        }

        for(int i = 1; i <= n; i++){
            if(visited[i])
                continue;

            arrList.add(i);
            visited[i] = true;
            choose(currNum + 1);
            arrList.remove(arrList.size()-1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        // String.valueOf(str) -> 문자열을 정수로
        // Integer.toString(num) -> 정수를 문자열로
        
        int[] answer;
        cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            answer[i] = Integer.parseInt(st.nextToken());
        }
        
        choose(1);

        System.out.print(cnt);


    }
}