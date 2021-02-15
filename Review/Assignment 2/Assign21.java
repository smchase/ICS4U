/*input
sample text
*/

import java.util.Scanner;

public class Assign21 {
	public static void main(String[] args) {

		// get input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a sentence: ");
		String sentence[] = input.nextLine().toUpperCase().split(" ");

		for (String word: sentence) {
			
			//make branches
			for (int layer = -word.length()+1; layer <= word.length()-2; layer++) {
				String layerText = "";
				int domain = word.length()-Math.abs(layer)-1;
				for (int letter = -domain; letter <= domain; letter++) {
					layerText += word.charAt(domain-Math.abs(letter));
				}
				System.out.printf("%" + (word.length()+domain) + "s\n", layerText);

			}

			// make trunk
			for (char letter: word.toCharArray()) {
				System.out.printf("%" + word.length() + "c\n", letter);
			}
			System.out.println();
		}
	}
}