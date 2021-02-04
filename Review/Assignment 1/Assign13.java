/*input
10
*/

import java.io.*;

public class Assign13 {
	public static char[][] icon = {
			{'*', 'X', '*'},
			{'X', '*', '*'},
			{'*', '*', 'X'}
		};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Scaling factor: ");
		int k = Integer.parseInt(br.readLine());
		printScaled(k);
	}

	public static void printScaled(int k) {
		for (int i = 0; i < 3*k; i++) {
			for (int j = 0; j < 3*k; j++) {
				System.out.print(icon[i/k][j/k]);
			}
			System.out.println();
		}
	}
}