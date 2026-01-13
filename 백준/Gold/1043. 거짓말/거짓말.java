import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<Integer> truth = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		int trueMan = Integer.parseInt(st.nextToken());
		for(int i = 0; i < trueMan; i++) {
			truth.add(Integer.parseInt(st.nextToken()));
		}
		
        ArrayList<int[]> parties = new ArrayList<>();
        int[] partySize = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            partySize[i] = Integer.parseInt(st.nextToken());
            int[] arr = new int[partySize[i]];
            for (int j = 0; j < partySize[i]; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(arr);
        }
		
        boolean changed = true;
        while (changed) {
            changed = false;

            for (int i = 0; i < m; i++) {
                int[] party = parties.get(i);

                boolean hasTruth = false;
                for (int man : party) {
                    if (truth.contains(man)) {
                        hasTruth = true;
                        break;
                    }
                }

                if (hasTruth) {
                    for (int man : party) {
                        if (truth.add(man)) {
                            changed = true;
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int man : parties.get(i)) {
                if (truth.contains(man)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }
		
		System.out.println(answer);
	}

}