package co.uk.alesto.num2words;

import java.text.DecimalFormat;


/**
 * A base class to implement a default conversion method to be reused by all subclasses.
 * It partially uses the Composite pattern.
 * @author asto
 *
 */
public class NumberToTextConverterBase implements NumberToTextConverter {

	/** The three digit group names **/
	private final String[] groupsNames;
	
	/** A number to words converter for a three digits group **/
	private final NumberToTextConverter threeDigitsConverter;
	
	public NumberToTextConverterBase(String[] groupsNames, 
			NumberToTextConverter threeDigitsConverter)
	{
		this.groupsNames = groupsNames;
		this.threeDigitsConverter = threeDigitsConverter;
	}
	
	public String convertNumberToText(int number) {
		//If 0 then just return zero
	    if (number == 0) { return "zero"; }

	    String snumber = Integer.toString(number);

	    // pad with zeros to complete the three digit groups
	    
	    String mask = new String(new char[snumber.length() + (3-snumber.length() % 3)]).replace("\0", "0");
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);
	    
	    //split the text number into groups of three digits
	    String[] threeDigitGroups = snumber.split("(?<=\\G.{3})");
	    
	    if (threeDigitGroups.length > groupsNames.length)
	    	throw new IllegalArgumentException("Sorry, the converter does not support such large numbers yet");
	    
	    //Iterating from left to right convert and name each three digit group
	    String resultText="";
	    for(int i = 0; i<threeDigitGroups.length; i++)
	    {
	    	String groupText = threeDigitsConverter.convertNumberToText(
	    			Integer.parseInt(threeDigitGroups[i]));
	    	//Put an extra and if the next group is last and is less than 100
	    	if(i == threeDigitGroups.length-1 && threeDigitGroups.length>1 && Integer.parseInt(threeDigitGroups[i])<100)
	    		resultText+=" and";
	    	
	    	resultText += groupText + (groupText.length()>0?groupsNames[threeDigitGroups.length-i-1]:"");
	    }
	    
	    return resultText.trim();
	}

}
