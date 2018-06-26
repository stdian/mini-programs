import java.util.Scanner;

public class ConsoleCalculator {

	static Scanner in;
	static int op;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Console calculator");
		start();
	}

	public static void start() {
		System.out.println("Choise action:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit");
		System.out.print("Input: ");
		op = in.nextInt();
		switch (op) {
			case 1: add(); break;
			case 2: odd(); break;
			case 3: mult(); break;
			case 4: div(); break;
			case 5: System.exit(0);
			default:
				System.out.println("Incorrect input. ");
				start();
		}
	}

	static void add() {
		int a, b, c;
		System.out.print("Input first number: ");
		a = in.nextInt();
		System.out.print("Input second number: ");
		b = in.nextInt();
		c = a + b;
		System.out.println("Result: " + c);
		start();
	}

	static void odd() {
		int a, b, c;
		System.out.print("Input first number: ");
		a = in.nextInt();
		System.out.print("Input second number: ");
		b = in.nextInt();
		c = a - b;
		System.out.println("Result: " + c);
		start();
	}

	static void mult() {
		int a, b, c;
		System.out.print("Input first number ");
		a = in.nextInt();
		System.out.print("Input second number: ");
		b = in.nextInt();
		c = a * b;
		System.out.println("Result: " + c);
		start();
	}

	static void div() {
		int a, b;
		double c;
		System.out.print("Input first number: ");
		a = in.nextInt();
		System.out.print("Input second number: ");
		b = in.nextInt();
		c = (float) a / b;
		System.out.println("Result: " + c);
		start();
	}
}