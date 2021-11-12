import java.io.IOException;

/**
 * Represents highest scoring line of a processed text file based on adjusted
 * scrabble rules
 * 
 * @author gabrieljones
 *
 */
public class MaxScrabble extends TextFileAccessor {
	// constants
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };// constants of normal scrabble scores based on letters
	private final int ASCII_CODE_a = 97;// ASCII code value of lower case a
	private int highscore; // holds current high score
	private String winningLine;// holds current winning line

	/**
	 * Constructs a Max Scrabble object based on file if the file name exists,
	 * otherwise throws IOException
	 * 
	 * @param filename name of the file
	 * @throws IOException if input file name does not exist
	 */
	public MaxScrabble(String filename) throws IOException {
		openFile(filename);
		highscore = 0;
	}

	public void processLine(String curLine) {
		char[] simplified = curLine.toLowerCase().toCharArray();// creates a character array of the input string with all lowercase letters
		int score = 0;// creates a score variable for the current score
		// for every letter in the input string, adds to the score based on the scrabble rules
		for (int i = 0; i < simplified.length; i++) {
			if (Character.isLetter(simplified[i]) && simplified[i] - ASCII_CODE_a <= SCRABBLE_SCORES.length) {
				if (i % 4 == 0) {
					score += SCRABBLE_SCORES[simplified[i] - ASCII_CODE_a] * 2;
				} else if (i % 9 == 0) {
					score += SCRABBLE_SCORES[simplified[i] - ASCII_CODE_a] * 3;
				} else {
					score += SCRABBLE_SCORES[simplified[i] - ASCII_CODE_a];
				}
			}
		}
		// if the current score is greater than the high score, set the current line string to the
		if (score > highscore) {
			highscore = score;
			winningLine = curLine;
		}

	}

	public void printReport() {
		System.out.println("winner: \"" + winningLine + "\" score: " + highscore);
	}
}
