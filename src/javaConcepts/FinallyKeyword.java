package javaConcepts;

//When will not be executed- JVM exited from try block
//what does this mean?
//If you call System.exit(0); then finally blocks are not called as the thread is shutdown immediately. In all other cases finally is called when the block exits (assuming it does)

public class FinallyKeyword {

	public FinallyKeyword() {
	}

	public static String foo(){
		int x = 0;
		int y = 5;
		try{
			int ans = y/x;
			//System.exit(0);
			return "returned from try"+ans;			
		}catch(Exception ex){
			System.out.println("Executed catch");
			return "returned from catch";			
		}finally{
			System.out.println("Executed finally");
			//return "returned from finally"; //un-comment to see the result		
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(foo());
	}

}
