package gss.algorithms.data_structures;

import java.util.*; 

public class Test
{
	public static void main (String args[]) throws Exception
	{
		List l = new ArrayList ();
		int a = (int)(3 * 2.5); 
		for (int i = 0; i < 10; i++)
			l.add (i); 
		String s = "Hello"; 
		l.add (a, s.getBytes ("UTF-8")[2]);
		System.out.println (l);
	}
}