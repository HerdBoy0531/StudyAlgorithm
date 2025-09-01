import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int t = Integer.parseInt(br.readLine());
            if(t == 0){
                if(pQ.isEmpty()){
                        sb.append(0+"\n");
                }
                else {
                    sb.append(pQ.poll()+"\n");
                }
            }
            else {
                pQ.add(t);
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}
