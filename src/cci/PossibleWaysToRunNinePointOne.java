package cci;

public class PossibleWaysToRunNinePointOne {

	public PossibleWaysToRunNinePointOne() {
	}

	public static void possibleWaysToRun(int numOfSteps, String str) {
		if( numOfSteps == 0){
			System.out.println(str);
		} else if( numOfSteps < 0){
			return;
		}
		for(int firstStep = 1 ; firstStep <= 3 ; ++firstStep) {
			String tempStr = str + firstStep;
			int tempNumOfSteps = numOfSteps - firstStep;
			possibleWaysToRun(tempNumOfSteps, tempStr);
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		possibleWaysToRun(1,"");
		possibleWaysToRun(0,"");
		possibleWaysToRun(-1,"");
		possibleWaysToRun(0,"");
		possibleWaysToRun(4,"");
		System.out.println();
	}

}
