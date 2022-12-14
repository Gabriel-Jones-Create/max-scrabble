import java.util.Scanner;

/**
 * If given a text file, run Max Scrabble and find the line with the highest
 * score based on adjusted scrabble rules, then print that line, and its score.
 * 
 * @author gabrieljones
 *
 */
public class MaxScrabbleTester {
	public static void main(String args[]) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter file name");
			String filename = scanner.next();
			MaxScrabble scrabble = new MaxScrabble(filename);
			scrabble.processFile();
			scrabble.printReport();
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
