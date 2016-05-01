/**
 * 
 */
package xmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author puraks01
 *
 */
public class FileHandler {

	public ArrayList<String> getFileContents(String filename)
	{
		ArrayList<String> srcContents = new ArrayList<String>();
		try
		{
			Scanner s = new Scanner(new File(filename));
			s.useDelimiter(System.getProperty("line.separator"));	
			while (s.hasNext()){
				srcContents.add(s.next().toString());
			}
			s.close(); 
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return srcContents;
	}
}
