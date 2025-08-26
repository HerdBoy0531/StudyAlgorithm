import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			TreeMap<String, Integer> cloth = new TreeMap<>();
			int time = Integer.parseInt(br.readLine());
			for(int ii = 0; ii < time; ii++) {
				String[] cloths = br.readLine().split(" ");
				cloth.put(cloths[1], cloth.getOrDefault(cloths[1], 0)+1);	
			}
			int cnt = 1;
			for(Map.Entry<String, Integer> e : cloth.entrySet()) {
				cnt *= (e.getValue()+1); 
			}
			System.out.println(cnt-1);
		}
		
		
		br.close();
	}
}