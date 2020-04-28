
/*
 * File: LinkedList.java
 * Created by Nirav Galani
 * Modified by Tianming Wei
 * Example code created for Lab08, CSC115 201901
 */

public class LinkedList{

        public Node head;
        
        public LinkedList(){
                this.head = null;
        }
        public LinkedList(Node l){
                head = l;        
        }
	
		public static int length (Node l)
		{
			if (l == null)
			  return 0;
			else
			  return 1 + length(l.next);
		}
		/*
		 * Print the strings in the current 
		 * linked list (Recursive Version)
		 *
		 */
		public void print(Node l) {
				
		if (l == null) {
			return ;
		}
		else {
			System.out.print(l.item + " ");
			print(l.next);
		}

	}
		
		/*
		 * Print the strings in the current 
		 * linked list (Non-recursive Version)
		 *
		 */
		public void print2() {
				Node temp = head;
				while (temp!=null) {
					System.out.print(temp.item + " ");				
					temp = temp.next;
				}
		}
		
		/*
		 * Print the strings in the current 
		 * linked list in a reverse order 
		 * (Recursive Version)
		 *
		 */
		public void reversePrint(Node l) {
		if (l == null) {
			return ;
		}
		else {
			reversePrint(l.next);
			System.out.print(l.item + " ");

		}

	} 
		
		/*
		 * Insert a String to the rear of the current 
		 * linked list (Recursive Version)
		 *
		 */
		public Node insertRear(Node l, String item) {
				
		if (l == null){

				return new Node(item);	
		}
		if (l.next == null) {
			l.next = new Node(item);
			return head;
		else {
			return insertRear(l.next, item);

						
		}
}
		
		/*
		 * Insert a String to the rear of the current 
		 * linked list (Non-recursive Version)
		 *
		 */
        public void insertRear2(String item){
                Node n1 = new Node(item);
                if (head == null)
					head = n1;
				else {
					Node temp = head;
					while (temp.next != null) 
						temp = temp.next;
					temp.next = n1;                
				}
		}
		
		/*
		 * Find a String in the current 
		 * linked list (Recursive Version)
		 *
		 */
        public Node find(Node l, String item) {
			

		if (head == null){
			return;
		else {
			
			
                return null;
}		
		}
		
		/*
		 * Find a String in the current 
		 * linked list (Non-recursive Version)
		 *
		 */
        public Node find2(String item){
                for (Node curr = head; curr != null; curr = curr.next){
                        if (curr.item.equals(item)){
                                return curr;
                        }
                }
                return null;
        }

        public String toString(){
                String st = "";
                System.out.println("Head is " + head);
                if (head != null){
                        for (Node curr = head; curr != null; curr = curr.next){
                                System.out.println("CURR is " + curr);
                                st = st + "\n" + curr.toString() ;
                        }
                        return st;
                } else {
                        return "EMPTY";
                }
        }
}
