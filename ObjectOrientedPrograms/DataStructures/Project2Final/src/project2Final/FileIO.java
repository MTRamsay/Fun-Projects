
package project2Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads external files of Presidents objects and manipulates them using stacks
 * 
 * @author Matthew Ramsay
 * @since 2016-09-24
 */
public class FileIO 
{
    private FileReader fr1;  
    private BufferedReader br1;
    private String inputString, name, party;
    private int number;
    private Stack presReadIn;
    
    
    /**
     * FileIO constructor
     * 
     * @param file : String 
     * @param size : integer 
     * @return "Return value or Returns nothing" 
     */
    public FileIO(String file, int size) throws IOException
    {
        fr1 = new FileReader(file);
        br1 = new BufferedReader (fr1);
        presReadIn = new Stack(size); // aggregation; has a stack in the constructor 
    } // end FileIO()
       
    
    /**
     * Reads file, creates Presidents objects, adds object to stack
     * 
     * @param none
     * @return Returns nothing
     */
    public void readPresidents() throws IOException
    {
        inputString = br1.readLine();
        
        Presidents temp;
        
        while (inputString != null)         
        {
            number = Integer.parseInt(inputString.substring(0,2).trim());
            name = inputString.substring(2, 25).trim();
            party = inputString.substring(29, 48).trim();       
            temp = new Presidents(number, name, party);            
                    
            presReadIn.push(temp);
            inputString = br1.readLine();
        }  //end while loop
    } // end readPresidents()
    
    
    /**
     * Checks if stack is full
     * 
     * @param none
     * @return Returns true if stack is full, otherwise false 
     */
    public boolean presRemaining()
    {
        if(!presReadIn.isEmpty())
            return true;
        else
            return false;
    } // end presRemaining()
    
    
    /**
     * Removes President from top of stack 
     * 
     * @param none
     * @return President at top of stack 
     */
    public Presidents getNextPresident()
    {
        return presReadIn.pop();
    } // end getNextPresident()
    
    
    /**
     * Displays the stack of Presidents used to update initial group
     * 
     * @param none
     * @return Returns nothing
     */
    public void showNewPres()
    {
        System.out.println("\n\n---------------------------------------------");
        System.out.println("\n\nInput Stack for Updating Priority Queues\n");
        presReadIn.displayStack();
    } // end showNewPres()
} // end FileIO
