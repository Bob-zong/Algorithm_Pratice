// import java.util.*;
// import java.io.*;

// public class Main {
//     public static int n;
//     public static ArrayList<int[]> answer = new ArrayList<>();
//     public static int maxChoiseCount;
//     public static int[][] lines;

//     public static void calculate(int depth){
//         maxChoiseCount = Math.max(maxChoiseCount, answer.size());
        
//         for (int i = depth; i < n; i++) {
//             if (isOverlapped(lines[i])) {
//                 continue;
//             }
//             answer.add(lines[i]);
//             calculate(i + 1);
//             answer.remove(lines[i]);
//         }
//     }

//     public static boolean isOverlapped(int[] line) {
//         for (int[] choice : answer) {
//             // System.out.printf("value: %d, %d\n", choice[0],choice[1])
//             System.out.printf("value: %d, %d\n", line[0],line[1]);
//             if (choice[0] == line[0] || choice[1] == line[1]) {
//                 return true;
//             }
//             if (choice[0] > line[0] && choice[0] > line[1]) {
//                 continue;
//             }
//             if (choice[0] < line[0] && choice[1] < line[0]) {
//                 continue;
//             }
//             return true;
//         }

//         return false;
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringBuilder sb = new StringBuilder();
//         StringTokenizer st;

//         n = Integer.parseInt(br.readLine());
//         lines = new int[n][2];

//         for(int i = 0; i < n; i++){
//             st = new StringTokenizer(br.readLine());
//             int x1 = Integer.parseInt(st.nextToken());
//             int x2 = Integer.parseInt(st.nextToken());
            
//             lines[i][0] = x1;
//             lines[i][1] = x2;
//             // System.out.println(lines[i]);
//         }

//         calculate(0);

//         sb.append(maxChoiseCount);
//         System.out.print(sb);

//     }
// }

import java.util.*;
import java.io.*;

class Pair {
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    public static final int MAX_N = 15;
    public static int n;
    public static Pair[] segments = new Pair[MAX_N];

    public static int ans;
    public static ArrayList<Pair> selectedSegs = new ArrayList<>();

    public static boolean overlapped(Pair seg1, Pair seg2){
        int ax1 = seg1.x;
        int ax2 = seg1.y;

        int bx1 = seg2.x;
        int bx2 = seg2.y;

        if(ax1 <= bx1 && bx1 <= ax2)
            return true;
        
        if(ax1 <= bx2 && bx2 <= ax2)
            return true;
        
        if(bx1 <= ax1 && ax1 <= bx2)
            return true;

        if(bx1 <= ax2 && ax2 <= bx2)
            return true;

        return false;
    }

    public static boolean possible() {
        for(int i = 0; i < (int)selectedSegs.size(); i++){
            for(int j = i + 1; j < (int)selectedSegs.size(); j++){
                if(overlapped(selectedSegs.get(i), selectedSegs.get(j)))
                    return false;
            }
        }
        return true;
    }
    public static void findMaxSegments(int cnt) {
        if(cnt == n) {
            if(possible())
                ans = Math.max(ans, (int) selectedSegs.size());
            return;
        }
        
        selectedSegs.add(segments[cnt]);
        findMaxSegments(cnt + 1);
        selectedSegs.remove(selectedSegs.size() - 1);
        
        findMaxSegments(cnt + 1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++)
            segments[i] = new Pair(0, 0);
        
        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }

        findMaxSegments(0);
        
        System.out.print(ans);
    }
}