/**
 * 
 */

/**
 * @author bjsabbeth
 * Weighted Probability Class
 * Feb 6th 2014
 * 
 * Purpose: Generate a weighted probability for an array of integers which 
 * 			represent indexes of an array of clips. 
 *          The weighted probability for clip will change depending on a request from outside of the class
 *          The class will also return the probability of the current clip, as well as
 *          whether or not the clip has been repeated 4 times out of the last 4 times it has been 
 *          played on the device.  
 */
//
//
//
//
//

import java.util.ArrayList;
public class Weighted_Probability {
	
	/**************************************************************************
	 * PRIVATE VARIABLES
	 **************************************************************************
	 */
	//A list the that is the size of the number of clips
	//The index of the list equals the clip number
	//The value associated with the index is the value of the probabability
	private ArrayList<Integer> probability_list;
	
	//A weighted probability array
	//Every index into the array gets a clip_number
	//The total number of clip_numbers in the array represent the weighted probability
	//of that clip being chosen.  
	private ArrayList<Integer> probability_buckets;
	
	
	/**************************************************************************
	 * PUBLIC FUNCTIONS
	 **************************************************************************
	 */
	
	/**
	 ** Constructor takes 2 arrays retrieved from the shared preferences in the phone.  
	 * @param probability_buckets
	 * @param probability_list
	 */
    Weighted_Probability(ArrayList<Integer> prob_bucket, ArrayList<Integer> prob_list)
	{
    	//////////BELOW MAY NOT BE TRUE; DEPENDING ON WHAT YOU READ///
    	/////?????WHEN I TESTED THIS IT DID NOT CHANGE THE MEMORY FROM MAIN//////
    	//this will not copy; instead it will change the data from the location in 
    	//memory  the list and the bucket are being stored
    	probability_list = new ArrayList<Integer>(prob_list);
    	probability_buckets = new ArrayList<Integer>(prob_bucket);
    	//just for testing
    	System.out.println(probability_buckets.size());
	    System.out.println( );  

    	
    	//just for testing
    	for (int i = 0;i< probability_buckets.size(); ++i)
    	{
    	    System.out.println(probability_buckets.get(i));  
    	    System.out.println(probability_list.get(i));  
    	    System.out.println( );  
       	    
    	}
	    System.out.println("END CONSTRUCTOR");  


	}
	
    
    /**
     * void double_probability
     * @param clip_number is the number of the clip that was selected
     * Takes the clip number
     * Takes that clip number gets the current probability
     * Temporarily stores the probability in temp
     * Doubles the probability and sets the probability_list to the new probability
     * Adds the clip# to the probabilty buckets (temp times) 
     * 
     */
    public void double_probability(int clip_number)
    {
    	int temp = probability_list.get(clip_number);
	    System.out.println("DOUBLE PROBABILITY The probability for " + clip_number + " = " + temp);  

    	for(int i = 0; i<temp; ++i)
    	{    		
    		probability_buckets.add(clip_number);
    	}
    	probability_list.set(clip_number, temp*2);
    	System.out.println("DOUBLE VALUE FOR " + clip_number + "IS  " + probability_list.get(clip_number));
    }

    /**
     * Will be finally implemented as private
     * Returns the probability based on the clip number.  
     * @param clip_number
     * @return
     */
	public int  get_probability(int clip_number)
	{

		return probability_list.get(clip_number);		
	}
	
    /**
     * 
     * @returns the probability list which will be saved in shared preferences from 
     * main activity
     */
	
	public ArrayList<Integer> get_probability_list()
	{
		return probability_list;
	}
	
	
	
	
	public ArrayList<Integer> get_probability_buckets()
	{
		return probability_buckets;
	}
	
	
	
	public void output_bucket()
	{
    	System.out.println(" " + probability_buckets.size());

		for(int i = 0; i<probability_buckets.size(); ++i)
		{
    	    System.out.println(probability_buckets.get(i));  
		}
	}
	
}
