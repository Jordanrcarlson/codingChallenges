//Submitted by: Jordan Carlson
//Student Number: V00714886

import java.util.*;

//
// An implementation of a binary search tree.
//
// This tree stores both keys and values associated with those keys.
//
// More information about binary search trees can be found here:
//
// http://en.wikipedia.org/wiki/Binary_search_tree
//
// Note: Wikipedia is using a different definition of
//       depth and height than we are using.  Be sure
//       to read the comments in this file for the
//	 	 height function.
//
class BinarySearchTree <K extends Comparable<K>, V>  {

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	// These are package friendly for the TreeView class
	BSTNode<K,V>	root;
	int		count;

	int		findLoops;
	int		insertLoops;

	public BinarySearchTree (){
		root = null;
		count = 0;
		resetFindLoops();
		resetInsertLoops();
	}

	public int getFindLoopCount(){
		return findLoops;
	}

	public int getInsertLoopCount(){
		return insertLoops;
	}

	public void resetFindLoops(){
		findLoops = 0;
	}
	public void resetInsertLoops(){
		insertLoops = 0;
	}

	//
	// Purpose:
	//
	// Insert a new Key:Value Entry into the tree.  If the Key
	// already exists in the tree, update the value stored at
	// that node with the new value.
	//
	// Pre-Conditions:
	// 	the tree is a valid binary search tree
	//
	public void insert(K k, V v){

		if(root == null){

			root = new BSTNode<K,V>(k,v);

			count++;

		}

		BSTNode<K,V> current = root;

		while(true) {

			insertLoops++;

			if(k.compareTo(current.key) < 0){

				if(current.left == null){

					current.left = new BSTNode<K,V>(k,v);
					break;
				}
				else {
					current = current.left;
				}
			}

			else if(current.key.compareTo(k) == 0){

				current.value = v;
				return;

			} 
			else {
				if(current.right == null){

					current.right = new BSTNode<K,V>(k,v);
					break;
				}
				else{
					current = current.right;
				}
			}
		}
		count++;
	}

	//
	// Purpose:
	//
	// Return the value stored at key.  Throw a KeyNotFoundException
	// if the key isn't in the tree.
	//
	// Pre-conditions:
	//	the tree is a valid binary search tree
	//
	// Returns:
	//	the value stored at key
	//
	// Throws:
	//	KeyNotFoundException if key isn't in the tree
	//
	public V find (K key) throws KeyNotFoundException{

		BSTNode<K,V> current = root;

		while(true){

			if(current == null){

				throw new KeyNotFoundException();
			}
			else if(key.compareTo(current.key) < 0){

				current = current.left;
			}
			else if(current.key.compareTo(key) == 0){

				return current.value;
			}
			else{
				current = current.right;
			}

			findLoops++;
		}
	}

	//
	// Purpose:
	//
	// Return the number of nodes in the tree.
	//
	// Returns:
	//	the number of nodes in the tree.
	public int size() {

		return count;
	}

	//
	// Purpose:
	//	Remove all nodes from the tree.
	//
	public void clear(){

		count = 0;
		root = null;

	}

	//
	// Purpose:
	//
	// Return the height of the tree.  We define height
	// as being the number of nodes on the path from the root
	// to the deepest node.
	//
	// This means that a tree with one node has height 1.
	//
	// Examples:
	//	See the assignment PDF and the test program for
	//	examples of height.
	//

	private int recursion(BSTNode node) {
		if(node == null)
			return 0;
		else if(node.left == null && node.right == null)
			return 1;
		else{
			int right = recursion(node.right);
			int left = recursion(node.left);

			if(right > left){
				return 1 + right;
			}
			else{
				return 1 + left;
			}
		}
	}

	public int height(){
		return recursion(root);
	}

	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a level-order
	// traversal of the tree.
	//
	// Level order is most commonly implemented using a queue of nodes.
	//
	//  From wikipedia (they call it breadth-first), the algorithm for level order is:
	//
	//	levelorder()
	//		q = empty queue
	//		q.enqueue(root)
	//		while not q.empty do
	//			node := q.dequeue()
	//			visit(node)
	//			if node.left != null then
	//			      q.enqueue(node.left)
	//			if node.right != null then
	//			      q.enqueue(node.right)
	//
	// Note that we will use the Java LinkedList as a Queue by using
	// only the removeFirst() and addLast() methods.
	//


	private void preOrder (BSTNode<K,V> node, List <Entry<K,V>> list){

		if(node != null){

			list.add(new Entry<K,V>(node.key, node.value));

			preOrder(node.left,list);

			preOrder(node.right,list);

		}
	}

	private void inOrder (BSTNode<K,V> node, List <Entry<K,V>> list){

		if(node != null){

			inOrder(node.left,list);

			list.add(new Entry<K,V>(node.key, node.value));

			inOrder(node.right,list);
		}

	}


	private void postOrder (BSTNode<K,V> node, List <Entry<K,V>> list){

		if(node != null){

			postOrder(node.left,list);

			postOrder(node.right,list);

			list.add(new Entry<K,V>(node.key, node.value));
		}

	}


	public List<Entry<K,V>> entryList(){

		List<Entry<K,V>> list = new LinkedList<Entry<K,V>>();
		LinkedList<BSTNode<K,V>> queue = new LinkedList<BSTNode<K,V>>();

		queue.addLast(root);
		BSTNode<K,V> current;

		while(!queue.isEmpty()){

			current = queue.removeFirst();

			list.add(new Entry<K,V>(current.key, current.value));

			if(current.left != null){
				queue.addLast(current.left);
			}
			if(current.right != null){
				queue.addLast(current.right);
			}
		}

		return list;
	}


	//
	// Purpose:
	//
	// Return a list of all the key/value Entrys stored in the tree
	// The list will be constructed by performing a traversal
	// specified by the parameter which.
	//
	// If which is:
	//	BST_PREORDER	perform a pre-order traversal
	//	BST_POSTORDER	perform a post-order traversal
	//	BST_INORDER	perform an in-order traversal
	//
	public List<Entry<K,V> > entryList (int which){

		List<Entry<K,V> > list = new LinkedList<Entry<K,V>>();

		if(which == BST_PREORDER){

			preOrder(root,list);

		} 
		else if(which == BST_INORDER){

			inOrder(root,list);

		} 
		else{

			postOrder(root,list);

		}

		return list;
	}
}
