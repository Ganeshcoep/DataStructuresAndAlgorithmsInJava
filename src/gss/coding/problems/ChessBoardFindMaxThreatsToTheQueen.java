package gss.coding.problems;

/* PROBLEM DESCRIPTION ********************************************************************/ 
 /* Consider N X N chessboard.
 * You have N queens.
 * Queen p is considered as threat to queen q if p can be killed by q.
 * Input: Array A of N elements giving the positions of all the N queens. 
 *        A[i] is column index and i is row index
 * Output: Return the max no. of threats to any queen
 * 
 * Note: dont count the jumps while calculating tehe threats.
 * i.e. For below example 
 * 
 * 			* * * *
 *          * r * *
 *          * * q *
 *          * * * p
 *          
 * if p, q and r are in same line. threat to p is q and is sounted then dont count r as threat to p
 *      as r can't jump to kill q
 *      
 */ 
/* ***************************************************************************************/

/* SOLUTION: 
 * For each queen , we need to check all the 8 directions/places where queen can be present.
 * So move to the left right, bottom, top , diagonally left top, diagonally right top,
 * diagonally left bottom, diagonally right bottom.
 * 
 * We stop when we get the queen in the same direction. Since the jumps are not allowed.
 *           
 * We repeat this for all the given N queens and return the max no. threats among them.
 * 
 */

public class ChessBoardFindMaxThreatsToTheQueen {

	public ChessBoardFindMaxThreatsToTheQueen() {
	}

	//Since for the input given the row number started from 0 and col 
	//number form 1 to N, so little bit change in this function is done.
	//compared to the previous one.
	static int maxThreats_final(int[] input){		
		if(input == null)
			return 0;		
		if(input.length == 0)
			return 0;		
		int N = input.length;   // chess board size				
		int maxThreat = 0;
		for (int cnt = 0; cnt < N; cnt++){
			int threat = 0;				
			int row  = cnt;
			int col  = input[cnt];			
			/*		System.out.println("cnt is : "+cnt);
			System.out.println("row is : "+cnt);
			System.out.println("col is : "+cnt);
			 */	
			//check top			
			int iterator = row+1;
			while(iterator <= N-1){				
				if(input[iterator] == col){
					threat++;
					break; // as we don't count jumps
				}
				iterator++; //move 				
			}

			// check bottom			
			iterator =row -1;
			while(iterator >= 0){			
				//System.out.println(iterator +" : " +col);
				if(input[iterator] == col){
					threat++;
					break; // as we dont count jumps
				}
				iterator--;				
			}			

			// diagonal right top			
			int itr_row = row +1;
			int itr_col = col+1;			
			while(itr_row <= N-1 && itr_col <= N){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row++;
				itr_col++;				
			}

			// diagonal left bottom
			itr_row = row -1;
			itr_col = col-1;
			while(itr_row >= 0 && itr_col >= 1){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row--;
				itr_col--;				
			}

			//------------------------------
			// diagonal left top
			itr_row = row +1;
			itr_col = col-1;
			while(itr_row <= N-1 && itr_col >= 1){
				//	System.out.println(itr_row +" : " + itr_col);	
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row++;
				itr_col--;				
			}

			//diagonal right bottom
			itr_row = row -1;
			itr_col = col+1;
			while(itr_row >= 0 && itr_col <= N){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row--;
				itr_col++;				
			}

			if(threat > maxThreat)
				maxThreat = threat;
		}		
		return maxThreat;
	}

	static int maxThreats(int[] input){
		if(input == null)
			return 0;		
		if(input.length == 0)
			return 0;		
		int N = input.length;   // chess board size

		//reduce input array by 1 as col no. starts from 1 to N not from 0 to N-1
		for (int i=0;i<N;i++)
			input[i]=input[i]-1;

		int maxThreat = 0;
		for (int cnt = 0; cnt < N; cnt++){
			int threat = 0;				
			int row  = cnt;
			int col  = input[cnt];

			/*		System.out.println("cnt is : "+cnt);
			System.out.println("row is : "+cnt);
			System.out.println("col is : "+cnt);
			 */	
			//check top			
			int iterator = row+1;
			while(iterator <= N-1){				
				if(input[iterator] == col){
					threat++;
					break; // as we don't count jumps
				}
				iterator++; //move 				
			}

			// check bottom			
			iterator =row -1;
			while(iterator >= 0){			
				//System.out.println(iterator +" : " +col);
				if(input[iterator] == col){
					threat++;
					break; // as we dont count jumps
				}
				iterator--;				
			}

			// diagonal right top
			int itr_row = row +1;
			int itr_col = col+1;
			while(itr_row <= N-1 && itr_col <= N-1){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row++;
				itr_col++;				
			}

			// diagonal left bottom
			itr_row = row -1;
			itr_col = col-1;
			while(itr_row >= 0 && itr_col >= 0){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row--;
				itr_col--;				
			}

			//------------------------------
			// diagonal left top
			itr_row = row +1;
			itr_col = col-1;
			while(itr_row <= N-1 && itr_col >= 0){
				//	System.out.println(itr_row +" : " + itr_col);	
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row++;
				itr_col--;				
			}

			//diagonal right bottom
			itr_row = row -1;
			itr_col = col+1;
			while(itr_row >= 0 && itr_col <= N-1){
				if(input[itr_row] == itr_col){
					threat++;
					break; // as we dont count jumps
				}
				itr_row--;
				itr_col++;				
			}

			if(threat > maxThreat)
				maxThreat = threat;
		}
		return maxThreat;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={0,1,2,3};
		//int[] input={3,1,4,2};//Note the col number from 1 to N and row number from 0 to N-1
		//int[] input={2,3,1};
		//int[] input={};
		System.out.println(maxThreats_final(input));

	}

}
