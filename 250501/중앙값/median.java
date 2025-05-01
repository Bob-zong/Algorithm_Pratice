import java.util.*;
import java.io.*;

public class Main {
    public static int T, m;
    public static int[] answer;
    public static StringBuilder sb;

    public static void findMedianValue() {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

        int median = answer[0];
        sb.append(median).append(" ");

        for(int i = 1; i < m; i++) {
            // 짝수인 경우
            if(i % 2 == 1) {
                if(answer[i] < median)
                    maxPQ.add(-answer[i]);
                else
                    minPQ.add(answer[i]);
            }
            else {
                int newValue;

                if(maxPQ.size() > minPQ.size())
                    newValue = -maxPQ.poll();
                else
                    newValue = minPQ.poll();

                
                int[] nums = new int[]{answer[i], newValue, median};
                Arrays.sort(nums);

                maxPQ.add(-nums[0]);
                median = nums[1];
                minPQ.add(nums[2]);

                sb.append(median).append(" ");
            }

        }
        sb.append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());


        // 만약 5 2 3 1 4 가 들어온다고 해보자
        // 5가 들어오면 pivot이 5야
        // minpq - > 2
        // minpq -> 3 
        for(int t = 1; t <= T; t++) {
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            answer = new int[m];

            for(int i = 0; i < m; i++) {
                answer[i] = Integer.parseInt(st.nextToken());
            }

            findMedianValue();
        }

        System.out.print(sb);
    }
}