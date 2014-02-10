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
 *          
 *          
 *          Updates: Feb 9th
 *          	1)  Added a pop_and_push array list(so this is compatable with #6)
 *          	2)  Add a reset to reset the array list after update(in order to be compatable with #2) 
 *            
 *            
 */
//
//
//
//
//

import java.util.ArrayList;
import java.lang.Math;
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
	
	
	//A 2d array of repeated attempts
	//    Contains the last three times a clip was played.,  
	//    If in the last three times the clip was repeated four times
	//    The probability for that specific clip will double.  
	private int[][] repeat_table;
	
	
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
    	//0 row three column list which will be added to 
    	ArrayList<Integer>[][] repeat_table = new ArrayList[prob_list.size()][3];
    
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
    public void double_probability(int clip_index)
    {
    	int temp = probability_list.get(clip_index);
	    System.out.println("DOUBLE PROBABILITY The probability for " + clip_index + " = " + temp);  

    	for(int i = 0; i<temp; ++i)
    	{    		
    		probability_buckets.add(clip_index);
    	}
    	probability_list.set(clip_index, temp*2);
    	System.out.println("DOUBLE VALUE FOR " + clip_index+ "IS  " + probability_list.get(clip_index));
    }

   
    
    
    
//	/**
//	 * Function for the the case of 50 clips of which 10 are getting popped and 10 are getting pushed
//	 * 1)Reset 10 clips - pop 10 from the front and push 10 on the back//calling private reset_10()
//	 * 2) From ProbailityList.Size()-10 to ProbabilityList.size() set to value of 
//    *          //this is done by adding 1's to the end of the bucket.  
//	 * 3)Iterate through the probability_list. If an index value is >1 then double the probability  
//	 *   of that clip by that value:  If it the value is 3 than the probabiliy increases (((1)2)2)2) = 8 or 2^3.
//	 *    What should happen in the probability list is (if size is 20 and shift is 5)
//	 *    	[1][2][1][2][4][1][1][3][1][1][2][5][4][1][3][4][2][1][1][2]->
//	 *       0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 
//	 *    	->             [1][1][3][1][1][2][5][4][1][3][4][2][1][1][2][1][1][1][1][1]
//	 *    					0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 
//	 *    
//	 *    What should happen in the probability buckets is for the same thing is:
//	 *    [0][1][2][3][4][5][6][7][8][9][10][[11][12][13][14][15][16][17][18][19][0][1][1][1][2][3][3][3][4][4][4][4][4][4][4][4]...
//	 *    -> [0][1][2][3][4][5][6][7][8][9][10][[11][12][13][14][15][16][17][18][19]
//	 *      -->[0][1][2][3][4][5][6][7][8][9][10][[11][12][13][14][15][16][17][18][19][2][2][2][2][2][2][5][6][6][6][6][6][6][6][6]......
//	 *      
//	 *      
//	 *    */
    public void swap_ten(ArrayList<Integer>probability_list,ArrayList<Integer>probability_buckets )
  	{
    	reset_ten();
  		for(int i = 0;i<probability_list.size(); ++i)
  		{  			
  			if (probability_list.get(i) >= 2)
  			{  				
  				int temp_prob =  probability_list.get(i);
  				int temp_counter = 1;
  				
  				for(int j = 0; j< temp_prob; j++)
  				{
  					temp_counter = temp_counter * 2;
  				}  				
  				for(int j = 0;j<(temp_counter-1); ++j)
  				{
  					probability_buckets.add(i);
  				} 				
  			}
  		}
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
     * @returns the probability list which will be saved in shared preferences from 
     * main activity
     */
	public ArrayList<Integer> get_probability_list()
	{
		return probability_list;
	}
	
	
	
	 /**
     * @returns the probability buckets which will be saved in shared preferences from 
     * main activity
     */
	public ArrayList<Integer> get_probability_buckets()
	{
		return probability_buckets;
	}

	public void reset_on_update(int new_cliplist_size)
	{
		probability_list.clear();
		probability_buckets.clear();
		
		for(int i = 0; i < new_cliplist_size; ++i)
		{
		    probability_list.add(i, 1);
		    probability_buckets.add(i,i);
		    
		}
	}
	
	

	
	
	/*
	 * Just for outputting the bucket.  not for the App
	 */
	public void output_bucket()
	{
    	System.out.println(" " + probability_buckets.size());

		for(int i = 0; i<probability_buckets.size(); ++i)
		{
    	    System.out.println(probability_buckets.get(i));  
		}
	}
	
	/*
	 * @cliplist_index is the index of the cliplist from onCreate();
	 * @same_turn indicates whether or not the function is being repeated in the same clip
	 * When repeat is called: 
	 * 	1)All indices in the inner arrayList will get pushed down.
	 * 	   If this repeat is the fourth in three times: double probability
	 *     Achieved by adding up the indices of the array.
	 * 
	 *  2)Push back the new repeat in the the array at the cliplist_index.
	 *  3)
	 *  
	 */
	public void on_repeat(int clip_index, boolean same_turn)
	{
		int sum = 0;
		for(int i = 0;i<3;i++)
		{	
            sum = repeat_table[clip_index][i] + sum;       
		}
		if( sum > 3 )
        {
        	double_probability(clip_index);
        }
        
	   	if(same_turn == false)
	   	{
	   		 for(int i = 0;i<2;++i)
	   		 {
	   			 repeat_table[clip_index][i] =  repeat_table[clip_index][i+1];
	   		 }
	   		repeat_table[clip_index][2] = 1;
	   	 }
	  	
	   	
	   	if(same_turn == true)
	  	{
	   		repeat_table[clip_index][2]++;
	  	}
	}
	

	/**************************************************************************
	 * PRIVATE FUNCTIONS
	 **************************************************************************
	*/
    private void reset_ten()
    {
    	for(int i = 0; i<10; ++i)
		{
			probability_list.remove(0);
			probability_list.add(1);		
		}
	}
    
    
    private void initialize_repeat_table()
    {
     for(int i = 0; i< repeat_table.length; ++i)
     {
    	 for(int j = 0; j<3; ++j)
    	 {
    		 repeat_table[i][j] = 0;
   	 
    	 }
     }
    	
    }
 }
    
	    
	
	
	
	
	
	

