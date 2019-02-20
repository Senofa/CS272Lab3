/**
 * 
 * @author Zachary Holt
 * @date 2/11/19
 * @course CS272
 * @lab Lab 3
 * @purpose node in a link list that holds integer values
 * 
 */

public class IntNode {
	// ~~~~~~~~~~~~~~~~~~~~~~~member variables~~~~~~~~~~~~~~~~~~~~~~
	private int data;
	private IntNode link;

	// ~~~~~~~~~~~~~~~~~~~~~~Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~
	public IntNode() {
		data = 0;
		link = null;
	}// end no arg constructor
	
	public IntNode(int _data) {
		data = _data;
		link = null;
	}//end data only constructor

	public IntNode(int _data, IntNode _link) {
		data = _data;
		link = _link;
	}// end data/link arg constructor

	// ~~~~~~~~~~~~~~~~~~~~~~~~~Mutators~~~~~~~~~~~~~~~~~~~~~~~
	public int getData() {
		return data;
	}// end func getData

	public IntNode getLink() {
		return link;
	}// end func getLink

	public void setData(int _data) {
		data = _data;
	}// end func setData

	public void setLink(IntNode _link) {
		link = _link;
	}// end func setLink

	// ~~~~~~~~~~~~~~~~~~~~~~~Other Methods~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * addNodeAfterThis - adds a node to the linked list after (closer to the null link) the calling object
	 * @param _newData value of the node to be added after the calling object
	 */
	public void addNodeAfterThis(int _newData) {
		link = new IntNode(_newData, link);
	}//end func addNodeAfterThis
	
	
	/**
	 * toString - returns a string containing the contents of the entire linked list starting at the calling object
	 * @return string containing the contents of the linked list started at the calling object
	 */
	public String toString() {
		IntNode cursor = link;
		String retString = new String();
		retString = retString + data;
		
		// Traverse list and concatenate values into return string
		while (cursor != null) {
			// System.out.printf("%d", cursor.data);
			retString = retString + "->";
			retString = retString + cursor.data;
			cursor = cursor.link;
		} // end list traverse loop
		return retString;
	}// end func toString
	
	
	public void removeNodeAfterThis() {
		//special conditions: link is null, meaning node is last in list, do nothing
		if (link != null) {
			link = link.link;
		}//end not last node check
	}//end func removeNodeAfterThis
	
	
	/**
	 * search - searches the linked list for a number
	 * @param _head	head node of list to search
	 * @param _searchToken number to search for in list
	 * @return true if searchToken is found in the list false if not
	 */
	public static boolean search(IntNode _head, int _searchToken) {
		IntNode cursor = _head;
		
		//traverse list and return true if token is found
		while (cursor != null) {
			if (cursor.data == _searchToken) {
				return true;
			}//end searchToken found check
			cursor = cursor.link;
		}//end list traverse loop
		
		return false;
	}//end func search
	
	
	/**
	 * listSearch - searches the linked list for a number, returns the node
	 * @param _head	head node of list to search
	 * @param _searchToken number to search for in list
	 * @return the first node that matches the token null if no match
	 */
	public static IntNode listSearch(IntNode _head, int _searchToken) {
		IntNode cursor = _head;
		
		//traverse list and return cursor if token is found
		while (cursor != null) {
			if (cursor.data == _searchToken) {
				return cursor;
			}//end searchToken found check
			cursor = cursor.link;
		}//end list traverse loop
		
		return null;
	}//end func search
	
	
	/**
	 * listLength - returns the number of nodes in a linked list
	 * 
	 * @param _head head of the linked list
	 * @return number of nodes in the list
	 */
	public static int listLength(IntNode _head) {
		int count = 0;
		IntNode cursor = _head;
		// traverse the list counting elements until the cursor is null
		while (cursor != null) {
			count++;
			cursor = cursor.link;
		} // end list traverse loop

		return count;
	}// end func listLength
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Main~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		System.out.printf("%s\n", "Creating linked list with 10 nodes (9 to 0)");
		IntNode head1 = new IntNode();
		IntNode tail1 = head1;
		for (int i = 1; i < 10; i++) {
			head1 = new IntNode(i, head1);// creates a new element w/ value i, link head1, and assigns it to head1
			//System.out.printf("%d", i);
		} // end list creation loop
		System.out.printf("%s%d%s\n", "According to listLength the list is ", IntNode.listLength(head1), " nodes long.");
		System.out.printf("%s\n", head1);
		
		System.out.printf("\n%s\n", "Testing addNodeAfterThis by adding 10 after the last node:");
		tail1.addNodeAfterThis(10);
		tail1 = tail1.getLink();
		System.out.printf("From head1: %s\n", head1);
		System.out.printf("From new tail1: %s\n", tail1);
		
		System.out.printf("\n%s\n", "Testing addNodeAfterThis by adding 25 after the first node:");
		head1.addNodeAfterThis(20);
		System.out.printf("From head1: %s\n", head1);
		System.out.printf("From new tail1: %s\n", tail1);
		
		System.out.printf("\n%s\n", "Creating new linked list with 10 nodes (10 to 1)");
		IntNode head2 = new IntNode(10);
		IntNode tail2 = head2;
		for (int i = 9; i >= 1; i--) {
			tail2.addNodeAfterThis(i);
			tail2 = tail2.getLink();
		}//end list creation loop
		System.out.printf("%s%d%s\n", "According to listLength the list is ", IntNode.listLength(head2), " nodes long.");
		System.out.printf("From head2: %s\n", head2);
		System.out.printf("From tail2: %s\n", tail2);
		
		System.out.printf("\n%s\n", "Testing search function. Searching list1 for 10. Should return true:");
		if (IntNode.search(head1, 10)) {
			System.out.printf("%s\n", "true");
		} else {
			System.out.printf("%s\n", "false");
		} //end search for 10 response check
		
		System.out.printf("\n%s\n", "Testing search function. Searching list1 for 35. Should return false:");
		if (IntNode.search(head1, 35)) {
			System.out.printf("%s\n", "true");
		} else {
			System.out.printf("%s\n", "false");
		} //end search for 10 response check
		
		System.out.printf("\n%s\n", "Testing search function. Searching list2 for 10. Should return false:");
		if (IntNode.search(head2, 10)) {
			System.out.printf("%s\n", "true");
		} else {
			System.out.printf("%s\n", "false");
		} //end search for 10 response check
		
		System.out.printf("\n%s\n", "Testing removeNodeAfterThis on head1. 20 should be removed");
		System.out.printf("%d nodes before remove: %s\n", IntNode.listLength(head1), head1);
		head1.removeNodeAfterThis();
		System.out.printf("%d nodes after remove: %s\n", IntNode.listLength(head1), head1);
		
		System.out.printf("\n%s\n", "Testing removeNodeAfterThis on tail1. there should be no change");
		System.out.printf("%d nodes before remove: %s\n", IntNode.listLength(head1), head1);
		tail1.removeNodeAfterThis();
		System.out.printf("%d nodes after remove: %s\n", IntNode.listLength(head1), head1);
		
		IntNode nodeBeforeRemove = head1;
		System.out.printf("\n%s\n", "Testing removeNodeAfterThis on list1 removing after value 1. 0 should be removed");
		System.out.printf("%d nodes before remove: %s\n", IntNode.listLength(head1), head1);
		nodeBeforeRemove = IntNode.listSearch(head1, 1);
		nodeBeforeRemove.removeNodeAfterThis();
		System.out.printf("%d nodes after remove: %s\n", IntNode.listLength(head1), head1);
		
	}// end main

}// end class IntNode