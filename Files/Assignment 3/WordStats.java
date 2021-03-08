import java.io.*;
import java.util.*;

public class WordStats {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String line;
		StringTokenizer st;
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> freq = new ArrayList<Integer>();

		while ((line = br.readLine()) != null) {
			line = line.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "").replace("\"", "");

			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				int pos = Collections.binarySearch(words, word);
				if (pos < 0) {
					words.add(-(pos+1), word);
					freq.add(-(pos+1), 1);
				} else {
					freq.set(pos, freq.get(pos)+1);
				}
			}
		}

		System.out.println("WORD                 FREQUENCY");
		for (int i = 0; i < words.size(); i++) {
			System.out.printf("%-20s %d\n", words.get(i), freq.get(i));
		}
		br.close();
	}
}