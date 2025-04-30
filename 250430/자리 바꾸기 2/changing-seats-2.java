import java.util.*;
import java.io.*;

class Pair {
    int x1, x2;
    public Pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    public static void swap(int[] arr, int x1, int x2){
        int temp = arr[x2];
        arr[x2] = arr[x1];
        arr[x1] = temp; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<Integer>[] hs = new HashSet[n+1];

        int[] people = new int[n+1];
        Pair[] cmdArr = new Pair[k];

        for(int i = 1; i <= n; i++){
            people[i] = i;
            hs[i] = new HashSet<>();
            hs[i].add(i);
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            cmdArr[i] = new Pair(x1, x2);
        }

        for(int i = 0; i < k * 3; i++){
            Pair value = cmdArr[(i % k)];
            
            swap(people, value.x1, value.x2);

            hs[people[value.x1]].add(value.x1);
            hs[people[value.x2]].add(value.x2);
        }
        
        for(int i = 1; i <= n; i++){
            sb.append(hs[i].size()).append("\n");
        }

        System.out.print(sb);

    }
}