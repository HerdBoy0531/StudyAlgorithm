import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ;i < n ; i++) {
			int score = Integer.parseInt(st.nextToken());
			if(score == 300) {
				sb.append("1").append(" ");
			} else if(score < 300 && score >=275) {
				sb.append("2").append(" ");
			} else if(score < 275 && score >=250) {
				sb.append("3").append(" ");
			} else {
				sb.append("4").append(" ");
			}
		}
		
		System.out.println(sb);
	}

}