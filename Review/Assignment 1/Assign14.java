public class Assign14 {
	public static void main(String[] args) {
		String bignum = "";
		int num, total = 0;
		boolean[] used = new boolean[30];

		for (int i = 0; i < 10; i++) {
			do {
				num = 1+(int)(Math.random()*30);
			} while (used[num-1]);
			used[num-1] = true;

			System.out.print(num + (i<9 ? ", " : ""));
			bignum += num;
		}

		System.out.printf("\n%s\n", bignum);

		for (int i = 0; i < bignum.length(); i += 2) {
			System.out.print(bignum.charAt(i) + (i<bignum.length()-2 ? " + " : " = "));
			total += Character.getNumericValue(bignum.charAt(i));
		}
		System.out.println(total);
	}
}