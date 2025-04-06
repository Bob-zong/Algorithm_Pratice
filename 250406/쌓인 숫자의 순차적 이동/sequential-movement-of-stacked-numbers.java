import java.util.*;
import java.io.*;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    // 완전 탐색을 진행 -> seqArr에서 순서대로 같은 값을 찾는다 N^2
    // 8방향 중 최대값을 찾아서 그 값과 교환 O(1) 8번
    // 근데 한 칸에서 최대 n^2 만큼 숫자가 겹칠 수 있잖아, 그럼 몇개를 옮길지 찾아 -> 최대 n^2
    // m번 만큼 진행 -> 8 * m * N ^ 2 - > m * n^3
    // 
    public static final int MAX_N = 20;
    public static final Pair OUT_OF_GRID = new Pair(-1, -1);

    public static int n, m;
    
    public static ArrayList<Integer>[][] grid = new ArrayList[MAX_N][MAX_N];
    
    public static int[] dx = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static Pair GetPos(int num) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < (int) grid[i][j].size(); k++)
                    if(grid[i][j].get(k) == num)
                        return new Pair(i, j);
            }
        }
        return new Pair(0, 0);
    }

    public static Pair NextPos(Pair pos) {
        int x = pos.x;
        int y = pos.y;

        int maxVal = -1;
        Pair maxPos = OUT_OF_GRID;
        
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny)) {
                for(int j = 0; j < (int) grid[nx][ny].size(); j++){
                    if(grid[nx][ny].get(j) > maxVal) {
                        maxVal = grid[nx][ny].get(j);
                        maxPos = new Pair(nx,ny);
                    }
                }
            }
        }

        return maxPos;
    }

    public static void move(Pair pos, Pair nextPos, int moveNum) {
        int x = pos.x;
        int y = pos.y;

        int nx = nextPos.x;
        int ny = nextPos.y;

        boolean toMove = false;
        for(int i = 0; i < (int) grid[x][y].size(); i++) {
            if(grid[x][y].get(i) == moveNum)
                toMove = true;
            
            if(toMove)
                grid[nx][ny].add(grid[x][y].get(i));
        }

        while(grid[x][y].get(grid[x][y].size() - 1) != moveNum)
            grid[x][y].remove(grid[x][y].size() - 1);
        grid[x][y].remove(grid[x][y].size() - 1);

        
    }

    public static void simulate(int moveNum) {
        Pair pos = GetPos(moveNum);
        Pair nextPos = NextPos(pos);
        if(nextPos != OUT_OF_GRID)
            move(pos, nextPos, moveNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(st.nextToken());
                grid[i][j].add(num);
            }
        }
        
        st = new StringTokenizer(br.readLine());

        while(m-- > 0) {
            int moveNum = Integer.parseInt(st.nextToken());
            simulate(moveNum);

        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((int) grid[i][j].size() == 0)
                    sb.append("None");
                else {
                    for(int k = (int) grid[i][j].size() - 1; k >= 0; k--)
                        sb.append(grid[i][j].get(k)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}