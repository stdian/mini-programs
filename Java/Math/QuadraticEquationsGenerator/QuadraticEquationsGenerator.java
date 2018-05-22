
import java.util.Random;

public class QuadraticEquationsGenerator {

	public static void main(String[] args) {

		Random random = new Random();

		String final_str = "";
		int a, b, c, d, x1, x2;

		a = random.nextInt(20) - 10;
		b = random.nextInt(20) - 10;
		c = random.nextInt(20) - 10;
		while (a == 0 || b == 0 || c == 0) {
			a = random.nextInt(20) - 10;
			b = random.nextInt(20) - 10;
			c = random.nextInt(20) - 10;
		}

		final_str = final_str + a + "x^2 ";
		if (b < 0) {
			b = b * -1;
			final_str = final_str + "- " + b + "x ";
			b = b * -1;
		} else {
			final_str = final_str + "+ " + b + "x";
		}

		if (c < 0) {
			c = c * -1;
			final_str = final_str + "- " + c + " = 0 ";
			c = c * -1;
		} else {
			final_str = final_str + "+ " + c + " = 0";
		}

		System.out.println(final_str);
		solve(a, b, c);



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
