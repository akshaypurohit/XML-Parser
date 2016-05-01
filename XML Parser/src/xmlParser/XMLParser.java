package xmlParser;

public class XMLParser implements XMLParserInterface {

	private static void displayUsage() {
		System.out.print("XML Parser v1.0\n"
				+ "Usage: XMLParser <SourceFormat> <SourceFileName> <TargetFileName>\n"
				+ "SourceFormat   : Source file format. (Currently only GEDCOM format is supported.)\n"
				+ "SourceFileName : Source file name.\n"
				+ "TargetFileName : Target file name.\n");

	}
	private boolean isSupportedFormat(String fmt)
	{
		if(fmt.equals("GEDCOM"))
			return true;
		return false;
	}

	@Override
	public void parse(String SourceFormat, String SourceFileName, String OutputFileName) {
		// Check if the file format is supported by the parser.
		if(isSupportedFormat(SourceFormat))
		{
			String msgLine = "Parsing "+ SourceFormat +" to XML.\n"
					+ "Source File : " + SourceFileName + "\n"
					+ "Output File : " + OutputFileName + "\n";

			System.out.print(msgLine);
		}
		else 
		{
			String msgLine = SourceFormat + " Format not suported by the parser.\n"; 
			System.out.print(msgLine);
			displayUsage();
		}
	}


	public static void main(String[] args) {
		try
		{
			if(args.length < 3 || args.length > 3)
			{
				displayUsage();
			}
			else
			{
				XMLParser xp = new XMLParser();
				//Splitting up parameters.
				String SourceFormat = args[0].toUpperCase();
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
