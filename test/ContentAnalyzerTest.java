import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 *	Test class for {@link ContentAnalyzer}.
 */
public class ContentAnalyzerTest {

	/**
	 * Test for file with one word in line.
	 * @throws IOException 
	 */
	@Test
	public void testOneWordInLine() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file1.txt");
		analyzer.analyzeFileContent();

		assertEquals(6, analyzer.getNumberOfLines());
		assertEquals(6, analyzer.getNumberOfWords());
		assertEquals(31, analyzer.getNumberOfCharacters());

	}

	/**
	 * Test for a file with several words in line.
	 * @throws IOException 
	 */
	@Test
	public void testMultipleWordsinLine() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file2.txt");
		analyzer.analyzeFileContent();
		
		assertEquals(2, analyzer.getNumberOfLines());
		assertEquals(8, analyzer.getNumberOfWords());
		assertEquals(36, analyzer.getNumberOfCharacters());
		
	}

	/**
	 * Test for an empty file.
	 * @throws IOException 
	 */
	@Test
	public void testEmptyFile() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file3.txt");
		analyzer.analyzeFileContent();
		
		assertEquals(0, analyzer.getNumberOfLines());
		assertEquals(0, analyzer.getNumberOfWords());
		assertEquals(0, analyzer.getNumberOfCharacters());
		
	}

	/**
	 * Test for a file with empty lines.
	 * @throws IOException 
	 */
	@Test
	public void testEmptyLine() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file4.txt");
		analyzer.analyzeFileContent();

		assertEquals(7, analyzer.getNumberOfLines());
		assertEquals(0, analyzer.getNumberOfWords());
		assertEquals(0, analyzer.getNumberOfCharacters());

	}

	/**
	 * Test for a file with many special characters.
	 * @throws IOException 
	 */
	@Test
	public void testFileWithSpecialCharacters() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file5.txt");
		analyzer.analyzeFileContent();
		
		assertEquals(2, analyzer.getNumberOfLines());
		assertEquals(8, analyzer.getNumberOfWords());
		assertEquals(78, analyzer.getNumberOfCharacters());
		
	}
	
	/**
	 * Test for a file with a lot of empty space.
	 * @throws IOException 
	 */
	@Test
	public void testFileWithAlLotOfEmptySpace() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file6.txt");
		analyzer.analyzeFileContent();
		
		assertEquals(19, analyzer.getNumberOfLines());
		assertEquals(16, analyzer.getNumberOfWords());
		assertEquals(63, analyzer.getNumberOfCharacters());
		
	}
	
	/**
	 * Test for a non existing file.
	 * @throws IOException 
	 */
	@Test(expected = Exception.class)  
	public void testNonExistingFile() throws IOException {
		ContentAnalyzer analyzer = new ContentAnalyzer("input/file777.txt");
		analyzer.analyzeFileContent();
	}

}
