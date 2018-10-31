package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import Calcu.Expression;
import Calcu.ParseNumber;
import junit.framework.Assert;


public class ParseNumberTest{
	@Test
	public void isBaseSymbolTest() {
		ParseNumber temp=new ParseNumber();
		
		Assert.assertEquals(false, ParseNumber.isBaseSymbol('0'));
		Assert.assertEquals(true, ParseNumber.isBaseSymbol('₉'));
		//Assert.assertEquals(1.0,ParseNumber.parseCompat("1~2"));
		//Assert.assertEquals(10,ParseNumber.parseCompat("A"));
		
	}
	@Test(expected = NumberFormatException.class)
	//@Test
	public void parseTest1() {
		
		
		Assert.assertEquals(10,ParseNumber.parse("1E1"));
	}
	@Test(expected = NumberFormatException.class)
	//@Test
	public void parseTest2() {
		
		
		Assert.assertEquals(10,ParseNumber.parse("₂"));
	}
	
	@Test
	public void parseTest3() {
		
			
		
		Assert.assertEquals(2.0,ParseNumber.parse("1₂1"));
		Assert.assertEquals(1.0,ParseNumber.parse("1₂"));	
		Assert.assertEquals(11.0,ParseNumber.parse("11~10"));
		
	}
	
	@Test
	public void parseCompatTest1() {
		Assert.assertEquals(11.0, ParseNumber.parseCompat("11~10"));
	}
	
	@Test(expected = NumberFormatException.class)
	public void parseCompatTest2() {
		Assert.assertEquals(11.0, ParseNumber.parseCompat("11~11"));
	}
	
	@Test
	public void getDigitTest1() {
		for(int i=0;i<10;i++) {
			Assert.assertEquals(i, ParseNumber.getDigit((char)('0'+i), 10));
		}
		for(int j=0;j<6;j++) {
			Assert.assertEquals(j+10, ParseNumber.getDigit((char)('A'+j), 16));
		}
	}
	@Test(expected = NumberFormatException.class)
	//@Test
	public void getDigitTest2() {
		
		
		Assert.assertEquals(10, ParseNumber.getDigit('G', 16));
	}
	@Test(expected = NumberFormatException.class)
	//@Test
	public void getDigitTest3() {
		
		
		Assert.assertEquals(10, ParseNumber.getDigit('A', 10));
	}
	
	
	@Test
	public void toBaseStringTest() {
		double NanNum=new Double(0.0/0.0);
		Assert.assertEquals("1.1₄2",ParseNumber.toBaseString(20.2, 4, 2));
		Assert.assertEquals("1.2E2",ParseNumber.toBaseString(123.456, 10, 2));
		Assert.assertEquals("3E-4",ParseNumber.toBaseString(0.0003, 10, 3));
		Assert.assertEquals("1.31",ParseNumber.toBaseString(1.31231, 10, 3));
		Assert.assertEquals("10₂",ParseNumber.toBaseString(2.0, 2, 2));
		Assert.assertEquals("nan",ParseNumber.toBaseString(NanNum, 2, 2));
		Assert.assertEquals("inf",ParseNumber.toBaseString(Double.POSITIVE_INFINITY, 2, 2));
		Assert.assertEquals("-inf",ParseNumber.toBaseString(Double.NEGATIVE_INFINITY, 2, 2));
		Assert.assertEquals("-1", ParseNumber.toBaseString(-1.0, 10, 2));
	}
	
	@Test
	public void toPositiveRawBaseStringTest() {
		Assert.assertEquals("0", ParseNumber.toPositiveRawBaseString(0.001, 10, 2));
		Assert.assertEquals("0", ParseNumber.toPositiveRawBaseString(0.001, 10, -1));
	}
	
	@Test
	public void parseRawTest() {
		Assert.assertEquals(12.34, ParseNumber.parseRaw("12.34", 10));
		
	}
	
	
}