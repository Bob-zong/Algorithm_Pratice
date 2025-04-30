import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_G = 250000;
    public static final int MAX_N = 100000;

    public static int n, g; // 사람 수, 그룹 수
    public static boolean[] invited = new boolean[MAX_N+1];
    // 각 그룹마다 초대장을 받지 못한 사람들을 관리해줍니다.
    public static HashSet<Integer>[] groups = new HashSet[MAX_G+1];
    // 각 사람이 어떤 그룹에 속하는지를 관리해줍니다.
    public static ArrayList<Integer>[] peopleGroups = new ArrayList[MAX_N+1];
    public static Queue<Integer> q = new LinkedList<>();
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        // hs.add(1);
        ans = 0;

        for(int i = 1; i <= n; i++){
            peopleGroups[i] = new ArrayList<>();
        }
        
        for(int i = 1; i <= g; i++)
        {
            groups[i] = new HashSet<>();
        }

        for(int i = 1; i <= g; i++){
            st = new StringTokenizer(br.readLine());
            int groupNum = Integer.parseInt(st.nextToken());            
            
            for(int j = 0; j < groupNum; j++) {
                int x = Integer.parseInt(st.nextToken());
                groups[i].add(x);
                peopleGroups[x].add(i);
            }
            
        }

        q.add(1);
        invited[1] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            ans++;

            for(int i = 0; i < peopleGroups[x].size(); i++){
                int gNum = peopleGroups[x].get(i);

                groups[gNum].remove(x);

                if(groups[gNum].size() == 1) {
                    int pNum = new ArrayList<>(groups[gNum]).get(0);
                    if(!invited[pNum]) {
                        invited[pNum] = true;
                        q.add(pNum);
                    }
                }
            }

        }
        System.out.print(ans);
    }
}