//Name: Jordan Carlson
//Student Number: V00714886

public class StackRefBased<T> implements Stack<T>{
	public StackNode<T> head;
	public int size;


  public StackRefBased(){  //constructor

	head = null;
	size = 0;
  }

  public int size(){					//constructor

      return size;
  }

  public boolean isEmpty(){		//constructor
      return (head == null);
  }

  public void push(T data){				//modifier

	StackNode<T> current = new StackNode<T>(data);

	current.next = head;
	current.data = data;

	head = current;
	size++;
  }

  public T pop() throws StackEmptyException{

    if(head == null){
			throw new StackEmptyException();
		}
		else{
			T current = head.data;
			head = head.next;
			size--;
			return current;
		}
  }

  public T peek() throws StackEmptyException{

      return head.data;
  }


  public void makeEmpty(){

		size = 0;
		head = null;

  }

  public String toString() {
      StackNode<T> current = head;
			String output = "{";
			if(head == null){
				output = output + "}";
			}
			else{
				while(current != null){
					output = output + current.data;
					current = current.next;
				}
				while(current.next != null){
				output = output + ",";
		  	}
				output = output + "}";
				}
	return output;
  }
}
