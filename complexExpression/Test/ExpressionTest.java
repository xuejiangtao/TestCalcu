package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Calcu.*;
import junit.framework.Assert;
import Calcu.Expression;

public class ExpressionTest {
	Expression exp[] = new Expression[20];
	
	@Test
	public void test() {
		exp[0] = new Expression("fzero(eval(1/2+1/ln(x-1)+2integ(sin(reg*arctan(x))/(1+x^2)^(reg/2)/(exp(2πx)-1),0,∞),reg(x)),14i)");
		exp[0].value();
		
		exp[1] = new Expression("(1+2");
		exp[1].value();
		
		exp[2] = new Expression("");
		exp[2].value();
		
		exp[3] = new Expression("pow(((1+(1+2))-(1+2E2)),pi)");
		exp[3].value();
		
		exp[4] = new Expression("D2+F2");
		exp[4].value();
		
		exp[5] = new Expression("2+3+");
		exp[5].value();
		
		exp[6] = new Expression("re(1)+im(1)+sqrt(1)+abs(-1)+norm(1.11)+arg(1)+cos(1)+tan(2)+arcsin(2)+arccos(2)+gamma(1)+floor(1)+ceil(2)+reg()+conj(1)+rand()+rand(1)+round(1)+round(1,2)+diff(1,2)+diff(1,2,3)+limit(1,2)+limit(1,2,3)");
		exp[6].value();
		
		exp[7] = new Expression("sum(1,2,3)+perm(1)+perm(1,2)+comb(1,2)+prec()+prec(1)+base()+base(2)+base(13)");
		exp[7].value();
		
		exp[8] = new Expression("prec(99)");
		exp[8].value();
		
		exp[9] = new Expression("prec(1,2,3,4)");
		exp[9].value();
		
		exp[10] = new Expression("tan(π/√2)");
		exp[10].value();
		exp[10].stopEvaluation();
		
		exp[11] = new Expression("-3*(6+2.5)/4E2-.7*-1.01π");
		exp[11].value();
		
		exp[12] = new Expression("fzero(x^2-x-1,4F1)");
		exp[12].value();

		exp[13] = new Expression("");
		exp[13].value();
		
		exp[14] = new Expression("fzero(eval(√(-x)-2,reg(+x)),14i)");
		exp[14].value();
		
		exp[15] = new Expression("sum(eval(√(-x)-2),10,1)");
		exp[15].value();
		
		exp[15] = new Expression("sum(eval(x,reg(x)),10,∞");
		exp[15].value();
		
		exp[16] = new Expression("+");
		exp[16].value();
	}

}