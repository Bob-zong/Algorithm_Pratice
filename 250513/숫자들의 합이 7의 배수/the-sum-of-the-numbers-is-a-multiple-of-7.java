import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, arr[], modSum[], sum[], res;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n+1];
		modSum = new int[n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solution();
	}

	static void solution() {
		for(int i=1; i<=n; i++){
			modSum[i] = (modSum[i-1] + arr[i]) % 7;
			map.put(modSum[i], i);
		}

		for(int i=1; i<=n; i++){
			res = Math.max(res, map.get(modSum[i])-i);
		}

		System.out.println(res);
	}
}
