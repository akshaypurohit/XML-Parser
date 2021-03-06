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
public class TestXmlParser {

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
		assertEquals(defaultOutput, outContent.toString());
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
		assertEquals(msgLine,outContent.toString());
	}
	
	@Test
	public void TestParserWithThreeParametersLowerCase()
	{
		String[] params = {"gedcom", "SampleInput.txt", "SampleOutput.txt"};
		String msgLine = "Parsing GEDCOM to XML.\n"
				+ "Source File : SampleInput.txt\n"
				+ "Output File : SampleOutput.txt\n";
		// Calling main function with all three parameters.
		XMLParser.main(params);
		assertEquals(msgLine,outContent.toString());
	}
	
	@Test
	public void TestParserWithUnsuportedFormat()
	{
		String[] params = {"HTML", "SampleInput.txt", "SampleOutput.txt"};
		String msgLine = "HTML Format not suported by the parser.\n" + defaultOutput;
		// Calling main function with all three parameters.
		XMLParser.main(params);
		assertEquals(msgLine, outContent.toString());
	}
	
}
