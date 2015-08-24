package co.uk.alesto.num2words;

/**
 * Converts a three digit number into British English text
 * 
 * @author asto
 *
 */
public class ThreeDigitEnglishConverter implements NumberToTextConverter{

	private static final String[] numNames = {
	    "",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine",
	    " ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"
	  };
	
	private static final String[] tensNames = {
	    "",
	    " ten",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	  };

	public String convertNumberToText(int number) {
	    String words;
	    
	    //Process the last two numbers
	    if (number % 100 < 20){ //If last two are in the teens or less
	    	words = numNames[number % 100];
	      number /= 100; //get the hundreds
	    }else {//Or convert using names of tens
	    	words = numNames[number % 10];
	      number /= 10;//get the tens

	      words = tensNames[number % 10] + words;
	      number /= 10;//get the hundreds
	    }
	    if (number == 0) return words;
	    return numNames[number] + " hundred" + (words.length()>0?" and":"") + words;
	  }
}
