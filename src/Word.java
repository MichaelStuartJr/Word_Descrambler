/**
 * This class will create all of the information needed to create an object of
 * type Word.
 * 
 * @author Michael
 */
public class Word {
	private String word;
	private int score;
	private int length;

	/**
	 * This is the constructor that will initialize all the aspects needed to
	 * create an object of type Word.
	 * 
	 * @param s
	 *            , the word that is being initialized from
	 */
	public Word(String s) {
		word = s;
		score = scoreWord(s);
		length = s.length();
	}

	/**
	 * This is the constructor that will initialize all the aspects needed to
	 * create an object of type Word.
	 * 
	 * @return
	 */
	public String getWord() {
		return word;
	}

	/**
	 * This method will return the length of a word given by the user.
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * This method will return the score of a word given by the user.
	 * 
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * This method will score a word given by the user.
	 * 
	 * @param ss
	 *            , the word that is being scored
	 * @return
	 */
	private int scoreWord(String ss) {
		String s = ss.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'q' || s.charAt(i) == 'j' || s.charAt(i) == 'z') {
				score += 10;
			} else if (s.charAt(i) == 'x') {
				score += 8;
			} else if (s.charAt(i) == 'k' || s.charAt(i) == 'v') {
				score += 5;
			} else if (s.charAt(i) == 'f' || s.charAt(i) == 'c'
					|| s.charAt(i) == 'b' || s.charAt(i) == 'w'
					|| s.charAt(i) == 'm' || s.charAt(i) == 'p') {
				score += 4;
			} else if (s.charAt(i) == 'h' || s.charAt(i) == 'g'
					|| s.charAt(i) == 'y') {
				score += 3;
			} else if (s.charAt(i) == 'u' || s.charAt(i) == 'n'
					|| s.charAt(i) == 'd' || s.charAt(i) == 'l') {
				score += 2;
			} else {
				score += 1;
			}
		}
		return score;
	}
}
