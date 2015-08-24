package co.uk.alesto.num2words;

/**
 * A common interface for all number to text converters
 * @author asto
 *
 */
public interface NumberToTextConverter {
	
	/**
	 * Converts number to text
	 * @param number the integer number to convert
	 * @return the word representation of the number
	 */
	public String convertNumberToText(int number);
}
