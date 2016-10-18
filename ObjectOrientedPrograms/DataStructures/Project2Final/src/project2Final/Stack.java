
package project2Final;

/**
 * Performs stack functions on an array of Presidents objects
 * 
 * @author Matthew Ramsay
 * @since 2016-09-24
 */
public class Stack 
{
    private int maxSize; // size of stack array 
    private Presidents[] stackArray;
    private int top; 
    
    
    /**
     * Stack constructor
     * 
     * @param size : integer
     * @return Returns nothing
     */
    public Stack(int size)
    {
        maxSize = size; // set array size 
        stackArray = new Presidents[maxSize];
        top = -1;
    }
    
    
    /** 
     * Pushes Presidents object on top of stack
     * 
     * @param tempPres : Presidents
     * @return Returns nothing
     */
    public void push(Presidents tempPres)
    {
        stackArray[++top] = tempPres; // increment top, insert item 
    } // end push()
     
    
    /**
     * Removes Presidents object from top of stack
     * 
     * @param none
     * @return Returns Presidents element removed from stack
     */
    public Presidents pop() 
    {
        return stackArray[top--]; // access item, decrement top 
    } // end pop()
     
    
    /**
     * Checks if stack is empty
     * 
     * @param none
     * @return Returns true if stack is empty, otherwise false 
     */
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1); 
    } // end isEmpty()
    
    
    /**
     * Checks if stack is full
     * 
     * @param none
     * @return Returns true if stack is full, otherwise false 
     */
    public boolean isFull() 
    {
        return (top == maxSize-1); 
    } // end isFull()
    
    
    /**
     * Displays all stack elements 
     * 
     * @param none
     * @return Returns nothing
     */
    public void displayStack()
    {
        System.out.printf("%-14s%-16s%s\n\n","Number", "Name", "Party");
        System.out.println("Top of stack:");
        for (int i = 0; i < maxSize; i++) 
            System.out.println(stackArray[i]);
        
        System.out.println("Bottom of stack");
    }
} // end class Stack