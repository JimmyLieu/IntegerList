/**Jimmy Lieu
 * COSC 2336 001
 * 10/23/2022
 * Purpose: To test a linked list of integers, add, remove, and reverse the list. (Program 2)
 */
package adt;
/** To test a linked list of integers, add, remove, and reverse the list.
 * 
 * @author jimmylieu
 * @version 1.0
 * @since 10/23/2022
 */
public class IntegerList {
	/**Head maintains the one and only link into the list. It references
	 * the first item in the list. 
	 */
	IntegerNode head;
	/**Constant that stores a value for the head of the list
	 */
	int HEAD_VALUE = -999999;
	/**Creates an integer list
	 */
	public IntegerList() {
		head = new IntegerNode(HEAD_VALUE, null);
	}
	/**The method used to add an integer into a linked list.
	 * @param itemToAdd to add an integer into a linked list.
	 
	 */
	public void add(int itemToAdd) {
		IntegerNode tempNode = head;
		while (tempNode.getNext() != null && tempNode.getNext().getItem() < itemToAdd) {
			tempNode = tempNode.getNext();
		}

		IntegerNode newNode = new IntegerNode(itemToAdd);
		if(tempNode.getNext() == null) {
			tempNode.setNext(newNode);

		}
		else { 
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
	}
	/**The method used to remove item/integer from a linked list.
	 * 
	 * @param itemToRemove removes an item/integer from linked list.
	 * @return a boolean
	 */
	public boolean remove(int itemToRemove) {
		IntegerNode tempNode = head;
		while (tempNode.getNext() != null && tempNode.getNext().getItem() != itemToRemove) {
			tempNode = tempNode.getNext();
		}
		if (tempNode.getNext() == null) {
			return false;
		}
		else {
			tempNode.setNext (tempNode.getNext().getNext());
			return true;
		}

	}
	/**Reverse all the references in the linked list, making it backwards. 
	 * @return 
	 */
	public void reverse() {
		IntegerNode prev = null;
		IntegerNode curr = head.getNext();
		IntegerNode next;

		while(curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}

		head.setNext(prev);
	}
	/**Traverse the list, appending to a String as it goes. For each node, if that 
	 * node is not the head, just appends that node's toString.
	 * @return toString 
	 */
	public String toString() {
		String answer = "";
		IntegerNode temp = head.getNext();
		while(temp != null) {
			if (temp.getNext() == null) {
				answer += temp.toString();
			}
			else {
				answer += temp.getItem() + " -> ";
			}
			temp = temp.getNext();
		}
		return answer;	
	}
	/**The main where users add, remove, and reverse into 
	 * a linked list. 
	 *  
	 * @param args NONE
	 */
	public static void main (String[] args) {
		IntegerList list = new IntegerList();
		//Add 5 to an empty list, Empty List Case
		list.add(5);
		System.out.println("Adding 5: ");
		System.out.println(list);

		//Add 7 to list, Add to tail case
		list.add(7);
		System.out.println("Adding 7: ");
		System.out.println(list);

		//Add 3, Add to head case
		list.add(3);
		System.out.println("Adding 3: ");
		System.out.println(list);

		//Add 1
		list.add(1);
		System.out.println("Adding 1: ");
		System.out.println(list);

		//Add 6, add to middle case
		System.out.println("Adding 6: ");
		list.add(6);
		System.out.println(list);

		//Add 9 
		System.out.println("Adding 9: ");
		list.add(9);
		System.out.println(list);

		//Output the reversed list
		System.out.println("REVERSING");
		list.reverse();
		System.out.println(list);

		//Output the reversed list, reversed again (thus restoring the list)
		System.out.println("FIXING");
		list.reverse();
		System.out.println(list);

		//Removing 11, Should say item not found, traversed whole list case.
		if (!list.remove(11))
			System.out.println("Item " +11+" not found");
		System.out.println(list);

		//Remove 4, Should say item not found, traversed partial list case
		if (!list.remove(4))
			System.out.println("Item " +4+" not found");
		System.out.println(list);

		//Remove -3, Should say item not found, traversed none of the list case
		if (!list.remove(-3))
			System.out.println("Item " +-3+" not found");
		System.out.println(list);

		//Remove 5, Should remove from the middle case
		if (!list.remove(5))
			System.out.println("Item " +5+" not found");
		System.out.println("Removing 5: ");
		System.out.println(list);

		//Remove 6
		if (!list.remove(6))
			System.out.println("Item " +6+" not found");
		System.out.println("Removing 6: ");
		System.out.println(list);

		//Remove 6 again, removing an item that WAS in the list case
		if (!list.remove(6))
			System.out.println("Item " +6+" not found");
		System.out.println(list);

		//Remove 1, from the head case
		if (!list.remove(1))
			System.out.println("Item " +1+" not found");
		System.out.println("Removing 1: ");
		System.out.println(list);

		//Remove 3, from head case when head case was removed
		if (!list.remove(3))
			System.out.println("Item " +3+" not found");
		System.out.println("Removing 3: ");
		System.out.println(list);

		//Remove 9, from tail case
		if (!list.remove(9))
			System.out.println("Item " +9+" not found");
		System.out.println("Removing 9: ");
		System.out.println(list);
	}

}
