
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSort {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		pln("Array list");
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			pln("1. Add to list");
			pln("2. Sort list");
			pln("3. Print list");
			pln("4. Exit");
			p("Input: ");
			int inp = input.nextInt();
			if (inp == 1) {
				p("Integer to add: ");
				int add = input.nextInt();
				list.add(add);
			}
			else if (inp == 2) {
				Collections.sort(list);
			}
			else if (inp == 3) {
				pln(list);
			}
			else if (inp == 4) {
				System.exit(0);
			}
		}
	}

	public static void pln(Object text) {
		String str = text.toString();
		System.out.println(str);
	}

	public static void p(Object text) {
		String str = text.toString();
		System.out.print(str);
	}

}
