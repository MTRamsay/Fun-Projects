
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
