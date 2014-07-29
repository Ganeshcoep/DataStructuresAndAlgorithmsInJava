/*  * Text analyzer program
 * Approach :
 * Get the tokens form the input string - O(N)
 * Sort the tokens- Here bubble sort is used to -O(N2)
 * Get the counts of each token O(N)
 * Put the tokens into the StringNode's array- O(N)
 * Sort the tokens using the comparator O(NlogN)
 * Total complexity =O(N2)- can be improved by usng mergeSot instread of bubble sort *  
 * */



import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class TextAnalyzer{
	private static class StringNode implements Comparable<StringNode> {
		String string;						 // String value
		int length; 						 // length of string
		int count; 							 // no. of occurences of given string
		public static Comparator<StringNode> StringNodeComparator= new Comparator<StringNode>() {
			public int compare(StringNode node1, StringNode node2) {
				return node1.compareTo(node2);
			}
    	};
		
    	@Override
		public int compareTo(StringNode inputNode) {
    		if(inputNode==null)
    			return 1;    		
			int compareQuantity = ((StringNode) inputNode).length;	 
			if(this.length==compareQuantity){
				byte[] node1ASCII=getASCIIValue(this.string);
				byte[] node2ASCII=getASCIIValue(inputNode.string);		
				if(node1ASCII!=null){
					for(int i=0;i<node1ASCII.length;i++){
						if(node1ASCII[i]!=node2ASCII[i])
							return node1ASCII[i]-node2ASCII[i];
						System.out.println("Checking..");
					}
				}
				return 0;				
			}
			else{			
				return this.length-inputNode.length;
			} 
	    }

		private byte[] getASCIIValue(String input) {
			if(input==null)
				return null;
			
			byte[] bytes=null;
			try {
				bytes = input.getBytes("US-ASCII");
			} catch (UnsupportedEncodingException e) {
				System.out.println("error here");
				e.printStackTrace();
			
			}
			return bytes;
		}
	}
		
	private static void sortStringBubble(String x[]) {
		int j;
		boolean flag = true; // will determine when the sort is finished
		String temp;

		while (flag) {
			flag = false;
			for (j = 0; j < x.length - 1; j++) {
				if (x[j].compareTo(x[j + 1]) > 0) { // ascending sort
					temp = x[j];
					x[j] = x[j + 1]; // swapping
					x[j + 1] = temp;
					flag = true;
				}
			}
		}
	}

	public void analyze(String input) {
		if(input==null||input.length()==0)
			return;
	 	StringTokenizer t = new StringTokenizer(input," ");
		String tokens[]=new String[t.countTokens()];
		int i=0;
		while (t.hasMoreElements()) {
			tokens[i]=(String)t.nextElement();
			i++;
		}		
		sortStringBubble(tokens);
		StringNode nodes[]=new StringNode[tokens.length];
		
		for(int j=0;j<tokens.length;j++){
			nodes[j]=new StringNode();
		}
		
		i=0;		
		nodes[i].string=tokens[0];
		nodes[i].count=1;
		nodes[i].length=tokens[0].length();		
		
		for (int k = 1; k < tokens.length; k++){
			if(nodes[i].string.compareTo(tokens[k])==0){
				nodes[i].count++;
			}
			else{
				i++;
				nodes[i].string=tokens[k];
				nodes[i].count=1;
				nodes[i].length=tokens[k].length();
			}
		}
		//printReport(nodes);	
		Arrays.sort(nodes,StringNode.StringNodeComparator);
		printReport(nodes);
	}
	
	private void printReport(StringNode[] nodes){
		if(nodes==null)
			return;
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].string!=null)
				System.out.println(nodes[i].count+"\t"+nodes[i].string);
		}
		
	}

	public static void main(String[] args) {
		TextAnalyzer t = new TextAnalyzer();
		t.analyze("The the the the quick brown fox jumped over the lazy brown dog's back the quick quick");		
		t.analyze("");
		t.analyze(null);		
	}

}
