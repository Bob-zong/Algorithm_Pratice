import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static ArrayList<int[]> answer = new ArrayList<>();
    public static int maxChoiseCount;
    public static int[][] lines;

    public static void calculate(int depth){
        maxChoiseCount = Math.max(maxChoiseCount, answer.size());
        
        for (int i = depth; i < n; i++) {
            if (isOverlapped(lines[i])) {
                continue;
            }
            answer.add(lines[i]);
            calculate(i + 1);
            answer.remove(lines[i]);
        }
    }

    public static boolean isOverlapped(int[] line) {
        for (int[] choice : answer) {
            if (choice[0] == line[0] || choice[1] == line[1]) {
                return true;
            }
            if (choice[0] > line[0] && choice[0] > line[1]) {
                continue;
            }
            if (choice[0] < line[0] && choice[1] < line[0]) {
                continue;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        lines = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            lines[i][0] = x1;
            lines[i][1] = x2;
            // System.out.println(lines[i]);
        }

        calculate(0);

        sb.append(maxChoiseCount);
        System.out.print(sb);

    }
}