package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import Calcu.Expression;
import Calcu.ParseNumber;
import junit.framework.Assert;


public class ParseNumberTest{
	@Test
	public void isBaseSymbolTest() {
		
		Assert.assertEquals(false, ParseNumber.isBaseSymbol('0'));
		Assert.assertEquals(true, ParseNumber.isBaseSymbol('₉'));
		Assert.assertEquals(1.0,ParseNumber.parseCompat("1~2"));
		//Assert.assertEquals(10,ParseNumber.parseCompat("A"));
		
	}
	@Test
	public void parseTest() {
		
		try{
			Assert.assertEquals(10,ParseNumber.parse("1E1"));
		}
		catch (Exception e){
			System.out.println(e);
		}
			
		//Assert.assertEquals(0,ParseNumber.parse("₉"));
		Assert.assertEquals(2.0,ParseNumber.parse("1₂1"));
		Assert.assertEquals(2.0,ParseNumber.parse("1₂"));
		try{
			Assert.assertEquals(Double.POSITIVE_INFINITY,ParseNumber.parse("inf"));
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		
		
		
	}
	@Test
	public void toBaseStringTest() {
		Assert.assertEquals("1",ParseNumber.toBaseString(2.0, 2, 2));
	}
	
	
}