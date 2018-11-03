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
		Assert.assertEquals(Double.NaN, temp3.re);
		Assert.assertEquals(InfTemp.im, temp3.im);
		
	}
	
	@Test
	public void doubleToStringTest() {
		Assert.assertEquals("nan", Complex.doubleToString(Double.NaN));
		Assert.assertEquals("-inf", Complex.doubleToString(Double.NEGATIVE_INFINITY));
		Assert.assertEquals("inf", Complex.doubleToString(Double.POSITIVE_INFINITY));
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		a1=(double)Math.round(a1*Math.pow(10, 10))/Math.pow(10, 10);
		String a1String=String.valueOf(a1);
		//可能会错误  因为随机数太小会变成科学计数法
		Assert.assertEquals(a1String, Complex.doubleToString(a1));
	}
	//还未完成 ? :表达式
	@Test
	public void toStringTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		a1=(double)Math.round(a1*Math.pow(10, 10))/Math.pow(10, 10);
		String re=String.valueOf(a1);
		a2=(double)Math.round(a2*Math.pow(10, 10))/Math.pow(10, 10);
		String im=String.valueOf(a2);
		Assert.assertEquals(re+"+"+im+"i", temp1.toString());
		temp1.im=Double.NaN;
		temp1.re=Double.POSITIVE_INFINITY;
		Assert.assertEquals("∞", temp1.toString());
		
		temp1.im=Double.NaN;
		temp1.re=Double.NEGATIVE_INFINITY;
		Assert.assertEquals("-∞", temp1.toString());
		
		temp1.im=Double.NaN;
		temp1.re=Double.NEGATIVE_INFINITY;
		Assert.assertEquals("-∞", temp1.toString());
		temp1.re=Math.pow(10, -11);
		temp1.im=11.0;
		Assert.assertEquals("11i", temp1.toString());
		temp1.re=Math.pow(10, -11);
		temp1.im=Double.POSITIVE_INFINITY;
		Assert.assertEquals("inf*i", temp1.toString());
		
		temp1.re=Math.pow(10, 1);
		temp1.im=Double.POSITIVE_INFINITY;
		Assert.assertEquals("10+inf*i", temp1.toString());
		
		temp1.re=Math.pow(10, 1);
		temp1.im=Math.pow(10, 1);
		Assert.assertEquals("10+10i", temp1.toString());
		
		temp1.re=Math.pow(10, 1);
		temp1.im=-10.0;
		Assert.assertEquals("10-10i", temp1.toString());
		
		
		temp1.re=Math.pow(10, -11);
		temp1.im=Math.pow(10, -11);
		Assert.assertEquals("0", temp1.toString());
		
		temp1.re=Math.pow(10, -9);
		temp1.im=Double.NEGATIVE_INFINITY;
		Assert.assertEquals("0.000000001-inf*i", temp1.toString());
		
		temp1.re=Math.pow(10, -11);
		temp1.im=-Math.pow(10, -9);
		Assert.assertEquals("-0.000000001i", temp1.toString());
	}
	
	@Test
	public void powTest() {
		Complex temp1=new Complex(0,0);
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		double b1=NumGen.nextDouble();
		double b2=NumGen.nextDouble();
		Complex temp2=new Complex(a1,a2);
		
		Complex res1=Complex.pow(temp1, temp2);
		Assert.assertEquals(0.0, res1.re);
		Assert.assertEquals(0.0, res1.im);
		
		temp2.re=-Math.abs(temp2.re);
		temp2.im=0;
		res1=Complex.pow(temp1, temp2);
		Assert.assertEquals(Double.POSITIVE_INFINITY, res1.re);
		Assert.assertEquals(Double.NaN, res1.im);
		
		temp2.re=-Math.abs(a1);
		temp2.im=-Math.abs(a2);
		res1=Complex.pow(temp1, temp2);
		Assert.assertEquals(Double.NaN, res1.re);
		Assert.assertEquals(Double.NaN, res1.im);
		temp1.re=0.1;
		temp1.im=0.1;
		temp2.re=Double.POSITIVE_INFINITY;
		res1=Complex.pow(temp1, temp2);
		Assert.assertEquals(0.0, res1.re);
		Assert.assertEquals(0.0, res1.im);
		
		temp1.re=1.1;
		temp1.im=1.1;
		temp2.re=Double.NEGATIVE_INFINITY;
		res1=Complex.pow(temp1, temp2);
		Assert.assertEquals(0.0, res1.re);
		Assert.assertEquals(0.0, res1.im);
		Complex.pow(new Complex(0,0), new Complex(1,1));
		Complex.pow(new Complex(0,0), new Complex(1,0));
		Complex.pow(new Complex(0,0), new Complex(-1,0));
		Complex.pow(new Complex(0,0), new Complex(-1,1));
		Complex.pow(new Complex(0,0), new Complex(-1,1));
		// 任意输入
		temp1.re=a1;
		temp1.im=a2;
		temp2.re=b1;
		temp2.im=b2;
		Complex res3=Complex.exp(Complex.mul(temp2,Complex.ln(temp1)));
		Assert.assertEquals(res3.re, Complex.pow(temp1, temp2).re);
		Assert.assertEquals(res3.im, Complex.pow(temp1, temp2).im);
		Complex.pow(new Complex(0,1), temp2);
		

	}
	@Test
	public void expTest() {
		Complex temp1=new Complex(Double.NEGATIVE_INFINITY,0);
		Assert.assertEquals(0.0, Complex.exp(temp1).im);
		Assert.assertEquals(0.0, Complex.exp(temp1).re); 
	}
	
	@Test
	public void sqrtTest() {
		Complex temp1=new Complex(0,0);
		Assert.assertEquals(0.0, Complex.sqrt(temp1).re);
		Assert.assertEquals(0.0, Complex.sqrt(temp1).im);
		
		temp1.im=1;
		temp1.re=1;
		
		double norm=temp1.norm().re;
		double cosArg=temp1.re/norm; // invalid for 0
		double sind2=Math.sqrt((1-cosArg)/2);
		double cosd2=Math.sqrt((1+cosArg)/2);
		norm=Math.sqrt(norm);
		Assert.assertEquals(norm*cosd2, Complex.sqrt(temp1).re);
		Assert.assertEquals(norm*sind2, Complex.sqrt(temp1).im);
		
		temp1.im=-1;
		temp1.re=1;
		
		norm=temp1.norm().re;
		cosArg=temp1.re/norm; // invalid for 0
		sind2=-Math.sqrt((1-cosArg)/2);
		cosd2=Math.sqrt((1+cosArg)/2);
		norm=Math.sqrt(norm);
		Assert.assertEquals(norm*cosd2, Complex.sqrt(temp1).re);
		Assert.assertEquals(norm*sind2, Complex.sqrt(temp1).im);
	}
	
	@Test
	public void sinTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		double eip=Math.exp(a2);
		double ein=Math.exp(-a2);
		Assert.assertEquals((eip+ein)*Math.sin(a1)/2, Complex.sin(temp1).re);
		Assert.assertEquals((eip-ein)*Math.cos(a1)/2, Complex.sin(temp1).im);
		
	}
	
	@Test
	public void cosTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		double eip=Math.exp(a2);
		double ein=Math.exp(-a2);
		Assert.assertEquals((eip+ein)*Math.cos(a1)/2, Complex.cos(temp1).re);
		Assert.assertEquals((ein-eip)*Math.sin(a1)/2, Complex.cos(temp1).im);
		
	}
	
	@Test
	public void tanTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		
		double re2=a1*2;
		double im2=a2*2;

		double eip2=Math.exp(im2);
		double ein2=Math.exp(-im2);
		double sinhi2=(eip2-ein2)/2;
		double coshi2=(eip2+ein2)/2;


		double ratio=Math.cos(re2)+coshi2;
		double resRe=Math.sin(re2)/ratio;
		double resIm=sinhi2/ratio;
		
		Assert.assertEquals(resRe, Complex.tan(temp1).re);
		Assert.assertEquals(resIm, Complex.tan(temp1).im);
		
		
	}
	
	@Test
	public void arcsinTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		Complex v=Complex.add(Complex.mul(temp1,Complex.I),Complex.sqrt(Complex.sub(new Complex(1),Complex.mul(temp1,temp1))));
		Complex res1=Complex.mul(new Complex(0,-1),Complex.ln(v));
		
		Assert.assertEquals(res1.re, Complex.arcsin(temp1).re);
		Assert.assertEquals(res1.im, Complex.arcsin(temp1).im);
	}
	
	@Test
	public void arccosTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(a1,a2);
		Complex v=Complex.add(temp1,Complex.sqrt(Complex.sub(Complex.mul(temp1,temp1),new Complex(1))));
		Complex res1=Complex.mul(new Complex(0,-1),Complex.ln(v));
		
		Assert.assertEquals(res1.re, Complex.arccos(temp1).re);
		Assert.assertEquals(res1.im, Complex.arccos(temp1).im);
	}
	@Test
	public void arctanTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(Double.POSITIVE_INFINITY,a2);
		Complex res1=new Complex(Math.PI/2);
		Assert.assertEquals(res1.re,Complex.arctan(temp1).re);
		Assert.assertEquals(res1.im,Complex.arctan(temp1).im);
		temp1.re=Double.NEGATIVE_INFINITY;
		Assert.assertEquals(res1.re,Complex.arctan(temp1).re);
		Assert.assertEquals(res1.im,Complex.arctan(temp1).im);
		temp1.re=a1;
		temp1.im=a2;
		Complex c1=new Complex(1-a2,a1);
		Complex c2=new Complex(1+a2,-a1);
		double re_=(c1.arg().re-c2.arg().re)/2;
		double im_=(Math.log(c2.norm().re)-Math.log(c1.norm().re))/2;
		Assert.assertEquals(re_,Complex.arctan(temp1).re);
		Assert.assertEquals(im_,Complex.arctan(temp1).im);
		
		
	}
	@Test
	public void gammaTest() {
		Random  NumGen=new Random();
		double a1=NumGen.nextDouble();
		double a2=NumGen.nextDouble();
		Complex temp1=new Complex(Double.POSITIVE_INFINITY,0);
		Complex res1=Complex.Inf;
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		Complex.gamma(new Complex(Double.POSITIVE_INFINITY,1));
		temp1.re=Double.NEGATIVE_INFINITY;
		temp1.im=0;
		res1=new Complex();
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.im=a2;
		res1=new Complex(0);
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.re=-311;
		temp1.im=0;
		res1=Complex.Inf;
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		Complex.gamma(new Complex(-311.1,0));
		Complex.gamma(new Complex(Double.POSITIVE_INFINITY,0));
		temp1.im=-1;
		res1=new Complex(0);
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.re=-1;
		temp1.im=0;
		int k=(int)Math.floor(-temp1.re)+1;
		res1=Complex.gamma(new Complex(temp1.re+k,temp1.im));
		for(int i=k-1;i>=0;i--){ // reversed order, prevent 0/0 -> NaN
			if(!res1.isFinite())
				break;
			res1=Complex.div(res1,new Complex(temp1.re+i,temp1.im));
		
		}
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.re=143;
		temp1.im=1;
		double kd=Math.ceil(temp1.re-142);
		long k1=(long)kd;
		res1=Complex.gamma(new Complex(temp1.re-kd,temp1.im));
		if(res1.re!=0||res1.im!=0){
			for(long i=1;i<=k1;i++){
				if(!res1.isFinite()) break;
				res1=Complex.mul(res1,new Complex(temp1.re-i,temp1.im));
			}
		}
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.re=0.00001;
		temp1.im=0.0001;
		res1=new Complex(0);
		for(int i=5;i>=0;i--){
			res1=Complex.mul(res1,temp1);
			res1=new Complex(res1.re+temp1.gammaT[i],res1.im);
		}
		res1=Complex.add(res1,Complex.div(new Complex(1),temp1));
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
		temp1.re=0.1;
		temp1.im=220;
		Complex sZ=Complex.sin(Complex.mul(Complex.PI,temp1));
		Complex gZ=Complex.gamma(Complex.sub(new Complex(1),temp1));
		//Log.i("Gamma","sZ="+sZ+" gZ="+gZ);
		res1=Complex.div(Complex.PI,Complex.mul(sZ,gZ));
		Assert.assertEquals(res1.re,Complex.gamma(temp1).re);
		Assert.assertEquals(res1.im,Complex.gamma(temp1).im);
		
	}
	
	
}
