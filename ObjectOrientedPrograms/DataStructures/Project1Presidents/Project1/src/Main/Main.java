
package Main;

import java.io.*;
/**
 * Creates an object of type PresidentsMDrvr and adds 44 new Presidents
 * elements using data read from an external file. The object is then 
 * searched, sorted, and displayed. 
 * 
 * @author Matthew Ramsay
 * @since 2016-09-07
 */
public class Main 
{   
     /**
     * Creates and performs numerous operation on an object of type PresidentsMDrvr
     * 
     * @param None
     * @return Returns nothing
     */
    public static void main(String[]args) throws IOException
    {
        PresidentsMDrvr presidentsDrvr = new PresidentsMDrvr(44); 
        
        //Creates 2 new file readers to read external documents
        FileReader fr1 = new FileReader("Presidents.txt"); 
        FileReader fr2 = new FileReader("PresidentsParty.txt");
        BufferedReader br1 = new BufferedReader (fr1);
        BufferedReader br2 = new BufferedReader (fr2);
        String inputString;//This will hold the current line being read
        
        // attributes for objects in presidentsDrvr 
        int number, yearsInOffice;
        String name, party, homeState, code;

        inputString = br1.readLine();
        
        /**
        * Loop reads first line in the referenced file.
        * Then assigns a value to each attribute, parsing when needed.
        * Inserts new object in presidentsDrvr.
        * Repeats for each subsequent line containing text.
        */
        while (inputString != null)         
        {
            number = Integer.parseInt(inputString.substring(0,2).trim());
	    //System.out.printf ("Number read in was: %d\n"
                    //,number);
            
            name = inputString.substring(2, 25).trim();
	    //System.out.printf ("Name read in was: %s\n",
                    //name);
            
            code = inputString.substring(25,27);
            //System.out.printf ("Code read in was: %s\n",
                    //code);
            
            yearsInOffice = Integer.parseInt(inputString.substring(27,29).trim());
            //System.out.printf ("Years in office read in was: %d\n",
                    //yearsInOffice);
            
            party = inputString.substring(29, 48).trim();
	    //System.out.printf ("Party read in was: %s\n",
                    //party);
            
            homeState = inputString.substring(49, inputString.length()).trim();
	    //System.out.printf ("Home State read in was: %s\n\n",
                    //homeState);
            
            presidentsDrvr.insert(number, yearsInOffice, name,
                    party, homeState, code);
            
            inputString=br1.readLine();
        }  //end while loop
        
        // displays key attributes for objects in presidentsDrvr 
        presidentsDrvr.displayPresidents();
        presidentsDrvr.bubbleSortNumber();// objects bubble sorted by number
        
        // custom header for to display sorted objects in presidentsDrvr
        System.out.printf("\n\n%30s", 
                "Sorted Presidents Array\n");
        
        presidentsDrvr.displayPresidents();// displays objects in presidentsDrvr

        inputString = br2.readLine();
        String output;
        
        // displays custom header for sequential search results
        System.out.printf("\n\n%34s", "Sequential Search Results");
        System.out.printf("\n\n%-17s%-11s%-12s\n\n",
                "Search Argument",
                "Result", 
                "Number of Hits");
        
        // read party names from external document and searches the array for each
        while (inputString != null)
        {
            output = inputString.substring(0, inputString.length()).trim();
            presidentsDrvr.sequentialSearch(output);
            inputString=br2.readLine();
        }// end while loop
        
        // sort by name in preparation for binary search
        presidentsDrvr.bubbleSortName();    
        
         // array will be used to used when doing the binary search
        String[] namesToSearch = {"Andrew Jackson","Abraham Lincoln", 
            "Billy Bob", "George Patton","Harry Truman", "XXX"};
        
        // displays custom header for binary search results below
        System.out.printf("\n\n%37s", "Binary Search Results"); 
        System.out.printf("\n\n%-17s%-20s%s\n\n",
                "Search Argument",
                "Found or Not Found", 
                "Number of probes");
        
        // performs a binary search for each object in namesToSearch array
        for (String namesToSearch1 : namesToSearch) {
            presidentsDrvr.binarySearch(namesToSearch1);
        }
    } // end main method

} // end Main class





package Main;

/**
 * Defines Presidents objects including attributes and operations.
 * 
 * @author Matthew Ramsay
 * @since 2016-09-07
 */
public class Presidents 
{
    private int number, yearsInOffice;
    private String name, party, homeState, code;

    /**
     * Constructor for Presidents object.
     * 
     * @param number : integer 
     * @param yearsInOffice : integer 
     * @param name : String 
     * @param party : String 
     * @param homeState : String 
     * @param code : String 
     * @return Returns nothing
     */
    public Presidents(int number, int yearsInOffice, String name,
            String party, String homeState, String code)
    {
        this.number = number;
        this.yearsInOffice = yearsInOffice;
        this.name = name;
        this.party = party;
        this.homeState = homeState;
        this.code = code;
    }  
       
    /**
     * Gets the current number of Presidents object.
     * 
     * @param None
     * @return Number of Presidents object
     */
    public int getNumber()
    {
        return number;
    }// End getNumber
    
    /**
     * Assigns parameter as number attribute of Presidents object.
     *
     * @param newNumber : integer
     * @return Returns nothing
     */
    public void setNumber(int newNumber)
    {
        number = newNumber;
    }
    
    /**
     * Gets the current year in office value of Presidents object.
     *
     * @param None
     * @return Years in office of Presidents object
     */
    public int getYearsInOffice()
    {
        return yearsInOffice;
    }
    
    /**
     * Assigns parameter as years in office attribute of Presidents object.
     *
     * @param newYears : integer
     * @return Returns nothing
     */
    public void setYearsInOffice(int newYears)
    {
        yearsInOffice = newYears;
    }
    
    /**
     * Gets the current name of Presidents object.
     *
     * @param None 
     * @return Name of Presidents object
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Assigns parameter as name attribute of Presidents object.
     * 
     * @param newName : String 
     * @return Returns nothing
     */
    public void setName(String newName)
    {
        name = newName; 
    }
    
    /**
     * Gets the current party of Presidents object.
     * 
     * @param None
     * @return Party of Presidents object
     */
    public String getParty()
    {
        return party;
    }
    
    /**
     * Assigns parameter as party attribute of Presidents object.
     *
     * @param newParty : String 
     * @return Returns nothing
     */
    public void setParty(String newParty)
    {
        party = newParty;
    }
    
    /**
     * Gets the current home state of Presidents object.
     *
     * @param None
     * @return Home state of Presidents object
     */
    public String getHomeState()
    {
        return homeState;
    }
    
    /**
     * Assigns parameter as home state attribute of Presidents object.
     * 
     * @param newHomeState : String 
     * @return Returns nothing
     */
    public void setHomeState(String newHomeState)
    {
        homeState = newHomeState;
    }
    
    /**
     * Gets the current code of Presidents object.
     *
     * @param None
     * @return Code of Presidents object
     */
    public String getCode()
    {
        return code;
    }
    
    /**
     * Assigns parameter as code attribute of Presidents object.
     *
     * @param newCode : String 
     * @return returns nothing
     */
    public void setCode(String newCode)
    {
        code = newCode;
    }
    
    /**
     * Prints a string representation of key attributes of Presidents objects.
     *
     * @param None
     * @return Returns nothing
     */    
    public String toString() 
    {
        return        
        (String.format("%6d  %-21s%s", number, name, party));
        
    }
    
}





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
    
    
