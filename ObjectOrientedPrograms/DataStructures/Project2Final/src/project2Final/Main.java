
package project2Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Creates and updates multiple queues from list of Presidents 
 * 
 * @author Matthew Ramsay
 * @since 2016-09-24
 */
public class Main 
{
    /**
     * Creates and updates multiple queues from list of Presidents
     * 
     * 
     * @param args the command line arguments
     * @return Returns nothing 
     */
    public static void main(String[] args) throws IOException
    {
        Queue presidentsQueue = new Queue();  
        
        // creates 2 file IO objects to read in text from document
        FileIO presReader = new FileIO("Presidents.txt", 44);
        FileIO presUpdateReader = new FileIO("PresidentUpdate.txt", 8);
        
        // reads all lines from text file and stores in presReader object
        presReader.readPresidents();
        
        // removes each president from presReader object and inserts into queue
        while (presReader.presRemaining())
            presidentsQueue.insert(presReader.getNextPresident());
            
        presidentsQueue.displayQueues();
        presidentsQueue.selectionSortAll();
        presidentsQueue.displaySortedQueues();
        
        // reads all lines from text file and stores in presUpdateReader object
        presUpdateReader.readPresidents();
        
        // displays the updated presidents read in 
        presUpdateReader.showNewPres();
        
        // removes each president from presUpdateReader object and inserts into queue
        while (presUpdateReader.presRemaining())
            presidentsQueue.priorityInsert(presUpdateReader.getNextPresident());

        presidentsQueue.displayPriorityQueue();
    } // end main()
} // end Main
