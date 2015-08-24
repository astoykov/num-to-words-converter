package co.uk.alesto.num2words;

/** 
 * A particular British English base version of the base converter
 * @author asto
 *
 */
public class NumberToTextEnglishConverter extends NumberToTextConverterBase {

	public NumberToTextEnglishConverter()
	{
		super(new String[]{
		    "",
		    " thousand",
		    " million",
		    " billion"
		  },new ThreeDigitEnglishConverter());
	}

}
