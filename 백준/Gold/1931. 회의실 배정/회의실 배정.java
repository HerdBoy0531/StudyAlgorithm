import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new int[] {end, start});
		}
		
        list.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
		
		
		int room_ed = 0, room_st = 0,cnt = 1;
		int[] rooms = list.get(0); 
		room_ed = rooms[0];
		for(int i = 1; i < N; i++) {
			rooms = list.get(i);
			room_st = rooms[1];
			if(room_st >= room_ed) {
				room_ed = rooms[0];
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}