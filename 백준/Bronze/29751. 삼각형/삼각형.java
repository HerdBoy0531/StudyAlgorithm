import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        float N = Float.parseFloat(st.nextToken());
        float M = Float.parseFloat(st.nextToken());
        float W = N*M/2;
        System.out.print(W);

        br.close();
    }
}