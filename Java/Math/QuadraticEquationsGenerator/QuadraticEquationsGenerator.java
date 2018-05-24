
import java.util.Random;
import java.util.Scanner;

public class QuadraticEquationsGenerator {

	static Random random = new Random();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String final_str;
		int a, b, c;

		int answer = 10;

		while (true) {
			int[] eq = generate();
			a = eq[0];
			b = eq[1];
			c = eq[2];

			final_str = generate_str(a, b, c);


			System.out.println("Your Equation: " + final_str);
			System.out.println("1. Solve\n2. Generate new");
			int inp = sc.nextInt();
			if (inp == 1) {
				break;
			}

		}

		System.out.println(final_str);
		solve(a, b, c);

	}

	public static String generate_str(int a, int b, int c) {

		String final_str = "";

		if (a == 1) {
			final_str = final_str + "x^2 ";
		} else {
			final_str = final_str + a + "x^2 ";
		}
		if (b < 0) {
			b = b * -1;
			final_str = final_str + "- " + b + "x ";
			b = b * -1;
		}
		else if(b == 1) {
			final_str = final_str + "+ x ";
		} else {
			final_str = final_str + "+ " + b + "x ";
		}

		if (c < 0) {
			c = c * -1;
			final_str = final_str + "- " + c + " = 0 ";
			c = c * -1;
		} else {
			final_str = final_str + "+ " + c + " = 0";
		}

		return final_str;
	}

	public static int[] generate() {
		int a, b, c;

		a = random.nextInt(20) - 5;
		b = random.nextInt(20) - 5;
		c = random.nextInt(20) - 15;
		while (a == 0 || b == 0 || c == 0) {
			a = random.nextInt(20) - 5;
			b = random.nextInt(20) - 5;
			c = random.nextInt(20) - 15;
		}

		return new int[]{a, b, c};
	}

	public static void solve(int a, int b, int c) {
		double x1 = 0, x2 = 0;

		double d = b * b - (4 * a * c);
		System.out.println("D = " + d);;
		if (d > 0) {
			d = Math.sqrt(d);
			x1 = ((b * -1) + d) / (2 * a);
			x2 = ((b * -1) + (d * -1)) / (2 * a);
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
		else if (d == 0) {
			x1 = (b * -1) / (2 * a);
			System.out.println("x = " + x1);
		} else {
			System.out.println("Solve not found");
		}

	}

}

