import java.io.*;
import java.util.*;

public class HTMLViewer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("webpage.html"));
		String doc = br.readLine().replace("<br>", "\n").replace("<p>", "\n\n").replace("<hr>", "------------------------------------------------");
		String[] lines = doc.split("\n");
		int width = 35;

		for (String line: lines) { 
			if (line.length() == 0) System.out.println();

			int count = 0;
			while (line.length() > 0) {
				if (line.length() > width-count && line.indexOf(" ") != -1) {
					int first = line.indexOf(" ");
					int second = line.indexOf(" ", first+1);

					if (second <= width-1-count && second != -1) {
						System.out.print(line.substring(0, first+1));
						line = line.substring(first+1, line.length());
						count += first+1;
					} else {
						System.out.println(line.substring(0, first+1));
						line = line.substring(first+1, line.length());
						count = 0;
					}
				} else {
					System.out.println(line);
					line = "";
				}
			}
		}
	}
}