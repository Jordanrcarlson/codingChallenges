/*
 * File: BracketBalance.java
 * Created by Tianming Wei
 * Example code created for Lab06, CSC115 201901
 */
 
import java.util.*;

public class BracketBalance {
	public String expression;
	
	public BracketBalance(String expression) {
		this.expression = expression;		
	}
	
	public boolean isEmpty() {

		return expression == null;
	}
	
	/*
	Check if the brackets in the string is balanced. For example, "{[()]}" is balanced, return true.  "{[(])}" is not balanced, return false. Assume the string is not null, nor
	empty.
	*/
	public boolean isBalanced(){	

	Stack S = new Stack();
	for (int i = 0; i<this.expression.length(); i++){
		if (this.expression.charAt(i) == '[' ||
		this.expression.charAt(i) == '{' ||
		this.expression.charAt(i) == '(' ){
			S.push(this.expression.substring(i,i +1);
		} else if(this.expression.charAt(i) == ')' ){
		// if char(i) is equal to ( continue otherwise return false
		} else if(this.expression.charAt(i) == '}' ){
		// if char(i) is equal to ( continue otherwise return false
		} else if(this.expression.charAt(i) == ']' ){
		// if char(i) is equal to ( continue otherwise return false
		}
	}
		
	return this.isempty();

	}
}
