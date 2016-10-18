
package project2Final;

import java.util.ArrayList;

/**
 * "Class description"
 * 
 * @author Matthew Ramsay
 * @since 2016-09-24
 */
public class Queue 
{
    private ArrayList<Presidents> queueDem;
    private ArrayList<Presidents> queueRep;
    private ArrayList<Presidents> queueWhig;
    private int frontDem, frontRep, frontWhig, rearDem, rearRep, rearWhig;  
    private int demElems, repElems, whigElems;
    
    
    /**
     * Description of method
     * 
     * @param none
     * @return Returns nothing
     */
    public Queue() // constructor
    {
        queueRep = new ArrayList<Presidents>();
        queueDem = new ArrayList<Presidents>();
        queueWhig = new ArrayList<Presidents>();
        frontDem = 0;
        frontRep = 0;
        frontWhig = 0; 
        rearDem = -1;
        rearRep = -1;
        rearWhig = -1;
        demElems = 0;
        repElems = 0;
        whigElems = 0;
    }
    
    
    /**
     * Inserts Presidents object into queue base on party
     * 
     * @param tempPres : Presidents
     * @return Returns nothing
     */
    public void insert(Presidents tempPres) // change parameter names
    {
        String partyQ = tempPres.getParty();
        
        switch(partyQ)
        {
            case "Democrat":
                queueDem.add(++rearDem, tempPres);
                demElems++;
                break;
            case "Republican":
                queueRep.add(++rearRep, tempPres);
                repElems++;
                break;
            case "Whig":
                queueWhig.add(++rearWhig, tempPres);
                whigElems++;
                break;
            default:
                //System.out.printf("\nNo party matching %s was found\n", partyQ);
        } // end switch
    } // end insert
    
    
    /**
     * Displays the Presidents elements in each array 
     * 
     * @param nothing
     * @return Returns nothing 
     */
    public void displayQueues()
    {
        System.out.println("\n\n---------------------------------------------");
        System.out.printf("\n\n%6s\n","Presidental Queues");
        
        System.out.println("\n\nQueue 1 : Democrats");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayDem();
        
        System.out.println("\n\nQueue 2 : Republicans");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayRep();
        
        System.out.println("\n\nQueue 3 : Whigs");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayWhig();
       
    } // end displayQueues()
    
    /**
     * Displays each sorted queue's elements along with headers
     * 
     * @param none
     * @return Returns nothing
     */
    public void displaySortedQueues()
    {
        System.out.println("\n\n---------------------------------------------");
        
        System.out.printf("\n\n%6s\n","Sorted Presidental Queues");
                
        System.out.println("\n\nQueue 1 : Democrats");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayDem();
        
        System.out.println("\n\nQueue 2 : Republicans");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayRep();
        
        System.out.println("\n\nQueue 3 : Whigs");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayWhig(); 
    } // end displayQueues()
    
    
    /**
     * Loop through and print each item in queueRep
     * 
     * @param none
     * @return Returns nothing 
     */
    private void displayRep()
    {
        for (int i = 0; i < repElems-1; i++) 
        {
            System.out.println(queueRep.get(i));
        } // end for
    } // end displayRep()
    
    
    /**
     * Loop through and print each item in queueRep
     * 
     * @param none
     * @return Returns nothing 
     */
    private void displayDem()
    {
        for (int i = 0; i < demElems-1; i++) 
        {
            System.out.println(queueDem.get(i));
        } // end for
    } // end displayDem()
    
    
    /**
     * Loop through and print each item in queueRep
     * 
     * @param none
     * @return Returns nothing 
     */
    private void displayWhig()
    {
        for (int i = 0; i < whigElems-1; i++) 
        {
            System.out.println(queueWhig.get(i));
        } // end for
    } // end displayWhig()   

    
    /**
     * Performs a selection sort of each of the the 3 queues
     * 
     * @param None 
     * @return Returns nothing
     */
    public void selectionSortAll() 
    {
        selectionSortDem();
        selectionSortRep();
        selectionSortWhig();
    }
    
    
    /**
     * Performs a selection sort of elements in queueDem
     * 
     * @param None 
     * @return Returns nothing
     */
    private void selectionSortDem()
    {
        int demIn, demOut, demMin; 
        
        for (demOut = 0; demOut < queueDem.size()-1; demOut++)
        {
            demMin = demOut; 
           
            for (demIn = demOut+1; demIn < queueDem.size(); demIn++)//inner loop forward
            {
                if (queueDem.get(demMin).getNumber() > queueDem.get(demIn).getNumber())//if out of order
                    demMin = demIn;
            } // end for loop
            demSwap(demOut, demMin);
        } // end for loop
    } // end .....
    
    
    /**
     * Performs a selection sort of elements in queueRep
     * 
     * @param None 
     * @return Returns nothing
     */
    private void selectionSortRep()
    {
        int repNumIn, repNumOut, repMin; 
        
        for (repNumOut = 0; repNumOut < queueRep.size()-1; repNumOut++)
        {
            repMin = repNumOut; 
           
            for (repNumIn = repNumOut+1; repNumIn < queueRep.size(); repNumIn++)//inner loop forward
            {
                if (queueRep.get(repMin).getNumber() > queueRep.get(repNumIn).getNumber())//if out of order
                    repMin = repNumIn;
            } // end for loop
            repSwap(repNumOut, repMin);
        } // end for loop
    } // end .....
    
    
    /**
     * Performs a selection sort of elements in queueWhig 
     * 
     * @param None 
     * @return Returns nothing
     */
    private void selectionSortWhig()
    {
        int whigNumIn, whigNumOut, whigMin; 
        
        for (whigNumOut = 0; whigNumOut < queueWhig.size()-1; whigNumOut++)
        {
            whigMin = whigNumOut; 
           
            for (whigNumIn = whigNumOut+1; whigNumIn < queueWhig.size(); whigNumIn++)//inner loop forward
            {
                if (queueWhig.get(whigMin).getNumber() > queueWhig.get(whigNumIn).getNumber())//if out of order
                    whigMin = whigNumIn;
            } // end for loop
            whigSwap(whigNumOut, whigMin);
        } // end for loop
    } // end .....
    
    
    /**
     * Swaps the positions of the 2 objects in queueDem  
     *
     * @param one : integer
     * @param two : integer
     * @return returns nothing
     */
    private void demSwap(int one, int two)
    {      
      Presidents temp = queueDem.get(one);
      queueDem.set(one, queueDem.get(two));
      queueDem.set(two, temp);
    } // end swap method
    
    
    /**
     * Swaps the positions of the 2 objects in queueRep 
     *
     * @param one : integer
     * @param two : integer
     * @return returns nothing
     */
    private void repSwap(int one, int two)
    {      
      Presidents temp = queueRep.get(one);
      queueRep.set(one, queueRep.get(two));
      queueRep.set(two, temp);
    } // end swap method
        
    
    /**
     * Swaps the positions of the 2 objects in queueWhig 
     *
     * @param one : integer
     * @param two : integer
     * @return returns nothing
     */
        private void whigSwap(int one, int two)
    {      
      Presidents temp = queueWhig.get(one);
      queueWhig.set(one, queueWhig.get(two));
      queueWhig.set(two, temp);
    } // end swap method
    
    
    /**
     * Inserts Presidents item in queue based on party, item is arranged within by number
     * 
     * @param item : Presidents
     * @return Returns nothing 
     */
    public void priorityInsert(Presidents item)       // insert item
    { 
        int j;

        switch (item.getParty()) // sorts by party
        {
            case "Democrat":
            if(demElems == 0)                    // if no items,
                queueDem.add(demElems++, item);  // insert at 0

            else                                 // if items,
            {
                for(j=demElems-1; j >= 0; j--)        // start at end,
                {
                    if(item.getNumber() <= queueDem.get(j).getNumber()) // if new item larger,
                    {
                        queueDem.add(j+1, queueDem.get(j)); // shift upward
                        queueDem.remove(j);
                    } // end if
                    else // if smaller,
                        break; // done shifting
                } // end for 

                queueDem.add(j+1, item);   // insert it
                demElems++;
            } // end else
            break;
            
            case "Republican":
                
            if(repElems == 0)                    // if no items,
                queueRep.add(repElems++, item);  // insert at 0

            else                                 // if items,
            {
                for(j=repElems-1; j >= 0; j--)        // start at end,
                {
                    if(item.getNumber() <= queueRep.get(j).getNumber()) // if new item larger,
                    {
                        queueRep.add(j+1, queueRep.get(j)); // shift upward
                        queueRep.remove(j);
                    } // end if
                    else // if smaller,
                        break; // done shifting
                } // end for 

                queueRep.add(j+1, item);   // insert it
                repElems++;
            } // end else
                break;
                
                case "Whig":
                if(whigElems == 0)                    // if no items,
                queueWhig.add(whigElems++, item);  // insert at 0

            else                                 // if items,
            {
                for(j=whigElems-1; j >= 0; j--)        // start at end,
                {
                    if(item.getNumber() <= queueWhig.get(j).getNumber()) // if new item larger,
                    {
                        queueWhig.add(j+1, queueWhig.get(j)); // shift upward
                        queueWhig.remove(j);
                    } // end if
                    else // if smaller,
                        break; // done shifting
                } // end for 

                queueWhig.add(j+1, item);   // insert it
                whigElems++;
            } // end else
            break;
            
            default:
                break;    
        } // end switch
    } // end priorityInsert()
    
    
    /**
     * Displays each queue, all below an "Updated Priority Queue" heading
     * 
     * @param none
     * @return Returns nothing 
     */
    public void displayPriorityQueue()
    {
        System.out.println("\n\n---------------------------------------------");
        
        System.out.println("\n\nUpdated Priority Queues:");
        System.out.println("\n\nQueue 1 : Democrats");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayDem();

        System.out.println("\n\nQueue 2 : Republicans");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayRep();

        System.out.println("\n\nQueue 3 : Whigs");
        System.out.printf("\n%-14s%-16s%s\n\n","Number", "Name", "Party");
        displayWhig();
    } // end displayPriorityQueue()
} // end class Queue
