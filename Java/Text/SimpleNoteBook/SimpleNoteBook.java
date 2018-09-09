
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleNoteBook {
	File file = new File("notes.txt");
	ArrayList<String> notes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		String userInput;

		System.out.println("Welcome to notebook\n\n");

		while (true) {
			System.out.println("1. Show notes");
			System.out.println("2. Add note");
			System.out.println("3. Remove notes");
			System.out.println("4. Exit");

			userInput = in.nextLine().trim();

			switch (userInput) {
				case "1":
					new SimpleNoteBook().printNotes();
					break;
				case "2":
					new SimpleNoteBook().addNotes();
					break;
				case "3":
					new SimpleNoteBook().clearNotes();
					break;
				case "4":
					System.exit(0);
			}
		}

	}

	public void printNotes() throws IOException {
		readNotes();

		System.out.println("Notes:\n");

		for (String note : notes) {
			System.out.println(note);
		}

		System.out.println();
	}

	public void readNotes() throws IOException {
		if(! file.exists()){
			file.createNewFile();
		}

		Scanner sc = new Scanner(file);

		notes.clear();

		while (sc.hasNextLine()) {
			notes.add(sc.nextLine());
		}
	}

	public void addNotes() throws IOException {
		Scanner in = new Scanner(System.in);

		readNotes();

		System.out.print("Text: ");
		String text = in.nextLine();

		notes.add(text);

		PrintWriter out = new PrintWriter(file.getAbsoluteFile());

		try {
			out.flush();
			for (String note : notes) {
				out.print(note + "\n");
			}
		} finally {
			out.close();
		}
	}

	public void clearNotes() throws FileNotFoundException {
		PrintWriter out = new PrintWriter(file.getAbsoluteFile());

		try {
			out.flush();
		} finally {
			out.close();
		}

		notes.clear();
	}
}
