package xmlParser;

public class XMLParser implements XMLParserInterface {

	private static void displayUsage() {
		System.out.print("XML Parser v1.0\n"
				+ "Usage: XMLParser <SourceFormat> <SourceFileName> <TargetFileName>\n"
				+ "SourceFormat   : Source file format. (Currently only GEDCOM format is supported.)\n"
				+ "SourceFileName : Source file name.\n"
				+ "TargetFileName : Target file name.\n");

	}

	@Override
	public void parse(String SourceFormat, String SourceFileName, String OutputFileName) {
		String msgLine = "Parsing "+ SourceFormat +" to XML.\n"
				+ "Source File : " + SourceFileName + "\n"
				+ "Output File : " + OutputFileName + "\n";
		System.out.print(msgLine);
	}
	
	public static void main(String[] args) {
		try
		{
			XMLParser xp = new XMLParser();
			if(args.length < 3 || args.length > 3)
			{
				displayUsage();
			}
			else
			{
				//Splitting up parameters.
				String SourceFormat = args[0];
				String SourceFile   = args[1];
				String OutputFile   = args[2];
				xp.parse(SourceFormat,SourceFile,OutputFile);
	
			}
		}
		catch(Exception e)
		{
			displayUsage();
		}

	}



}
