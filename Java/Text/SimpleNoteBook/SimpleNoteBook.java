
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class SimpleNoteBook {
	static File file;
	static File users = new File("users.bin");
	static String session = "";
	ArrayList<String> notes = new ArrayList<>();

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Scanner in = new Scanner(System.in);

		String userInput;

		System.out.println("Welcome to notebook\n\n");

		while (true) {
			if (session.equals("")) {

				if(! users.exists()){
					users.createNewFile();
				}

				System.out.println("1. Login\n2. Register\n3. Exit");
				userInput = in.nextLine().trim();

				if (userInput.equals("1")) {
					new SimpleNoteBook().login();
				} else if (userInput.equals("2")) {
					new SimpleNoteBook().register();
				} else if (userInput.equals("3")) {
					System.exit(0);
				}
			} else {
				System.out.println("1. Show notes");
				System.out.println("2. Add note");
				System.out.println("3. Remove notes");
				System.out.println("4. Exit");
				file = new File(session + ".bin");
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

	}

	public void printNotes() throws IOException {
		readNotes();

		if (! notes.isEmpty()) {

			System.out.println("Notes:\n");

			for (String note : notes) {
				byte[] decodedText = Base64.getDecoder().decode(note);
				System.out.println(new String(decodedText));
			}
		} else {
			System.out.println("Your notes are empty!");
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

		byte[] encodedText = Base64.getEncoder().encode(text.getBytes());

		notes.add(new String(encodedText));

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

	public void register() throws NoSuchAlgorithmException, UnsupportedEncodingException, FileNotFoundException {

		ArrayList<String> data = new ArrayList<>();

		Scanner sc = new Scanner(users);

		while (sc.hasNextLine()) {
			data.add(sc.nextLine());
		}

		PrintWriter out = new PrintWriter(users.getAbsoluteFile());
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		Scanner in = new Scanner(System.in);

		System.out.print("Input login: ");
		String login = in.nextLine().trim();
		System.out.print("Input password: ");
		String password = in.nextLine().trim();

		for(String user : data) {
			String[] loginPassword = user.split(":");
			if (login.equals(loginPassword[0])) {
				System.out.println("This login already used!");
				return;
			}
		}

		if (! login.equals("") && ! password.equals("")) {
			m.update(password.getBytes("utf-8"));
			String hashedPassword = new BigInteger(1,m.digest()).toString(16);

			while(hashedPassword.length() < 32 ){
				hashedPassword = "0" + hashedPassword;
			}

			data.add(login + ":" + hashedPassword);

			try {
				for (String user : data) {
					out.println(user);
				}
			} finally {
				out.close();
			}
		}
	}

	public void login() throws NoSuchAlgorithmException, UnsupportedEncodingException, FileNotFoundException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		Scanner in = new Scanner(System.in);

		System.out.print("Input login: ");
		String login = in.nextLine().trim();
		System.out.print("Input password: ");
		String password = in.nextLine().trim();

		if (! login.equals("") && ! password.equals("")) {
			m.update(password.getBytes("utf-8"));
			String hashedPassword = new BigInteger(1,m.digest()).toString(16);

			while(hashedPassword.length() < 32 ){
				hashedPassword = "0" + hashedPassword;
			}

			Scanner sc = new Scanner(users);

			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] loginPassword = data.split(":");
				if (login.equals(loginPassword[0]) && hashedPassword.equals(loginPassword[1])) {
					session = login;
					System.out.println("\nWelcome, " + session);
					return;
				}
			}
			System.out.println("Wrong login or password!\n");
		}
	}
}
