import java.io.IOException;

/**
 * Class takes file names with their paths as argument and calls {@link ContentAnalyzer}.
 *
 */
public class Parser {

	public static void main(String[] args) throws IOException {

		for (String s : args) {
			
			ContentAnalyzer analyzer = new ContentAnalyzer(s);
			analyzer.analyzeFileContent();
			
			System.out.println("================================================");
			System.out.println("File: " + s);
			System.out.println("Number of Lines: " + analyzer.getNumberOfLines());
			System.out.println("Number of Words: " + analyzer.getNumberOfWords());
			System.out.println("Number of Characters: " + analyzer.getNumberOfCharacters());
		}
	}
}
