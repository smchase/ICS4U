/*input
69
1.73
*/

import java.util.Scanner;

public class Assign11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter weight (kg): ");
		double w = input.nextDouble();

		System.out.print("Enter height (m): ");
		double h = input.nextDouble();

		double bmi = w/(h*h);
		System.out.print("BMI category: ");
		if (bmi < 18.5) {
			System.out.println("underweight");
		} else if (bmi > 25) {
			System.out.println("overweight");
		} else {
			System.out.println("normal weight");
		}
	}
}