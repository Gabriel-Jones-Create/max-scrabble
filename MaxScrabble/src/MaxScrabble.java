import java.io.IOException;

public class MaxScrabble extends TextFileAccessor {
	//constants
	private final int[] SCRABBLE_SCORES = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private final int ASCII_CODE_a = 97;
	private int highscore;
	private String winningLine;
	public MaxScrabble(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor
		highscore = 0;
	}
	public void processLine(String curLine) {
		char[] simplified = curLine.toLowerCase().toCharArray();
		int score = 0;
		for(int i = 0; i < simplified.length; i++) {
			if(Character.isLetter(simplified[i])) {
				if( i % 4 == 0 ) {
					score += SCRABBLE_SCORES[simplified[i]-ASCII_CODE_a]*2;
				}
				else if( i % 9 == 0 ) {
					score += SCRABBLE_SCORES[simplified[i]-ASCII_CODE_a]*3;
				}
				else {
					score += SCRABBLE_SCORES[simplified[i]-ASCII_CODE_a];
				}
			}
		}
		if(score > highscore) {
			highscore = score;
			winningLine = curLine;
		}
		
	}
	public void printReport() {
		System.out.println("winner: \"" + winningLine.toLowerCase() + "\" score: "+ highscore);
	}
}
	