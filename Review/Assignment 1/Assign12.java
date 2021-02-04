/*input
ABBABA
*/

import java.io.*;

public class Assign12 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter votes: ");
		String in = br.readLine();
		int a = 0, b = 0;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == 'A') a++;
			else if (in.charAt(i) == 'B') b++;
		}
		System.out.print("Winner: ");
		if (a > b) System.out.println("A");
		else if (a < b) System.out.println("B");
		else System.out.println("Tie");
	}
}