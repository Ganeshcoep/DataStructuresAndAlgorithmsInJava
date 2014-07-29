package gss.algorithms.data_structures;

//things to observe Interface Vs Abstract Class

/*Reference:
	http://www.codewalk.com/code-review/
	
	Nice follow up - Should interface have constants?
	http://www.codewalk.com/object-design/
*/
/*Abstract Classes:

Cannot be instantiated.
Can have implementation for some or all the abstract methods. Of course, the child classes can override the behavior.
Can declare private, protected and public methods and members.
A class can inherit from only one abstract class.

Interfaces:

Cannot be instantiated
Cannot have implementation. Sometimes, constants are defined (with ‘final’ keyword)
Everything is public.
A class can implement any number of interface
*/


public interface MyInterface {
	public static int variable=10;
	public void myMethod();
	

}
