import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer,Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(n-- > 0){
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0)
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()),0)).append(" ");

        System.out.print(sb);
    }
}