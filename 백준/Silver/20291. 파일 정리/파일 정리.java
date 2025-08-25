import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> users = new TreeMap<>();

        for(int i = 0; i < N; i++){
            String arr = br.readLine();
            int p = arr.lastIndexOf('.');
            String ext = (p >= 0 && p < arr.length() - 1) ? arr.substring(p + 1) : "";
            users.put(ext, users.getOrDefault(ext, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : users.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        br.close();
    }
}
