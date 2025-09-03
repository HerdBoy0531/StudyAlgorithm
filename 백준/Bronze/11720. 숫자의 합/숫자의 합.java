import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        int res = 0;
        for(int i = 0; i < N; i++){
            res += Integer.parseInt(M.charAt(i)+"");
        }
        System.out.print(res);

        br.close();
    }
}
