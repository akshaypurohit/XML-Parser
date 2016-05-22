package xmlParserTest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xmlParser.GEDCOMtoXMLGenerator;

public class TestGEDCOMtoXMLGenerator {
	
@Test
public void TestToGenerateIDTag()
{
	ArrayList<String> input = new ArrayList<String>();
    ArrayList<String> expectedOutput = new ArrayList<String>();
    
	input.add("0 @I1@ INDI");
	// output
	expectedOutput.add("<GEDCOM>");
	expectedOutput.add("<INDI id=\"@I1@\">");
	expectedOutput.add("</INDI>");
	expectedOutput.add("</GEDCOM>");
	
	
	GEDCOMtoXMLGenerator newGenerator = new GEDCOMtoXMLGenerator();
	
	ArrayList<String> output = newGenerator.generateXML(input);
	
	assertEquals(output.toString(),expectedOutput.toString());
}

}
