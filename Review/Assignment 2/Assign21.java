/*input
sample text
*/

import java.util.*;

public class Assign21 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String sentence[] = input.nextLine().toUpperCase().split(" ");

		for (String word: sentence) {
			for (int layer = -word.length()+1; layer <= word.length()-2; layer++) {
				for (int indent = 0; indent < Math.abs(layer); indent++) {
					System.out.print(" ");
				}

				int domain = word.length()-Math.abs(layer)-1;
				for (int letter = -domain; letter <= domain; letter++) {
					System.out.print(word.charAt(domain-Math.abs(letter)));
				}
				System.out.println();
			}

			for (char c: word.toCharArray()) {
				for (int indent = 0; indent <= word.length()-2; indent++) {
					System.out.print(" ");
				}
				System.out.println(c);
			}
			System.out.println();
		}
	}
}