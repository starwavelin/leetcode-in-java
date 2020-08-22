package hash;

import java.util.Scanner;

public class LinearProbing {
	
	public static void main(String[] args) {
		Item item;
		int aKey, size, n, keysPerCell;	
			// size is the initial array size
			// n is the initial number of items in the array n < size
		
		System.out.println("*** Welcome to @codingbro's HashTable Linear Probing Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the hash table: ");
		size = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the initial number of items: ");
		n = Integer.parseInt(sc.nextLine());
		
		keysPerCell = 10;
		
		HashTable ht = new HashTable(size);
		
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			item = new Item(aKey);
			ht.insert(item);
		}
		
		// press x to exit 
		while (true) {
			System.out.print("Enter the first letter of show, insert, delete or find, \nPress x to exit: ");
			char selection = sc.nextLine().charAt(0);
			switch (selection) {
			case 's':
				ht.displayHashTable();
				break;
			case 'i':
				System.out.print("Enter a value to insert: ");
				aKey = Integer.parseInt(sc.nextLine());
				item = new Item(aKey);
				ht.insert(item);
				break;
			case 'd':
				System.out.print("Enter a value to delete: ");
				aKey = Integer.parseInt(sc.nextLine());
				Item keyToDelete = ht.delete(aKey); 
				if (keyToDelete == null){
					System.out.print("How can we delete sth not exist??\n");
				} else {
					System.out.print("Item " + keyToDelete.getKey() + " is deleted.\n");
				}
				break;
			case 'f':
				System.out.print("Enter a value to delete: ");
				aKey = Integer.parseInt(sc.nextLine());
				Item keyToFind = ht.find(aKey); 
				if (keyToFind == null){
					System.out.print("Item " + keyToFind.getKey() + " doesn't exist.\n");
				} else {
					System.out.print("Item " + keyToFind.getKey() + " is found.\n");
				}
				break;
			case 'x':
				System.out.println("Exist the program.");
				System.exit(0);
			default:
				System.out.println("Invalid Input! Please read the instruction carefully. ");
			}
		}
		
	}
	
}
