/*
 * Name: Jordan Carlson
 * Student Number: V00714886
 */

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode head;
	private IntegerNode tail;
	private int size;



	public IntegerLinkedList()
	{

		this.head = null;
		this.tail = null;
		this.size = 0;

	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{

		IntegerNode temp = new IntegerNode(x);
		if (size != 0){



			head.prev = temp;

			temp.next = head;

			head = temp;


			
		}

		else{
			tail = temp;
			head = temp;

		}
		
		size++;

	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x)
	{
		IntegerNode temp = new IntegerNode(x);
		if (size != 0){

			tail.next = temp;
			temp.prev = tail;
			tail = temp;

			temp.next = null;
			
		}

		else{
			head = temp;
			tail = temp;

			
			temp.prev = null;
			temp.next = null;

		}
		
		size++;
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos)
	{
		IntegerNode temp = new IntegerNode(x);

		if (size == 0){
			head = temp;
			tail = temp;
			size ++;
		}

		else if(pos == 0){

		addFront(x);
		}

		else if(pos == size){

		addBack(x);
		}

		else{
			temp = head;
			for(int i = 0; i < pos - 1; i++){
				temp = temp.next;
			}
			IntegerNode current = new IntegerNode(x);
			temp.next.prev = current;
			current.prev = temp;
			current.next = temp.next;
			temp.next = current;
			
			size ++;
		}
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return size;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		IntegerNode temp = head;

		for(int i = 0; i < pos; i++){
		temp = temp.next;
		}
	
		return temp.getValue();
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{

	this.head = null;
	this.tail = null;
	this.size = 0;

	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{

		IntegerNode temp = head;

	int i = 0;
	while (temp != null)
	{
		if (temp.getValue() == value)
		{
		removeAt(i);
		i--;
	}
	temp = temp.next;
	i++;
		}
	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	public void removeAt (int pos)
	{
		IntegerNode temp = head;
		if (pos == 0) {
		if (temp.next != null){
		temp = temp.next;
		temp.prev = null;
		head = temp;
		size--;

	}
		else {
			clear();
		}
	}
	else if(pos == size - 1){
	temp = tail;
	temp = temp.prev;
	temp.next = null;
	tail = temp;
	size--;

	}

	else {
	temp = tail;

	for (int i = size - 1; i > pos + 1; i--){
		temp = temp.prev;
	}
	temp.prev = temp.prev.prev;
	temp = temp.prev;

	temp.next = temp.next.next;
	size--;
}
}


	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		String s = "{";
		IntegerNode temp = head;

		for (int i = 0; i < size; i++)
		{


		s += temp.getValue();



		temp = temp.next;
			if (i != (size - 1))
			{
				s+= ",";
			}
		}
		s+= "}";
		return s;
	}
}
