import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is what will be doing all of the descrambling of words and then
 * sorting them out according to what the user wants to have as their list of
 * words.
 * 
 * @author Michael
 */
public class Descramble {
	private WordList w;
	private WordList legal;

	/**
	 * This is the constructor for the program that will create and initialize
	 * the two WordList that will keep hold of the list of words being used in
	 * the program.
	 */
	public Descramble() {
		w = new WordList();
		legal = new WordList();
	}

	/**
	 * This is will parse the word list file and store the list of words on to
	 * an ArrayList called "w".
	 * 
	 * @throws FileNotFoundException
	 */
	private void parse() throws FileNotFoundException {
		w.parseFile();
	}

	/**
	 * This method is what will be doing all of the descrambling of words and
	 * then sorting them out according to what the user wants to have as their
	 * list of words.
	 */
	public void play() throws FileNotFoundException {
		parse();
		System.out.println("Please enter in your letters: (No Blanks!!!) ");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		find(s1);
		System.out.println("Are there any blank letters? (Y/N) ");
		sc = new Scanner(System.in);
		String s2 = sc.nextLine();
		if (checkYes(s2)) {
			System.out.println("How many do you have? ");
			int r = sc.nextInt();
			blanks(s1, r);
		}
		System.out
				.println("Is there a length restriction you want on your word? (Y/N) ");
		sc = new Scanner(System.in);
		String s3 = sc.nextLine();
		if (checkYes(s3)) {
			System.out.println("What is the length restriction? ");
			sc = new Scanner(System.in);
			int l = sc.nextInt();
			checkLength(l);
		}
		System.out
				.println("Is there a letter that you want to incorporate into your word? (Y/N) ");
		sc = new Scanner(System.in);
		String s4 = sc.nextLine();
		if (checkYes(s4)) {
			System.out.println("Which letter are do you need? ");
			sc = new Scanner(System.in);
			String s5 = sc.nextLine();
			System.out.println("Where is " + s4
					+ " in the word? (Type '9999' for the last letter) ");
			sc = new Scanner(System.in);
			int i = sc.nextInt();
			letterIndex(s5.charAt(0), i);
		}
		System.out
				.println("This should printing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out
				.println("How would you like for the words to be ordered? (Score/Length/Alphabet)");
		sc = new Scanner(System.in);
		String s5 = sc.nextLine();
		s5 = s5.toLowerCase();
		switch (s5) {
		case "score":
			printOrderScore();
			break;
		case "length":
			printOrderLength();
			break;
		case "alphabet":
			printOrderAlphabet();
			break;
		}
		System.out
				.println("This should printing!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	/**
	 * This is a simple method that will just check to see if the user has
	 * entered yes to whatever question that was being asked.
	 * 
	 * @param s
	 *            , the response from the user about a Yes or No question
	 * @return, will return whether or not the user enter yes to the question
	 */
	private boolean checkYes(String s) {
		if ("Yes".equals(s) || "yes".equals(s) || "Y".equals(s)
				|| "y".equals(s)) {
			return true;
		}
		return false;
	}

	/**
	 * This is what will do the initial finding of the word from the mixed bunch
	 * of letters given by the user.
	 * 
	 * @param s
	 *            , the mix bunch of letters given by the user
	 */
	private void find(String s) {
		String m = s.toLowerCase();
		int csm = m.length();
		char[] sm = m.toCharArray();
		Arrays.sort(sm);
		for (int k = 0; k < w.getSize(); k++) {
			String r = w.getWord(k);
			int csr = r.length();
			if (r.length() <= csm) {
				String r2 = r.toLowerCase();
				char[] sr = r2.toCharArray();
				Arrays.sort(sr);
				int i = 0;
				int j = 0;
				boolean same = true;
				while (same && i < csm && j < csr) {
					if (sm[i] == sr[j]) {
						i++;
						j++;
					} else {
						i++;
					}
					if (i == csm) {
						same = false;
					}
				}
				if (same) {
					legal.addWord(r);
				}
			}
		}
	}

	/**
	 * This method will sort out all of the words that don't fit within the
	 * specified length for a word given by the user.
	 * 
	 * @param l
	 *            , is the maximum length of a word given by the user
	 */
	private void checkLength(int l) {
		WordList temp = new WordList();
		for (int i = 0; i < legal.getSize(); i++) {
			if (legal.getWordLength(i) <= l) {
				temp.addWord(legal.getWord(i));
			}
		}
		legal = temp;
	}

	/**
	 * This method will sort out all of the words that don't have the specified
	 * letter at the specified position that was given by the user.
	 * 
	 * @param c
	 *            , the letter that the user is searching for
	 * @param i
	 *            , the position that the user is looking at for
	 */
	private void letterIndex(char c, int i) {
		WordList temp = new WordList();
		for (int z = 0; z < legal.getSize(); z++) {
			String s = legal.getWord(z);
			int j = s.length();
			if (i == 9999) {
				if (legal.getWord(z).indexOf(c) == j - 1) {
					temp.addWord(legal.getWord(z));
				}
			} else {
				if (j >= i) {
					if (legal.getWord(z).indexOf(c) == i - 1) {
						temp.addWord(legal.getWord(z));
					}
				}
			}
		}
		legal.clearList();
		for (int z = 0; z < temp.getSize(); z++) {
			legal.addWord(temp.getWord(z));
		}
	}

	/**
	 * This will add all the new combinations of letters that can be made with
	 * the use of 1 or more blank letters.
	 * 
	 * @param i
	 *            , the number of blank letters
	 */
	private void blanks(String s, int i) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		if (i == 1) {
			for (int n = 0; n < 26; n++) {
				String ss = s + alphabet.charAt(n);
				find(ss);
				// editScore(alphabet.charAt(n));
			}
		} else if (i == 2) {
			for (int n = 0; n < 26; n++) {
				for (int nn = 0; nn < 26; nn++) {
					String ss = s + alphabet.charAt(n) + alphabet.charAt(nn);
					find(ss);
					// editScore(alphabet.charAt(n));
					// editScore(alphabet.charAt(nn));
				}
			}
		}
	}

	/**
	 * This will print out the list of words ordering from the highest score to
	 * the lowest score.
	 */
	private void printOrderScore() {
		System.out.println("There have been " + legal.getSize()
				+ " words found.");
		for (int t = legal.getSize() - 1; t >= 0; t--) {
			for (int r = legal.getSize() - 1; r >= 0; r--) {
				if (legal.getScore(r) == t) {
					System.out.println("Word: " + legal.getWord(r)
							+ "\t\tScore: " + legal.getScore(r)
							+ "\t\tLength: " + legal.getWordLength(r));
				}
			}
		}
	}

	/**
	 * This will print out the list of words ordering from the highest length to
	 * the lowest length.
	 */
	private void printOrderLength() {
		System.out.println("There have been " + legal.getSize()
				+ " words found.");
		for (int t = legal.getSize() - 1; t >= 0; t--) {
			for (int r = legal.getSize() - 1; r >= 0; r--) {
				if (legal.getWordLength(r) == t) {
					System.out.println("Word: " + legal.getWord(r)
							+ "\t\tScore: " + legal.getScore(r)
							+ "\t\tLength: " + legal.getWordLength(r));
				}
			}
		}
	}

	/**
	 * This will print out the list of words ordering from A to Z.
	 */
	private void printOrderAlphabet() {
		System.out.println("There have been " + legal.getSize()
				+ " words found.");

		// Collections.sort(legal);

		for (int r = 0; r < legal.getSize(); r++) {
			System.out.println("Word: " + legal.getWord(r) + "\t\tScore: "
					+ legal.getScore(r) + "\t\tLength: "
					+ legal.getWordLength(r));
		}
	}
}