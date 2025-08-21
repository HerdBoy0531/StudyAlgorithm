import java.io.*;
import java.util.*;

public class Main {
    public static Queue<Integer> card = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            card.add(i);
        }
        while(card.size() > 1){
            card.poll();
            int num = card.poll();
            card.add(num);
        }
        System.out.println(card.poll());
    }
}
