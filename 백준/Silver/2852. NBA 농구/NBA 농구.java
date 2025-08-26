import java.io.*;
import java.util.*;

public class Main {
    private static int toSec(String mmss){
        String[] a = mmss.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }

    private static String toMMSS(int sec){
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }    

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int s1 = 0, s2 = 0;
        int lead1 = 0, lead2 = 0;
        int prev = 0;
        
        for(int i = 0; i < N; i++){
            String[] sp = br.readLine().split(" ");
            int team = Integer.parseInt(sp[0]);
            int t = toSec(sp[1]);
            
            if(s1>s2) lead1 += (t-prev);
            else if(s1<s2) lead2 += (t-prev);
            
            if(team == 1) s1++;
            else s2++;
            
            prev = t;
        }

        int end = 48 * 60;
        if(s1 > s2) lead1 += (end - prev);
        else if(s2 > s1) lead2 += (end - prev);
        
        System.out.println(toMMSS(lead1));
        System.out.println(toMMSS(lead2));
        br.close();
    }
}
