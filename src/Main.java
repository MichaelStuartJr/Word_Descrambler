import java.io.FileNotFoundException;

/**
 * This is main class that will create an object of type Descramble and then
 * call upon it's play method to carry out it's task of descrambling a word.
 * 
 * @author Michael
 */
public class Main {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Descramble d = new Descramble();
		d.play();
	}
}
