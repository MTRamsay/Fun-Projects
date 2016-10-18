
package project2Final;


/**
 * Creates and Defines Presidents objects including attributes and operations
 *
 * @author Matthew Ramsay
 * @since 2016-09-24
 */
public class Presidents 
{
    private int number;
    private String name, party;

    
    /**
     * Constructor for Presidents object
     * 
     * @param number : integer 
     * @param name : String 
     * @param party : String 
     * @return Returns nothing
     */
    public Presidents(int number, String name,
            String party)
    {
        this.number = number;
        this.name = name;
        this.party = party;
    }  // end Presidents() <constructor>
       
    
    /**
     * Gets the current number of Presidents object.
     * 
     * @param none
     * @return Number of Presidents object
     */
    public int getNumber()
    {
        return number;
    }// end getNumber()
    
    
    /**
     * Assigns parameter as number attribute of Presidents object.
     *
     * @param newNumber : integer
     * @return Returns nothing
     */
    public void setNumber(int newNumber)
    {
        number = newNumber;
    } // end setNumber()
    
    
    /**
     * Gets the current name of Presidents object.
     *
     * @param none 
     * @return Name of Presidents object
     */
    public String getName()
    {
        return name;
    } // end getName()
    
    
    /**
     * Assigns parameter as name attribute of Presidents object.
     * 
     * @param newName : String 
     * @return Returns nothing
     */
    public void setName(String newName)
    {
        name = newName; 
    } // end newName()
    
    
    /**
     * Gets the current party of Presidents object.
     * 
     * @param none
     * @return Party of Presidents object
     */
    public String getParty()
    {
        return party;
    } // end getParty()
    
    
    /**
     * Assigns parameter as party attribute of Presidents object.
     *
     * @param newParty : String 
     * @return Returns nothing
     */
    public void setParty(String newParty)
    {
        party = newParty;
    } // end setParty()
    
    
    /**
     * Prints a string representation of key attributes of Presidents objects.
     *
     * @param none
     * @return Returns nothing
     */    
    public String toString() 
    {
        return        
        (String.format("%6d  %-21s%s", number, name, party));
    } // end toString()
} // end Presidents

