package Test;
import static org.junit.Assert.*;

import org.junit.Test;
import Calcu.ParseNumber;
import junit.framework.Assert;


public class ParseNumberTest{
	@Test
	public void isBaseSymbolTest() {
		
		Assert.assertEquals(false, ParseNumber.isBaseSymbol('0'));
		Assert.assertEquals(false, ParseNumber.isBaseSymbol('₉'));
		Assert.assertEquals(1.0,ParseNumber.parseCompat("1~2"));
		
	}
}