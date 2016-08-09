/**
 * @author Anthony Pham
 * @version 2/19/14
 * 
 * ListNode is a building block for a linked list of data items
 */
public class ListNode {
	
	 public String data;
	 public ListNode next;   // pointer to next node
	    
	 /** Non-default constructor
	 * 
	 * @param String you want stored in this node
	 */
	 public ListNode(String newString)
	 {
		 this.data = newString;
	     this.next = null;
	 }
	    
	 // if you say "System.out.println(N)" where N is a ListNode, the
	 // compiler will call this method automatically to print the contents
	 // of the node.  It's the same as saying "System.out.println(N.toString())"
	 public String toString()
	 {
	     return data.toString();  // call the toString() method in Event class
	 }	    
}
