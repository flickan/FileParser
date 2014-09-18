import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class parses text file with a given name and counts number of lines, words and characters in the text file.
 */
public class ContentAnalyzer {

	/**
	 * Constructor.
	 * @param fileName codes file name (with path if necessary). 
	 */
	public ContentAnalyzer(String fileName) {
		_fileName = fileName;
	}

	/**
	 * Reads file with a given name and count number of lines, words and characters in that file.
	 * @throws IOException in case when given file can not be found.
	 */
	public void analyzeFileContent() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(_fileName));
		
		try {
			String line = br.readLine();

			while (line != null) {
				_numberOfLines++;
				_numberOfWords += line.trim().split("\\s+").length;
				_numberOfCharacters += line.replaceAll("\\s+", "").length();
				
				line = br.readLine();
			}
		} finally {
			br.close();
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

	/**
	 * Name of a file containing the path to that file.
	 */
	private String _fileName;
	
	/**
	 * Counts number of characters in a file. 
	 */
	private int _numberOfCharacters = 0;
	
	/**
	 * Counts number of lines in a file.
	 */
	private int _numberOfLines = 0;
	
	/**
	 * Counts number of words in a file.
	 */
	private int _numberOfWords = 0;
}
