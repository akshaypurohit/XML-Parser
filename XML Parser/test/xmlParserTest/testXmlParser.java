/**
 * 
 */
package xmlParserTest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xmlParser.XMLParser;

/**
 * @author Akshay Purohit
 *
 */
public class testXmlParser {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	private String defaultOutput = "XML Parser v1.0\n"
			+ "Usage: XMLParser <SourceFormat> <SourceFileName> <TargetFileName>\n"
			+ "SourceFormat   : Source file format. (Currently only GEDCOM format is supported.)\n"
			+ "SourceFileName : Source file name.\n"
			+ "TargetFileName : Target file name.\n";
	
	
	@Test
	public void TestParserWithoutParameter()
	{
		// Calling main function without any parameters.
		XMLParser.main(null);
		assertEquals(outContent.toString(),defaultOutput);
	}
	
	@Test
	public void TestParserWithThreeParameters()
	{
		String[] params = {"GEDCOM", "SampleInput.txt", "SampleOutput.txt"};
		String msgLine = "Parsing GEDCOM to XML.\n"
				+ "Source File : SampleInput.txt\n"
				+ "Output File : SampleOutput.txt\n";
		// Calling main function with all three parameters.
		XMLParser.main(params);
		assertEquals(outContent.toString(), msgLine);
	}
	
}
