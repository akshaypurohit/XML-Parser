package xmlParser;

import java.util.ArrayList;
import java.util.ListIterator;

public class GEDCOMtoXMLGenerator {

	private ArrayList<String> tagStack = new ArrayList<String>();
	private int top = -1;
	
	public ArrayList<String> generateXML(ArrayList<String> input)
	{
		ArrayList<String> output = new ArrayList<String>();
		if(!input.isEmpty())
		{
			output.add("<GEDCOM>");
			
			ListIterator<String> itr = input.listIterator();
			while(itr.hasNext()) 
			{
				output.add(toXML(itr.next()));
			}
			if(!tagStack.isEmpty())
			{
				output.add(closingTag(pop()));
			}
			output.add("</GEDCOM>");
		}
		return output;
	}

	private String toXML(String str) {
		String returnStr = null;
		String arr[];
		arr = str.split("\\s+");
		
		if(arr.length == 3)
		{
			// If ID tag
			if(arr[1].matches("@(.*)@"))
			{
				returnStr = "<" + arr[2] + " id=\"" + arr[1] + "\">";
				push(arr[2]);
			}
		}
		return returnStr;
	}

	private void push(String str) {
		tagStack.add(str);
		top++;
	}
	
	private String pop() {
		String returnStr = tagStack.get(top);
		tagStack.remove(top--);
		return returnStr;
	}
	private String closingTag(String str) {
		return "</" + str +">";
	}	
	
}
