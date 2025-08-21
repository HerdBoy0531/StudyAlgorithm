import java.io.*;
import java.util.*;

public class Main {
    public static Stack<Character> good = new Stack<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            for(int j = 0; j < word.length(); j++){
                if(good.isEmpty() || good.peek() != word.charAt(j)){
                    good.push(word.charAt(j));
                    continue;
                }
                if(good.peek() == word.charAt(j)){
                    good.pop();
                }
            }
            if(good.isEmpty()){
                cnt++;
            }
            good.clear();
        }
        System.out.print(cnt);
    }
}