import java.io.*;
import java.util.*;

public class HTMLViewer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("webpage.html"));
		String doc = br.readLine().replace("<br>", "\n").replace("<p>", "\n\n").replace("<hr>", "------------------------------------------------");
		String[] lines = doc.split("\n");

		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> Line width: ");
		int width = Integer.parseInt(br.readLine());

		for (String line: lines) { 
			if (line.length() == 0) {
				System.out.println();
			} else {
				int printed = 0;
				while (line.length() > 0) {

					int first = line.indexOf(" ");
					int second = line.indexOf(" ", first+1);

					if (line.length() <= width-printed || first == -1) {
						System.out.println(line);
						line = "";
					} else if (second <= width-1-printed && second != -1) {
						System.out.print(line.substring(0, first+1));
						line = line.substring(first+1, line.length());
						printed += first+1;
					} else {
						System.out.println(line.substring(0, first+1));
						line = line.substring(first+1, line.length());
						printed = 0;
					}
				}
			}
		}
	}
}