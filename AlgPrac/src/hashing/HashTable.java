package hashing;

/**
 * Use Array to create a hashtable
 * @author Benjamin Lin
 * Modified from @author Lafore's book
 * Data Structure and Algorithm in Java
 */
public class HashTable {
	
	private Item[] hashArray;
	private int size;		// arraySize is the twice of the number of Items
	private Item nonItem;	// nonItem represents a deleted item
	
	public HashTable(int size) {
		this.size = size;
		hashArray = new Item[size];

		// we set the deleted item to have key -1
		nonItem = new Item(-1);
	}
	
	public void displayHashTable() {
		System.out.print("The HashTable is: ");
		for (int i = 0; i < size; i++) {
			if (hashArray[i] != null) {
				System.out.print(hashArray[i].getKey() + " ");
			} else {
				System.out.print("** ");		// ** means empty cell		 
			}			  
		}
		System.out.println();
	}
	
	/**
	 * Get the index of the hashed key
	 * @param hash the hash value of the key
	 * @return the index of the hashed key in the array
	 */
	public int hashFunction(int key) {
		int hashValue = key % size;  
			// This way to create a hash function is called Division Method,
			// we do have other methods, keep this in mind, especially when
			// you are in an interview
		return hashValue;
	} 
	
	/**
	 * Insert using linear probing
	 * @param item
	 */
	public void insert(Item item) {
		// Here we assume the array is never full
		
		int key = item.getKey();	// get key of the item
		int hashValue = hashFunction(key);  
		
		while (hashArray[hashValue] != null
				&& hashArray[hashValue].getKey() != -1) {	// this cell is occupied
			hashValue++;	// Linear Probing: try the next cell
			hashValue = hashValue % size; // wrap around if necessary
		}
		hashArray[hashValue] = item;
	}
	
	/**
	 * Delete the item based on the given key
	 * @param key the key of the item to be deleted
	 * @return the item to be deleted
	 */
	public Item delete(int key) {
		int hashValue = hashFunction(key);
		
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				Item tmp = hashArray[hashValue];	// save the item to be deleted
				hashArray[hashValue] = nonItem; 	// delete the item
				return tmp;
			}
			hashValue++;	// Linear Probing: try the next cell
			hashValue = hashValue % size;
		}
		
		return null; // didn't find the item
	}
	
	/**
	 * Search the item
	 * @param key key of the item to be found
	 * @return the item we found
	 */
	public Item find (int key) {
		int hashValue = hashFunction(key);
		
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) {
				return hashArray[hashValue];
			}
			hashValue++;	// Linear Probing: try the next cell
			hashValue = hashValue % size;
		}
		
		return null; // didn't find the item
	}
}
