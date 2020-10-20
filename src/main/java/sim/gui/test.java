package sim.gui;

public class test
{
	public static void main(String[] args)
	{
		System.out.println(power(4, 2));
	}
	
	static int power(int base, int a) {
	    if (a != 0)
	        return (base * power(base, a - 1));
	    else
	        return 1;
	}
}
