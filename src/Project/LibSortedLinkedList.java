package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class LibSortedLinkedList<T extends Comparable<? super T>>implements Serializable{

	private Node<T> head;
	private Node<T> tail;
	private boolean reversed = false;
	private int size;
	Node<T> temp;
	
	
	public void createFile(String title, String text) {
		Formatter x = null;
		
		try {	
			x = new Formatter(title + ".txt");
			x.format(text);
		} catch (FileNotFoundException e) {
			System.out.println("Not a catch");
		}
		
		System.out.println("Items saved");
		x.close();
	}
	
	public void readFile(int userIndex, String userEmail){
		String title = null;
		
		userIndex--;
		if (size == 0) {
			System.out.print("The Library is Empty");
			return;
			//checks if your libs empty
		}
		else if (userIndex < 0 || userIndex > size - 1) {
		System.out.println("Index must be between 1 and " + (size));
		return;
		}
		
		temp = head.next;
		for (int i = 0; i < userIndex; i++) {
			temp = temp.next;
		}
		if(temp.availability == false && temp.email.equals(userEmail)) {
			title = temp.title;
		}
		
		try {
			//Scanner scan = new Scanner(new File(""));
		//Scanner file;
		//file = new Scanner(new File("Untitled 1"));
		
		//File file = new File("/Users/ntodd4/Desktop/CSC Library/captmidn.txt");
		   File file = new File(title + ".txt");
		
			Scanner scan = new Scanner (file);
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Book not found!");
		
		}
	}
	public int getSize() {
		return size;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	

	//public String toString(){
	public void readLib(String userEmail) {
	//	System.out.println("--------------------------------------");
		//System.out.println("[BOOKS]");
		if(head == null) {
			System.out.println("The Library is Empty");
			return;
		}
		
		temp = head.next;
		/*
		StringBuilder sb = new StringBuilder();
		Node<T> temp = head.next;
		
		sb.append("[ ");
		if(temp != null){
		while(temp != tail.prev){
	if(temp == null) {
		return "The List is Empty";
		
	}
			sb.append(temp.title);
			sb.append(", ");
			temp = temp.next;
	}
		sb.append(temp.title);
	}
		sb.append(" ]");
		return sb.toString();
		*/
	
		for (int i = 0; i < size; i++) {
			if (userEmail == null) {
				
			System.out.println("\n"+"Title: " + temp.title + "\n"+"Author: "+ temp.author
					 + "\n"+"Availabilty: "+ temp.availability + "\n"+"Index: " + (i + 1));
			}
			else if(userEmail.equals(temp.email) && temp.availability == false) {
				//book must have email and not be available to be in library
				System.out.println("\n"+"Title: " + temp.title + "\n"+"Author: "+ temp.author
						 + "\n"+"Date due: "+ temp.date.getTime() + "\n"+"Owner: "+ temp.email
						 + "\n"+"Availabilty: "+ temp.availability + "\n"+"Index: " + (i + 1));
			}
			temp = temp.next;
		}
		//return null;
	}
	
	

	public void add(String title, String author, String email, boolean availabilty) {
		Calendar date = updateCalendar(1);
		Node<T> newNode = new Node<T>(title, author, date, email, availabilty);
		if(size == 0) {
			head = new Node<T>(null, null, null, null, false);
			tail = new Node<T>(null, null, null, null, false);
			head.next = tail;
			tail.prev = head;
		}
		if(size == 0) {
			
			newNode.next = tail;
			newNode.prev = head;
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
			size += 1;
			return;
		}
		
		temp = head.next;
		if(reversed == false) {
		for(int i = 0; i < size; i++) {
			
			if(new Node<T>(title, author, date, email, availabilty).title.compareTo(temp.title) < 0
					|| new Node<T>(title, author, date, email, availabilty).title.compareTo(temp.title) == 0 ) {
			
				newNode.next = temp;
				newNode.prev = temp.prev;
				newNode.next.prev = newNode;
				newNode.prev.next = newNode;
				size += 1;
				break;
		}
		
			if(i == size - 1) {
				newNode.prev = temp;
				newNode.next = temp.next;
				newNode.next.prev = newNode;
				newNode.prev.next = newNode;
				size += 1;
				break;
		}
			temp = temp.next;
		}}
		
		if(reversed == true) {
			for(int i = 0; i < size; i++) {
			
				if(new Node<T>(title, author, date, email, availabilty).title.compareTo(temp.title) > 0
						|| new Node<T>(title, author, date, email, availabilty).title.compareTo(temp.title) == 0 ) {
					
					newNode.next = temp;
					newNode.prev = temp.prev;
					newNode.next.prev = newNode;
					newNode.prev.next = newNode;
					size += 1;
					break;
			}
			
				if(i == size - 1) {
					System.out.println(temp.title);
					System.out.println(newNode.title);
					newNode.prev = temp;
					newNode.next = temp.next;
					newNode.next.prev = newNode;
					newNode.prev.next = newNode;
					size += 1;
					break;
			}
				temp = temp.next;
			}
		}
			
		}
	
	public int searchLib(String searchTitle,  String searchAuthor, boolean searchAvailability, int searchIndex) {
		// takes in data and int
		if (size == 0) {
			System.out.print("The Library is Empty");
			return -1;
			//LIST Cannot be -1, So when it returns -1 that means false(Book not found) I did this so I could return a int to removeFromIdex
			//checks if libs empty
		}
		
			temp = head.next;
			
			for (int i = 0; i < size; i++) {
				if (searchTitle.equals(temp.title) || searchAuthor.equals(temp.author) || searchIndex == i + 1) {
					
					System.out.print("\n"+"Title: " + temp.title + "\n"+"Author: "+ temp.author
					
					 + "\n"+"Availabilty: "+ temp.availability + "\n"+"Index: " + (i + 1));
					
					return i;
				}
				temp = temp.next;
				
			}
			
			System.out.println("Book not found!");
			return -1;
		
	}
	
	public int bookCap(String userEmail) {
		Test.bookCap = 0;
		if (size == 0) {
			return 0;
			//Return 0 to show you own 0 books.
			//checks if libs empty
		}
		temp = head.next;
		
		for (int i = 0; i < size; i++) {
			if(userEmail.equals(temp.getEmail()) && temp.availability == false) {
				Test.bookCap++;
			}
			
			temp = temp.next;
		}

		
		return 0;
		
	}
	
	
	
	// [No Revision]
	public void removeFromIndex(int location) {
		
		
		if (size == 0) {
			//throw new NoSuchElementException("The list is empty");
			System.out.println("The Library is Empty");
			return;
		}
		else if (location < 0 || location > size - 1) {
			//throw new IndexOutOfBoundsException("Index must be between 1 and " + (size));
			System.out.println("Index must be between 1 and " + (size));
			return;
		}
		
		
		Node<T> temp = head.next;
		
		for (int i = 0; i < location; i++) {
			temp = temp.next;
		}
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		size -= 1;
	}
	
	public void rentBook(String userEmail, int userIndex, boolean userAvailability) {
		if (size == 0) {
			System.out.print("The Library is Empty");
			return;
			//checks if your libs empty
		}else if (userIndex < 0 || userIndex > size - 1) {
			//throw new IndexOutOfBoundsException("Index must be between 1 and " + (size));
			System.out.println("Index must be between 1 and " + (size));
			return;
		}
		temp = head.next;
		for (int i = 0; i < userIndex; i++) {
			temp = temp.next;
		}
		if(temp.availability == true) {
		temp.setEmail(userEmail);
		temp.setAvailability(userAvailability);
		Test.bookCap++;
		
		countDown task1 = new countDown();
		Timer timer = new Timer(temp.title);
		
			temp.setDate(updateCalendar(0));
			timer.schedule(task1, 30000);
			
			System.out.println("Book is rented!");
			//When ever a book is rented it counts down timer 15 seconds to return book
		}
		else {
			System.out.print("The book is not currently available");
		}
	}
	

	
	public void returnBook(int userIndex, String userEmail) {
		userIndex--;
		if (size == 0) {
			System.out.print("The Library is Empty");
			return;
			//checks if your libs empty
		}else if (userIndex < 0 || userIndex > size - 1) {
			//throw new IndexOutOfBoundsException("Index must be between 1 and " + (size));
			System.out.println("Index must be between 1 and " + (size));
			return;
		}
		
		temp = head.next;
		for (int i = 0; i < userIndex; i++) {
			temp = temp.next;
		}
		
		if(temp.email.equals(userEmail) && temp.availability == false) {
		Test.bookCap--;
		temp.setDate(updateCalendar(1));
		temp.setAvailability(true);
		System.out.println("Book returned");
		}else {
		System.out.println("Book not found");
		}
	}
	
	
	/*
	public void checkBook(String userTitle, String userEmail) {
		temp = head.next;
		
		for (int i = 0; i < size; i++) {
			if (userTitle.equals(temp.title)) {
				
				
				
			}
			temp = temp.next;

		}
	}
		

	public void removeFromIndex(int location) {
		Node<T> temp = head.next;
		location -= 1;

		if (location < 0 || location > size - 1) {
			throw new IndexOutOfBoundsException("Index must be between 1 and " + (size));
		}
		if (size == 0) {
			throw new NoSuchElementException("The list is empty");
		}

		for (int i = 0; i < location; i++) {
			temp = temp.next;
		}
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		size -= 1;
	}
/*
	public void removeAll(T title) {

		if (size == 0) {
			throw new NoSuchElementException("The list is empty");
			// if list is empty say it
		} else {
			Node<T> temp = head.next;
			
			for (int i = 0; i < size; i++) {
				if(new Node<T>(title).title.compareTo(temp.title) == 0) {
					temp.next.prev = temp.prev;
					temp.prev.next = temp.next;
					size -= 1;
				}
				temp = temp.next;
			}
		}
	}

	public void get(int location) {

		Node<T> temp = head.next;

		if (location < 0 || location > size - 1) {
			throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
		}
		for (int i = 0; i < location; i++) {
			temp = temp.next;
			// travel through list as many time as user wants
		}
		System.out.println(temp.title);
		// read the title that is at the point the user wanted
	}

	public boolean reverse() {
		if(size > 1) {
		Node<T> headTemp = head.next;
		Node<T> tailTemp = tail.prev;
		Node<T> temptitle = new Node<T>(null);
		for(int i = 0; i < size / 2; i++) {
			
			temptitle.title = headTemp.title;
			headTemp.title = tailTemp.title;
			tailTemp.title = temptitle.title;
			
			headTemp = headTemp.next;
			tailTemp = tailTemp.prev;
		}}
		
		if (reversed == false) {
			return reversed = true;
		} else {
			return reversed = false;
		}
		
	}

	public boolean contains(T title) {

		if (size == 0) {
			return false;
		} else {
			Node<T> temp = head.next;

			for (int i = 0; i < size; i++) {
				if (new Node<T>(title).title.compareTo(temp.title) == 0) {
					
					return true;
				}
				temp = temp.next;

			}
		}
		return false;
		
	}
*/
	public Calendar updateCalendar(int i) {
		Calendar userDate = Calendar.getInstance();
		if(i == 0) {
		userDate.add(Calendar.MILLISECOND, 1500);
		}
		return userDate;
	}
	
	class countDown extends TimerTask{
		Node<T> saveData = temp;
		@Override
		public void run() {
			
			if(saveData.getAvailability() == false) {
				//Get the availability
				//If false then you have book, and can return book automatic
				
			saveData.setAvailability(true);
			Test.bookCap--;
			System.out.println("\n" + saveData.getTitle() + " supscription has ended!");
			}
			return;
			
		}
		
	}

	private class Node<E> {
		String title, author, email;
		Calendar date;
		boolean availability;
		Node<E> next;
		Node<E> prev;

		private Node(String title, String author, Calendar date, String email, boolean availability) {
			this.title = title;
			this.author = author;
			this.date = date;
			this.email = email;
			this.availability = availability;
		}
		
	private String setTitle() {
		return this.title;
	}
	private String getTitle() {
		return title;
	}
	private boolean getAvailability() {
		return availability;
	}
	private boolean setAvailability(boolean userAvailability) {
		return this.availability = userAvailability;
	}
	private Calendar setDate(Calendar userDate) {
		return this.date = userDate;
	}
	private String getEmail() {
		return email;
	}
	private String setEmail(String userEmail) {
		return this.email = userEmail;
	}
		
	}
	
	

}
