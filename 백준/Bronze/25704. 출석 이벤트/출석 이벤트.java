import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double P = Double.parseDouble(br.readLine());
		
		double cost = 0;
		
		if(N < 5) {
			cost = P;
		} else if(N >= 5 && N < 10) {
			if(P-500 < 0) cost = 0;
			else cost = P - 500;
		} else if(N >= 10 && N < 15) {
			if(P - 500 > P - (P*0.1)) cost = P - (P*0.1);
			else if(P - 500 < 0) cost = 0;
			else cost = P - 500;
		} else if(N >= 15 && N < 20) {
			if(P - 2000 > P - (P*0.1)) cost = P - (P*0.1);
			else if(P - 2000 < 0) cost = 0;
			else cost = P - 2000;
		} else if(N >= 20) {
			if(P - 2000 > P - (P*0.25)) cost = P - (P*0.25);
			else if(P - 2000 < 0) cost = 0;
			else cost = P - 2000;
		}
		
		System.out.println((int)cost);
		
		br.close();
	}

}