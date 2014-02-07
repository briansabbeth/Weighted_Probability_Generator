//main for testing out the 

import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args){
		//default consol output
		System.out.println("hello bitches");
		 ArrayList<Integer> probability_list = new ArrayList<Integer>();
	     ArrayList<Integer> probability_bucket = new ArrayList<Integer>();;
		
		for (int i = 0;i<10;++i)
		{
			probability_list.add(i,i);
			probability_bucket.add(i,i*2);		
		}
		
		Weighted_Probability wp = new Weighted_Probability(probability_list,probability_bucket);
		System.out.println("SIZE IS "+probability_bucket.size());
//	
//	  	for (int i = 0;i< probability_bucket.size(); ++i)
//		{
//		    System.out.println(probability_bucket.get(i));  
//		    System.out.println(probability_list.get(i));  
//		    System.out.println( );  
//	   	    
//		}
//		
		
		wp.double_probability(2);
		
		}
    
 
	
	
}
