import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> poke = new HashMap<>();
		Map<Integer, String> number = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String pokemon = br.readLine();
			poke.put(pokemon, i);
			number.put(i, pokemon);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			String ans = br.readLine();
			if(Character.isDigit(ans.charAt(0))) {
				int idx = Integer.parseInt(ans);
				sb.append(number.get(idx)).append("\n");
			}
			else {
				sb.append(poke.get(ans)).append("\n");
			}
		
		
		
		}
		System.out.print(sb);
		br.close();
	}
}