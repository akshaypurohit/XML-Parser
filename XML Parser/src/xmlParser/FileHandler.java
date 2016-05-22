/**
 * 
 */
package xmlParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;


/**
 * @author puraks01
 *
 */
public class FileHandler {

	public ArrayList<String> getFileContents(String filename)
	{
		ArrayList<String> srcContents = new ArrayList<String>();
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(filename));

			while ((sCurrentLine = br.readLine()) != null) 
			{
				srcContents.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return srcContents;
	}
	
	public void writeArrayListToFile(String filename, ArrayList<String> content) throws IOException
	{
		FileWriter writer = new FileWriter(filename);
		ListIterator<String> itr = content.listIterator();
		while(itr.hasNext()) {
		  writer.write(itr.next() + "\n");
		}
		writer.close();
	}
}
