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
		
		//Assert.assertEquals(1.1, ParseNumber.parse("1.1"));
		Expression expr=new Expression("fzero(eval(1/2+1/(x-1)+2integ(sin(reg*arctan(x))/(1+x^2)^(reg/2)/(exp(2πx)-1),0,∞),reg(x)),14i)");
		Assert.assertEquals(-1, expr.value().val);
		/*Assert.assertEquals(true, ParseNumber.isBaseSymbol('₉'));
		Assert.assertEquals(1.0,ParseNumber.parseCompat("1~2"));
		Assert.assertEquals(10,ParseNumber.parseCompat("A"));*/
		
	}
	
	
}