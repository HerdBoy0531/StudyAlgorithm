import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String dna = br.readLine();
		char str = dna.charAt(n-1);
		
		for(int i = n-2; i > -1; i--) {
			char An = dna.charAt(i);
			if(str == 'A') {
				if(An == 'A') {
					str = 'A';
				}
				else if(An == 'G') {
					str = 'C';
				}
				else if(An == 'C') {
					str = 'A';
				}
				else if(An == 'T') {
					str = 'G';
				}
			}
			else if(str == 'G') {
				if(An == 'A') {
					str = 'C';
				}
				else if(An == 'G') {
					str = 'G';
				}
				else if(An == 'C') {
					str = 'T';
				}
				else if(An == 'T') {
					str = 'A';
				}
			}
			else if(str == 'C') {
				if(An == 'A') {
					str = 'A';
				}
				else if(An == 'G') {
					str = 'T';
				}
				else if(An == 'C') {
					str = 'C';
				}
				else if(An == 'T') {
					str = 'G';
				}
			}
			else if(str == 'T') {
				if(An == 'A') {
					str = 'G';
				}
				else if(An == 'G') {
					str = 'A';
				}
				else if(An == 'C') {
					str = 'G';
				}
				else if(An == 'T') {
					str = 'T';
				}
			}
		}
		System.out.println(str);
	}

}
