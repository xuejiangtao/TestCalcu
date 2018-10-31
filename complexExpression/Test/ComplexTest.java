package Test;

import static org.junit.Assert.*;
import Calcu.*;
import junit.framework.Assert;

import org.junit.Test;
import java.util.Random;

public class ComplexTest {

	@Test
	public void ComplexTest() {
		Complex temp1=new Complex(1,1);
		Complex temp2=new Complex(2);
		Complex NanTemp=new Complex();

	}
	@Test
	public void addTest() {
		Complex temp1=new Complex(1,1);
		Complex temp2=new Complex(2,2);
		Complex temp3=new Complex(3,3);
		Complex NanTemp=new Complex();
		Assert.assertEquals(temp3.re, Complex.add(temp1, temp2).re);
		Assert.assertEquals(temp3.im, Complex.add(temp1, temp2).im);
	}
	
	@Test
	public void subTest() {
		Complex temp1=new Complex(1,1);
		Complex temp2=new Complex(2,2);
		Complex temp3=new Complex(3,3);
		Complex NanTemp=new Complex();
		Assert.assertEquals(temp1.re, Complex.sub(temp3, temp2).re);
		Assert.assertEquals(temp1.im, Complex.sub(temp3, temp2).im);
	}
	
	@Test
	public void invTest() {
		Complex temp1=new Complex(1,1);
		Complex NanTemp=new Complex();
		Assert.assertEquals(-temp1.re, Complex.inv(temp1).re);
		Assert.assertEquals(-temp1.im, Complex.inv(temp1).im);
	}
	
	@Test
	public void mulTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		double b1=NumGen.nextDouble();
		double b2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		Complex temp2=new Complex(b1,b2);
		double c1=a1*b1-a2*b2;
		double c2=a1*b2+a2*b1;
		Assert.assertEquals(c1, Complex.mul(temp1, temp2).re);
		Assert.assertEquals(c2, Complex.mul(temp1, temp2).im);
	}
	
	@Test
	public void norm2Test() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		double c1=a1*a1+a2*a2;
		Assert.assertEquals(c1, temp1.norm2());
		temp1.re=Double.POSITIVE_INFINITY;
		temp1.im=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
	}
	
	@Test
	public void normTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		double c1=Math.hypot(a1,a2);
		Complex temp2=new Complex(c1);
		Assert.assertEquals(temp2.im, temp1.norm().im);
		Assert.assertEquals(temp2.re, temp1.norm().re);
		/*
		
		temp1.im=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2()); */
	}
	
	@Test
	public void argTest() {
		
		Complex temp1=new Complex(0,0);
		Complex temp2=new Complex(Double.NaN);
		Assert.assertEquals(temp2.im, temp1.arg().im);
		Assert.assertEquals(temp2.re, temp1.arg().re);
		
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		temp1.im=a1;
		double b1=Math.atan2(temp1.im, temp1.re);
		Complex temp3=new Complex(b1);
		Assert.assertEquals(temp3.im, temp1.arg().im);
		Assert.assertEquals(temp3.re, temp1.arg().re);
		
		temp1.im=0;
		temp1.re=a2;
		double b2=Math.atan2(temp1.im, temp1.re);
		Complex temp4=new Complex(b2);
		Assert.assertEquals(temp4.im, temp1.arg().im);
		Assert.assertEquals(temp4.re, temp1.arg().re);
		
		/*
		
		temp1.im=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=0;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2());
		temp1.im=Double.POSITIVE_INFINITY;
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals(Double.POSITIVE_INFINITY, temp1.norm2()); */
	}
	
	@Test
	public void isNaNTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(Double.NaN);
		Complex temp2=new Complex(a1,a2);
		Assert.assertEquals(true, temp1.isNaN());
		Assert.assertEquals(false, temp2.isNaN());
	}
	@Test
	public void isDoubleFiniteTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		Assert.assertEquals(true, Complex.isDoubleFinite(a1)); 
		Assert.assertEquals(false, Complex.isDoubleFinite(Double.NaN)); 
		Assert.assertEquals(false, Complex.isDoubleFinite(Double.POSITIVE_INFINITY)); 
	}
	@Test
	public void isFiniteTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		Assert.assertEquals(true, temp1.isFinite());
		temp1.im=Double.POSITIVE_INFINITY;
		Assert.assertEquals(false, temp1.isFinite());
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals(false, temp1.isFinite());
	}
	
	@Test
	public void isValidTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		Assert.assertEquals(true, temp1.isValid());
		temp1.im=Double.POSITIVE_INFINITY;
		Assert.assertEquals(true, temp1.isValid());
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals(true, temp1.isValid());
		temp1.im=Double.NaN;
		temp1.re=NumGen.nextDouble();
		Assert.assertEquals(false, temp1.isValid());
	}
	
	@Test
	public void divTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		double b1=NumGen.nextDouble();
		double b2=NumGen.nextDouble();
		Complex temp2=new Complex(b1,b2);
		
		double aNorm=temp1.norm().re;
		double bNorm=temp2.norm().re;
		
		double ure=b1/bNorm; // prevent overflow on a.re*b.re
		double uim=b2/bNorm;
		double re=(a1*ure+a2*uim)/bNorm; // prevent overflow on bnorm^2
		double im=(a2*ure-a1*uim)/bNorm;
		Assert.assertEquals(re, Complex.div(temp1, temp2).re);
		Assert.assertEquals(im, Complex.div(temp1, temp2).im);
		Complex InfTemp=new Complex(Double.POSITIVE_INFINITY,Double.NaN);
		
		Complex temp3=Complex.div(temp1, new Complex(0,0));
		Assert.assertEquals(InfTemp.re, temp3.re);
		Assert.assertEquals(InfTemp.im, temp3.im);
		
		
	}
	
}
