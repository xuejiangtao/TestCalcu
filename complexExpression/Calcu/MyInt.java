package Calcu;

public class MyInt {
	public int ee;
	public MyInt(int aa){
		ee=aa;
	}
	public MyInt add(MyInt a, MyInt b,String s ) {
		return new MyInt(a.ee+b.ee);
	}

}
