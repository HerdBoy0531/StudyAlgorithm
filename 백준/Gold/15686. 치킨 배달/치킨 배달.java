import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static ArrayList<int[]> home, chicken, chickenM;
	public static int minRoot = Integer.MAX_VALUE;
	
	public static void dfs(int lev, int cnt) {
		if(lev == m) {
			check();
			return;
		}
		
		for(int i = cnt; i < chicken.size(); i++) {
			chickenM.add(chicken.get(i));
			dfs(lev+1, i+1);
			chickenM.remove(chickenM.size() - 1);
		}
		
		return;
	}
	
	public static void check() {
	    int sum = 0;

	    for (int i = 0; i < home.size(); i++) {
	        int minDist = Integer.MAX_VALUE;
	        int[] h = home.get(i);

	        for (int j = 0; j < chickenM.size(); j++) {
	            int[] c = chickenM.get(j);
	            int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
	            minDist = Math.min(minDist, dist);
	        }

	        sum += minDist;
	    }

	    minRoot = Math.min(minRoot, sum);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		chickenM = new ArrayList<>();
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					home.add(new int[] {i, j});
				}
				else if(num == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		dfs(0, 0);
		
		System.out.println(minRoot);
		
		br.close();
		
	}

}