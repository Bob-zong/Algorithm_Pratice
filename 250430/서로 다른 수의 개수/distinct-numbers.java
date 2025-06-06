import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < n; i++)
            hs.add(Integer.parseInt(st.nextToken()));

        System.out.print(hs.size());
    }
}