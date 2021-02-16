/*input
Simon
100
Ben
75
Alex
90
Liam
75
John
90
-1
*/

import java.util.*;

public class Assign22 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MarkDatabase database = new MarkDatabase();

		while (true) {
			System.out.print("> Student name: ");
			String name = input.nextLine();
			if (name.equals("-1")) break;
			
			System.out.printf("> %s's mark (%%): ", name);
			int mark = Integer.parseInt(input.nextLine());
			if (mark == -1) break;
			else if (mark < 0 || mark > 100) {
				System.out.print("ERROR: Not a valid mark, please try again\n\n");
				continue;
			}

			database.add(name, mark);
			System.out.print("Entry added\n\n");
		}
		System.out.print("Entries finished\n\n");

		database.process();
		System.out.printf("Class mean: %.1f%%\n", database.mean);
		System.out.printf("Class median: %.1f%%\n", database.median);

		System.out.print("Class mode(s): ");
		if (database.modes.length == 0) System.out.print("none\n");
		else for (int i = 0; i < database.modes.length; i++) {
			System.out.printf("%d%%", database.modes[i]);
			if (i == database.modes.length-1) System.out.print("\n");
			else System.out.print(", ");
		}

		System.out.print("Students acheieving the mode(s): ");
		if (database.modeGetters.length == 0) System.out.print("not applicable\n");
		else for (int i = 0; i < database.modeGetters.length; i++) {
			System.out.print(database.modeGetters[i]);
			if (i == database.modeGetters.length-1) System.out.print("\n");
			else System.out.print(", ");
		}
	}
}

class MarkDatabase {
	private ArrayList<String> students = new ArrayList<String>();
	private ArrayList<Integer> grades = new ArrayList<Integer>();

	public double mean;
	public double median;
	public Integer[] modes;
	public String[] modeGetters;

	public void add(String name, int mark) {
		students.add(name);
		grades.add(mark);
	}

	public void process() {
		if (students.size() == 0) {
			System.out.print("There is no data\n");
			System.exit(0);
		}

		// sort
		for (int i = 1; i < grades.size(); i++) {
			int j = i;
			while (j >= 1 && grades.get(j) < grades.get(j-1)) {
				Collections.swap(students, j, j-1);
				Collections.swap(grades, j, j-1);
				j--;
			}
		}

		// find mean
		double total = 0;
		for (int mark: grades) {
			total += mark;
		}
		mean = total/grades.size();

		// find median
		int leftMid = (int)((double)grades.size()/2 - 0.5), rightMid = (int)((double)grades.size()/2);
		median = (double)(grades.get(leftMid) + grades.get(rightMid))/2;

		// find modes
		int[] freq = new int[101];
		for (int mark: grades) {
			freq[mark]++;
		}
		int mostFreq = 2;
		ArrayList<Integer> modeList = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++) {
			if (freq[i] > mostFreq) {
				modeList.clear();
				modeList.add(i);
				mostFreq = freq[i];
			} else if (freq[i] == mostFreq) {
				modeList.add(i);
			}
		}
		modes = modeList.toArray(new Integer[modeList.size()]);

		// find mode getters
		ArrayList<String> modeGetterList = new ArrayList<String>();
		for (int mark: modes) {
			for (int i = 0; i < students.size(); i++) {
				if (grades.get(i) == mark) modeGetterList.add(students.get(i) + " (" + grades.get(i) + "%)");
			}
		}
		modeGetters = modeGetterList.toArray(new String[modeGetterList.size()]);
	}
}