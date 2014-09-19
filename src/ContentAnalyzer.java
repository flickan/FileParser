import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Class parses text file with a given name and counts number of lines, words
 * and characters in the text file.
 */
public class ContentAnalyzer {

	/**
	 * Name of a file containing the path to that file.
	 */
	private String _fileName;

	/**
	 * Counts number of characters in a file.
	 */
	private int _numberOfCharacters;

	/**
	 * Counts number of lines in a file.
	 */
	private int _numberOfLines;

	/**
	 * Counts number of words in a file.
	 */
	private int _numberOfWords;

	/**
	 * Constructor.
	 * 
	 * @param fileName
	 *            codes file name (with path if necessary).
	 */
	public ContentAnalyzer(String fileName) {
		_fileName = fileName;
	}

	/**
	 * Reads file with a given name and count number of lines, words and
	 * characters in that file.
	 * 
	 * @throws IOException
	 *             in case when given file can not be found.
	 */
	public void analyzeFileContent() throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(_fileName))) {
			String line = br.readLine();

			while (line != null) {
				_numberOfLines++;
				StringTokenizer st = new StringTokenizer(line);
				while (st.hasMoreTokens()) {
					_numberOfWords++;
					_numberOfCharacters += st.nextToken().length();
				}
				line = br.readLine();
			}
		}
	}

	/**
	 * @return {@link _numberOfCharacters}
	 */
	public int getNumberOfCharacters() {
		return _numberOfCharacters;
	}

	/**
	 * @return {@link _numberOfLines}
	 */
	public int getNumberOfLines() {
		return _numberOfLines;
	}

	/**
	 * @return {@link _numberOfWords}
	 */
	public int getNumberOfWords() {
		return _numberOfWords;
	}
}
