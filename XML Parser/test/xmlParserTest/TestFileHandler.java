/**
 * 
 */
package xmlParserTest;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import xmlParser.FileHandler;

/**
 * @author Akshay Purohit
 *
 */
public class TestFileHandler {

	@Before
	public void createTestFile() throws IOException
	{
		String str = "TestFile Content";
		
		FileWriter fw = new FileWriter("testfile.txt");
		fw.write(str);
		fw.close();
	}
	@Test
	public void TestToReadFileInArrayList()
	{
		ArrayList<String> expectedContent = new ArrayList<String>();
		expectedContent.add("TestFile Content");
		FileHandler fh = new FileHandler();
		ArrayList<String> actualContent = fh.getFileContents("testfile.txt");
		assertEquals(expectedContent,actualContent);
	}
	
}
