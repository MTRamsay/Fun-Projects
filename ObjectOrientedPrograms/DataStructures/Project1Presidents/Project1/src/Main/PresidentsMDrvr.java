
package Main;
/**
 * Used to create an array of Presidents objects. 
 * Performs various functions with the array including sorting, 
 * searching, and inserting.
 * 
 * @author Matthew Ramsay
 * @since 2016-09-07
 */
public class PresidentsMDrvr 
{
    private Presidents[] myPresidents;
    
    private int nElems; 
    
    
    /**
     * Constructor for PresidentsMDrvr class. 
     * Creates an array of type Presidents.
     * 
     * 
     * @param max : integer
     * @return Returns nothing 
     */
    public PresidentsMDrvr(int max) // see updated slides 10-16 ch2
    {
        myPresidents = new Presidents[max];
        nElems = 0;
    }//end constructor 
    
    
    /**
     * Inserts a new Presidents object in myPresidents array.
     *
     * @param number : integer 
     * @param yearsInOffice : integer 
     * @param name : String 
     * @param party : String 
     * @param homeState : String 
     * @param code : String 
     * @return : Returns nothing
     */
    public void insert(int number, int yearsInOffice, String name,
            String party, String homeState, String code)
    {
        myPresidents[nElems] = new Presidents(number, yearsInOffice, name, 
                party, homeState, code);
        nElems++; 
    }//end insert method
    
    
    /**
     * Displays all objects in myPresidents array.
     * 
     * @param None
     * @return Returns nothing
     */
    public void displayPresidents()
    {
        System.out.printf("\n%-8s%-21s%s\n\n", "Number", "Name", "Party");
        for (int j = 0; j < nElems; j++)
            System.out.println(myPresidents[j]);
    }//end display method 
    
    /**
     * Performs a bubble sort on myPresidents array by number. 
     *
     * @param None
     * @return Returns nothing
     */
    public void bubbleSortNumber()
    {
        int numOut, numIn;
        
        for (numOut = nElems - 1; numOut > 1; numOut--)//outer loop backwards
            for (numIn = 0; numIn < numOut; numIn++)//inner loop forward
                if (myPresidents[numIn].getNumber() > 
                        myPresidents[numIn + 1].getNumber())//if out of order
                    swap(numIn, numIn + 1);
    }//end bubbleSortNumber method
    
    /**
     * Performs a bubble sort on myPresidents array by name.
     * 
     * @param None 
     * @return Returns nothing
     */
    public void bubbleSortName()
    {
        int nameOut, nameIn; 
        int compare;
        
        for (nameOut = nElems - 1; nameOut > 1; nameOut--)//outer loop backwards
        {
            for (nameIn = 0; nameIn < nameOut; nameIn++)//inner loop forward
            {
            compare = myPresidents[nameIn].getName().compareTo(myPresidents[nameIn + 1].getName());
                if (compare > 0)//if out of order
                {
                    swap(nameIn, nameIn + 1);
                }//end if 
            }//end for loop
        }//end for loop
    }//end bubbleSortName method
    
    /**
     * Swaps the positions of the 2 objects in myPresidents array. 
     * Helper method for the bubble sorts.
     *
     * @param one : integer
     * @param two : integer
     * @return returns nothing
     */
    private void swap(int one, int two)
    {
      Presidents temp = myPresidents[one];
      myPresidents[one] = myPresidents[two];
      myPresidents[two] = temp;
    }//end swap method

    /**
     * Searches each item in myPresidents array consecutively for search key,
     * counts number of hits, displays the search result. 
     * 
     * @param searchKeySeq : String 
     * @return returns nothing
     */
    public void sequentialSearch (String searchKeySeq)// find specified value   
    {         
        int compare, hits = 0;
        for (int j=0; j < nElems; j++)//for each element
        {
            compare = (myPresidents[j].getParty().compareTo(searchKeySeq));
            if (compare == 0)// found item?
            {
               hits++; 
            }   
        }//end for loop
        // diplays search result
        System.out.printf("%-17s%-11s%-12s\n",
                searchKeySeq,
                (hits > 0)? "Found":"Not Found",
                (hits == 0)? "": hits + " Occurrenes");
    }  // end find()
    
    /**
     * Performs a binary search of each item in myPresidents array for 
     * search key, counts number of probes, displays the search result.
     * 
     * @param searchKeyBin : String 
     * @return Returns nothing
     */
    public void binarySearch (String searchKeyBin)
    {
        String found; 
        int probeCount = 0,lowerBound = 0, upperBound = nElems-1, curIn;// ‘curIn’ = current index 

	while (true)
	{
            curIn = (lowerBound + upperBound) / 2;//set curIn to middle of range.
            if ((searchKeyBin.compareTo(myPresidents[curIn].getName())) == 0)
            {
                probeCount++;
                found = "Found";// found target
                break;
            }
            else
            {
                if (lowerBound > upperBound)
                {     
                    found = "Not Found";
                    break;// can’t find it.  End of routine.
                }//end if  
                else// adjust bounds of ‘array.’
                {
                    if(myPresidents[curIn].getName().compareTo(searchKeyBin) < 0)
                    {
                        probeCount++;
                        lowerBound = curIn+1;  // look in upper half
                    }//end if 
                    else{
                        probeCount++;
                        upperBound = curIn-1;// look in lower half
                    }//end else
                }// end else divide range
            }//end else
	} // end while
        System.out.printf("%-17s%-20s%d\n", searchKeyBin, found, probeCount);
    }//end binarySearch method
    
    }//end PresidentsMDrvr
    
    
