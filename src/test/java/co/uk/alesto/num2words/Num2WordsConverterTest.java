package co.uk.alesto.num2words;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Num2WordsConverterTest 
    extends TestCase
{
    NumberToTextConverter converter = Num2WordsConverter.INSTANCE_EN;
    
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Num2WordsConverterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Num2WordsConverterTest.class );
    }
    
    
    public void testBorderCases()
    {
    	Assert.assertEquals("zero",converter.convertNumberToText(0));
    	Assert.assertEquals("ten thousand and one",converter.convertNumberToText(10001));
    	Assert.assertEquals("one hundred million and one",converter.convertNumberToText(100000001));
    	Assert.assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",converter.convertNumberToText(999999999));
    }

    public void testSmallNumbers()
    {
    	Assert.assertEquals("one",converter.convertNumberToText(1));
    	Assert.assertEquals("twenty one",converter.convertNumberToText(21));
    	Assert.assertEquals("one hundred and five",converter.convertNumberToText(105));
    	Assert.assertEquals("one hundred and twenty three",converter.convertNumberToText(123));
    }
    
    public void testThousands()
    {
    	Assert.assertEquals("one thousand and five",converter.convertNumberToText(1005));
    	Assert.assertEquals("one thousand and forty two",converter.convertNumberToText(1042));
    	Assert.assertEquals("one thousand one hundred and five",converter.convertNumberToText(1105));
    }
    
    public void testMillions()
    {
    	Assert.assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",converter.convertNumberToText(56945781));
    }
    
}
