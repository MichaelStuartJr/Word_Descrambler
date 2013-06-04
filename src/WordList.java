import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will create a WordList of type Words and store them into an
 * ArrayList of type Word.
 * 
 * @author Michael
 */
public class WordList {
	private ArrayList<Word> words;

	/**
	 * This is the constructor for the class in which it initializes each
	 * ArrayList.
	 */
	public WordList() {
		words = new ArrayList<>();
	}

	/**
	 * This method will return the Word at a particular index inside the
	 * ArrayList
	 * 
	 * @param index
	 *            , the position on the ArrayList
	 * @return
	 */
	public String getWord(int index) {
		return words.get(index).getWord();
	}

	/**
	 * This method will return the score of the Word at a particular index
	 * inside the ArrayList
	 * 
	 * @param index
	 *            , the position on the ArrayList
	 * @return
	 */
	public int getScore(int index) {
		return words.get(index).getScore();
	}

	/**
	 * This method will return the length of the Word at a particular index
	 * inside the ArrayList
	 * 
	 * @param index
	 *            , the position on the ArrayList
	 * @return
	 */
	public int getWordLength(int index) {
		return words.get(index).getLength();
	}

	/**
	 * This method will return the size of the ArrayList
	 * 
	 * @return
	 */
	public int getSize() {
		return words.size();
	}

	/**
	 * This method will add a new Word to the ArrayList
	 * 
	 * @param temp
	 *            , the Word that is being store
	 */
	public void addWord(String temp) {
		Word w = new Word(temp);
		words.add(w);
	}

	/**
	 * Removes all objects from this ArrayList.
	 */
	public void clearList() {
		words.clear();
	}

	/**
	 * This method will remove a Word that is at position given by the user
	 * 
	 * @param i
	 *            , the position given by the user
	 */
	public void removeWord(int i) {
		int location = words.indexOf(words.get(i));
		words.remove(location);
	}

	/**
	 * This method scans through each of the text files, adding them to an
	 * ArrayList.
	 */
	public void parseFile() throws FileNotFoundException {
		File fileName = new File("enable1.txt");
		Scanner scan = new Scanner(fileName);
		String temp;
		while (scan.hasNext()) {
			temp = scan.nextLine();
			addWord(temp);
		}
	}
}
