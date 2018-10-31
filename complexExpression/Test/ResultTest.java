package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Calcu.*;
import junit.framework.Assert;

public class ResultTest {

	@Test
	public void ResultTest() {
		Complex temp=new Complex(1.0,1.0);
		Result ComplexTemp=new Result(temp);
		Result ReaTemp=new Result(1);
		ReaTemp.append("11", "22", 3, 4);
		ReaTemp.setBase(10);
		ReaTemp.setVal(temp);
		ReaTemp.err=0;
		Assert.assertEquals(false, ReaTemp.isFatalError());
		ComplexTemp.err=1;
		Assert.assertEquals(true, ComplexTemp.isFatalError());
		//fail("Not yet implemented");
	}

}
