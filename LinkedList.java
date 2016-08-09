/**
 * @author Anthony Pham
 * @version 2/17/14
 * 
 * LinkedList is a collection of data nodes. All methods here relate to how
 * one can manipulate those nodes.
 */
public class LinkedList {

	private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(String newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /**
     * Takes an event and inserts it to the end of the linked list
     * @param new event
     */
    public void insertAtTail(String newData)
    {
    	ListNode newNode;
    	newNode = new ListNode(newData);
    	if (getLength() == 0)
    	{
    		firstNode = newNode;
    	}
    	
    	else
    	{
    		ListNode tempNode;
    		tempNode = firstNode;
    		while (tempNode.next != null)
    		{
    			tempNode = tempNode.next;
    		}
    		tempNode.next = newNode;
    	}
    	length ++;
    }
    
    /**
     * adds data at certain point in linked list
     * @param data new String to be added
     * @param index point at which to add new data
     */
    public void add(String newData, int index)
    {
    	ListNode newNode, currentNode, lastNode;
    	newNode = new ListNode(newData);
    	
    	if (index == 0)
    	{
    		this.insertAtHead(newData);
    	}
    	
    	else if (index == getLength())
    	{
    		this.insertAtTail(newData);
    	}
    	
    	else if (index < getLength())
    	{
    		currentNode = this.getNode(index);
    		lastNode = this.getNode(index-1);
    		lastNode.next = newNode;
    		newNode.next = currentNode;
    		length ++;
    	}
    }
    
    /**
     * removes head node
     * @return head node if there is one, null if there is not
     */
    public String removeHead()
    {
    	if (getLength() == 0)
    	{
    		return null;
    	}
    	
    	else
    	{
    		ListNode tempNode;
    		tempNode = firstNode;
    		firstNode = firstNode.next;
    		length --;
    		return tempNode.data;
    	}
    }
    
    /**
     * removes end of linked list
     * @return data of removed node
     */
    public String removeTail()
    {
    	if (getLength() == 0)
    	{
    		return null;
    	}
    	
    	else
    	{
    		ListNode tempNode;
    		tempNode = firstNode;

    		while (tempNode.next != null)
    		{
    			tempNode = tempNode.next;
    		}
    		length --;
    		return tempNode.data;
    	}
    }
    
    /**
     * removes the data of a node at an index in the linked list
     * @return data of removed node
     */
    public String remove(int index)
    {
    	ListNode currentNode, lastNode;
		
    	if (index >= getLength() || index < 0)
    	{
    		return null;
    	}
    	
    	else if (index == 0)
    	{
    		return this.removeHead();
    	}
    	
    	else if (index == getLength()-1)
    	{
    		return this.removeTail();
    	}
    	
    	else
    	{
    		currentNode = this.getNode(index);
    		lastNode = this.getNode(index-1);
    		lastNode.next = currentNode.next;
    		length --;
    		return currentNode.data;
    	}
    }
    
    /**
     * getter
     * gets node in linked list
     * returns null if node is not in list
     */
    private ListNode getNode(int index)
    {
    	ListNode myNode;
    	myNode = firstNode;
    	
    	
    	if (index >= getLength())
    	{
    		return null;
    	}
    	
    	else
    	{
    		int count;
        	count = 0;
    		
    		while (myNode != null && count < index)
        	{
        		
        		myNode = myNode.next;
        		count ++;
        	}
    		return myNode;
    	}
    }
    
    /**
     * getter
     * gets data from index in linked list
     * @return data of node at index
     */
    public String getData(int index)
    {
    	return this.getNode(index).data;
    }
    
    /**
     * searches through linked list for event using event name
     * @param eventName name of desired event to seek
     * @return start time of event if it is in linked list or -1 if it is not
     */
    public int search(String myString)
    {
    	ListNode tempNode;
    	tempNode = firstNode;
    	boolean checkEnd;
    	checkEnd = false;
    	int index;
    	index = 0;
    	
    	while (checkEnd == false)
    	{
    		if (tempNode.data == myString)
    		{
    			return index;
    		}
    		
    		else if (tempNode.next == null)
    		{
    			checkEnd = true;
    		}
    		
    		else
    		{
    			tempNode = tempNode.next;
    			index ++;
    		}
    	}
    	return -1;
    }
    
    /** Turn entire chain into a string
     *  
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode n;
    	n=firstNode;
    	while (n!=null)
    	{
    		toReturn = toReturn + n;  //call node's toString automatically
    		n=n.next;
    		if (n!=null)
    		{
    			toReturn = toReturn + ",\n";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /** getter for number of nodes in the linked list
     * 
     * @return length of LL
     */
    public int getLength() {return length;}

}
