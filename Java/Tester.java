/*
 * File: Tester.java
 * Created by Tianming Wei
 * Example code created for Lab06, CSC115 201901
 */
 
public class Tester{
	public static void main(String[] args){
		String expression1 = "{ ( ( ) ] }";
		String expression2="33 + { [ ( 4 - 1 ) * ( 3 + 4 ) ] / ( 2 + 3 ) } ";
		
		BracketBalance test1 = new BracketBalance(expression1);
		
		if(test1.isBalanced()){
			System.out.println("The expression \"" + expression1 + "\" is balanced.");
			System.out.println("TEST 1 FAILED.");
		}else{
			System.out.println("The expression \"" + expression1 + "\" is not balanced.");
			System.out.println("TEST 1 PASSED.");
		}
	}
}
