import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 듣도 못한 사람, 보도 못한 사람
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        int cnt = 0;
        ArrayList<String> sameMan = new ArrayList<>();

        // HashMap 생성
        HashMap<String, Integer> WhoRU = new HashMap<>();
        for(int i = 0; i < N; i++){
            WhoRU.put(br.readLine(), i);
        }
        for(int i = 0; i < M; i++){
            String Man = br.readLine();
            if(WhoRU.containsKey(Man)){
                cnt+=1;
                sameMan.add(Man);
            }
        }

        Collections.sort(sameMan);

        bw.write(cnt+"\n");
        for(int i = 0; i < sameMan.size(); i++){
            bw.write(sameMan.get(i)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
