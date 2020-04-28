/*
 * File: Stack.java
 * Created by Tianming Wei
 * Example code created for Lab06, CSC115 201901
 */
 
public class Stack {
	public Node top;
	
	public Stack(){
		top = null;
	}
	
	/*
	return true if the stack is empty, false otherwise.
	*/
	public boolean empty(){		
		return (this.top == null);
	}
	
	/*
	return the object at the top of the stack. The stack is not changed.
	return null if the stack is empty.
	*/
	public String peek() {

	if(this.empty())
		return null;	
	return this.top.item;
	
	}
	
	/*
	remove and return the object at the top of the stack. If the stack is {1, 4, -3}, after the pop operation, the stack is {4, -3} and 1 is returned.
	return null if the stack is empty.
	*/
	public String pop() {
		if (this.empty())
		return null;
	Node temp = top;
	top = top.next;
	return temp;
	}
	
	/*
	push item at the top of the stack.
	*/
	public void push(String item){
	//node(value,next)
		top = new Node(item,top);
	}
	
	/*
	return a string representation of the stack. If it is empty, return "{}". Or
    return {2, 4, 9} if the top of the stack is 2, and 4 and 9 in the subsequent nodes.	
	*/
	public String toString(){
		if (this.top == null)
		return "{}";
	}
	
	/*
	write your tester in the main.
	*/
	public static void main(String[] args){
		Stack myStack = new Stack();
		// tests start ... 
		System.out.println(myStack);
	}
}
