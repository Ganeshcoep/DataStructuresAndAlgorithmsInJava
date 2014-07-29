
/* Problem statement : 
 * Given an integer number and digit(from 1 to 9) and find how many numbers from 0 to given Number
 * have given digit for at least once  
 */

/* Approach:
 For a given number
* Count how many times it appears in the unit place.
This we can get by Ceiling(inputNumber/10)*power(9 *0)
E.g. for 100 , 5 comes in unit place for 10 times (5, 15, 25, 25, 45, 55..95)
*  Count how many times it appears in the 10th place.
This we can get by Ceiling(inputNumber/100)**power(9 *1)
E.g. for 100 , 5 comes in 10th place 10 times but since we are not going to count for 55 again its 9 times only
* We proceed until we reach last digit e.g. for 564 , last digit is 5.
Now here is one interesting case to handle.
  if the last digit is greater than given digit  we can simply add power(9 *(total number of digits in guiven number)-1)
	  e,g, for 655,5 , we will need to add power(9,2)
   
  if the last digit is equal to the given digit we do as follows.
   	   e,g, for 555,5 , we will need to add numbers from 500..555( total 56 numbers) minus the duplicates. 
*/

package gss.coding.problems;

/**
 * @author gsalvi
 *
 */
public class DigitCountCalculator {

	public DigitCountCalculator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param inputNum
	 * @param num
	 * @return number of times atleast one num occurs in numbers from 1 to inputNum
	 */
	public int countOccurence(int inputNum,int num){
		if(inputNum<0) // if number is -ve make it positive and process
			inputNum*=-1;
		
		int divider=10;
		int temp=inputNum;
		int count=0;
		int power=0;
		int dividerCount=1;
		while(temp>9){
			temp=myCeiling(divider, temp,num);
			count+=temp*Math.pow(9,power);
			power++;
			dividerCount++;			
		}
		if(inputNum%divider>=num)//power==1) // needed for 2 digit number like 55
			temp--;
		//System.out.println(count);
		if(temp>num){
			count+=Math.pow(9,power);
		}	
		if(temp==num){
			int value=(int)(inputNum-temp*(Math.pow(10,--dividerCount))+1);
			if(inputNum%10==num)
				value--;//=value-myCeiling(10, value,num);
				
			/*System.out.println("value is :"+ value);
			int finalValue=value-myCeiling(10, value,num);
			System.out.println("Final value is :"+ finalValue);
			count+=finalValue;//inputNum-temp*(Math.pow(10,--dividerCount))+1;
			*/count+=value;
			//count+=(int)(inputNum-temp*(Math.pow(10,--dividerCount))+1);
		}	
		return count;
	}

	public int myCeiling(int divider,int dividee,int num){
		if (divider==0)
			return 0;
		if(dividee%divider>=num)//(divider/2))
			return (dividee/divider)+1;
		else
			return (dividee/divider);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitCountCalculator C= new DigitCountCalculator();
		System.out.println(C.countOccurence(1000,5));
		System.out.println(C.countOccurence(66,6));//75,6));
		System.out.println(C.countOccurence(525,5));
		System.out.println(C.countOccurence(5,5));
		System.out.println(C.countOccurence(55,5));
		System.out.println(C.countOccurence(1,5));
		System.out.println(C.countOccurence(0,5)); // returns 0
		System.out.println(C.countOccurence(-55,5)); // returns 0
		//System.out.println(C.myCeiling(5,5));
		//System.out.println(C.myCeiling(5,0));
		
	}

}
