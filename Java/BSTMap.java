//Submitted by: Jordan Carlson
//Student Number: V00714886

import java.util.*;

public class BSTMap<K extends Comparable<K>, V> implements  Map<K, V>  {

	private BinarySearchTree<K,V>  SearchTree;

	public BSTMap(){

		SearchTree = new BinarySearchTree<K,V>();

	}

	public boolean containsKey(K key){

		try{
			SearchTree.find(key);
		} catch(KeyNotFoundException k) {

			return false;
		  }
		
		return true;
	}

	public V get (K key) throws KeyNotFoundException{

		return SearchTree.find(key);
	}

	public List<Entry<K,V> >	entryList(){

		return SearchTree.entryList();

	}

	public void put (K key, V value){

		SearchTree.insert(key, value);

	}

	public int size(){

		return SearchTree.size();

	}

	public void clear(){

		SearchTree.clear();

	}

	public int getGetLoopCount(){

		return SearchTree.getFindLoopCount();

	}

	public int getPutLoopCount(){

		return SearchTree.getInsertLoopCount();

	}

	public void resetGetLoops(){

		SearchTree.resetFindLoops();

	}

	public void resetPutLoops(){

		SearchTree.resetInsertLoops();

	}
}
