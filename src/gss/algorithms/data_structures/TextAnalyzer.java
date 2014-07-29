package gss.algorithms.data_structures;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class TextAnalyzer{
	private static class StringNode implements Comparable<StringNode> {
		String string;						 // String value
		int length; 						 // length of string
		int count; 							 // no. of occurences of given string
		//BigInteger asciiValue; 				 // ascii value of given string
		public static Comparator<StringNode> FruitNameComparator= new Comparator<StringNode>() {
			public int compare(StringNode node1, StringNode node2) {
				return node1.compareTo(node2);
			}
    	};
		@Override
		public int compareTo(StringNode inputNode) {			 
			int compareQuantity = ((StringNode) inputNode).length;	 
			if(this.length==compareQuantity){
				//BigInteger asciiValue = ((StringNode) inputNode).asciiValue;
				byte[] node1ASCII=getASCIIValue(this.string);
				byte[] node2ASCII=getASCIIValue(inputNode.string);
				for(int i=0;i<node1ASCII.length;i++){
					if(node1ASCII[i]!=node2ASCII[i])
						return node1ASCII[i]-node2ASCII[i];//this.asciiValue-asciiValue;
				}
				return 0;				
			}
			else{			
				return this.length-inputNode.length;
			} 
	    }

		public byte[] getASCIIValue(String input) {
			/*StringBuilder sb = new StringBuilder();
			for (char c : input.toCharArray())
				sb.append((int) c);
			return new BigInteger(sb.toString());
			*/
			byte[] bytes=null;
			try {
				bytes = input.getBytes("US-ASCII");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bytes;

		}

	}
		

	public byte[] getASCIIValue(String input) {
		/*StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray())
			sb.append((int) c);
		return new BigInteger(sb.toString());
		*/
		byte[] bytes=null;
		try {
			bytes = input.getBytes("US-ASCII");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;

	}

	public void sortStrings(String[] input) {

	}

	public static void sortStringBubble(String x[]) {
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
	 	StringTokenizer t = new StringTokenizer(input," ");
		String tokens[]=new String[t.countTokens()];
		int i=0;
		while (t.hasMoreElements()) {
			tokens[i]=(String)t.nextElement();//System.out.println(t.nextElement());
			i++;
		}
		
		sortStringBubble(tokens);
		for (int k = 0; k < tokens.length; k++)
			System.out.println(tokens[k]);
		
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
		printReport(nodes,i);	
		Arrays.sort(nodes,StringNode.FruitNameComparator);
		printReport(nodes,i);
	}
	
	public void printReport(StringNode[] nodes,int count){		
		for(int i=0;i<=count;i++){
				System.out.println(nodes[i].count+"\t"+nodes[i].string);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextAnalyzer t = new TextAnalyzer();
		String s = "abc";
		//System.out.println(t.getASCIIValue(s));
		t.analyze("The quick brown fox jumped over the lazy brown dog's back");
		
		/*String[] names = { "joe", "slim", "ed", "george" };
		sortStringBubble(names);
		for (int k = 0; k < 4; k++)
			System.out.println(names[k]);
			*/

	}

}
