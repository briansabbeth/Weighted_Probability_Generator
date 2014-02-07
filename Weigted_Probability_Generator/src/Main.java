//main for testing out the 
//
//
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args){
		//default consol output
		 ArrayList<Integer> probability_list = new ArrayList<Integer>();
	     ArrayList<Integer> probability_bucket = new ArrayList<Integer>();;
		
		for (int i = 0;i<10;++i)
		{
			probability_list.add(i,1);//initially start off with all probabilities at 1
			probability_bucket.add(i,i);//since all probabilities are 1, only one of each bucket
		}
		for (int i = 0;i<10; ++i)
		{
			System.out.println( i + " " + probability_list.get(i));
		} 
		
		
		Weighted_Probability wp = new Weighted_Probability(probability_bucket,probability_list);
		System.out.println("SIZE IS "+ probability_bucket.size());

		
	   
		System.out.println("Probability of clip 2 is  "+ wp.get_probability(2));
		System.out.println("Probability of clip 4 is  "+ wp.get_probability(4));

		wp.double_probability(4);
		
		System.out.println("Probability of clip 4 after doubling the probability is  "+ wp.get_probability(4));

		wp.output_bucket();
		System.out.println("Probability of clip 4 after doubling the probability is  "+ wp.get_probability(4));

		wp.output_bucket();

		}
    
 
	
	
}
