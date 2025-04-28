import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                answer.add(num);
            }
            else if(command.equals("get")){
                int num = Integer.parseInt(st.nextToken());
                System.out.println(answer.get(num-1));
            }
            else if(command.equals("size")){
                System.out.println(answer.size());
            }
            else if(command.equals("pop_back")){
                answer.remove(answer.size()-1);
            }
        }

    }
}