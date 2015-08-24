package co.uk.alesto.num2words;

/**
 * The main API class that implements the NumberToTextConverter interface
 * and can potentially offer more than one locale converter.
 * This class uses a Singleton pattern.
 * 
 * @author asto
 *
 */
public enum Num2WordsConverter implements NumberToTextConverter{

	INSTANCE_EN(new NumberToTextEnglishConverter());
	//More locale instances can be added here
	
	/** The main converter based on the chosen locale instance **/
	private NumberToTextConverter converter;
	
	private Num2WordsConverter(NumberToTextConverter convertor)
	{
		this.converter = convertor;
	}
	
	public String convertNumberToText(int number) {
		return converter.convertNumberToText(number);
	}
	
	
}
