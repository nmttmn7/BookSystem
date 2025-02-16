package Project;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class Test {
	boolean login = false;
	Scanner input = new Scanner(System.in);
	//String email = null, password, title, author, date;
	String email , password, title, author, date, text;
	userLogin userLogin = new userLogin();
	LibSortedLinkedList <String> LibsSortedLinkedList = new LibSortedLinkedList<String>();
	int userChoice;
	Scanner fileInput = null;
	int bookMax = 5;
	static int bookCap = 0;
	int userIndex;
	static boolean readAllLib = true;
	 
	//See if you can bring new window for reading file
	public static void main(String[] args) {
		new Test();
	}
	public Test() {
	
		System.out.println("Welcome to our nice library.");
		System.out.println("Please note books have a 2 min expiration date!");
		System.out.println("Please select a number from the options below");
		
		//unitTesting();
		
		
		userLogin.loadHashMap();
		
//		userLogin.createUser("email@examplemail.com", "password");
//		userLogin.createUser("choochoo@trains.com", "trains678");
//		userLogin.createUser("sunnysplatoon123@waterworld.com", "YellowSubmarine");
//		userLogin.createUser("bestsellar@bestbooks.com", "ImTheBest");
//		userLogin.createUser("Caesar@apearmy.com", "banana");
		
	//	LibsSortedLinkedList.add("Name","author", "email@examplemail.com", true);
		
		LibsSortedLinkedList.add("Heart of Darkness","Joseph Conrad", "choochoo@trains.com", true);
		
		LibsSortedLinkedList.add("A Tale of Two Cities","Charles Dickens", "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("The Ugly Duckling","Hans Christian Andersen", "bestsellar@bestbooks.com", true);
		
		LibsSortedLinkedList.add("Metamorphosis","Franz Kafka","Caesar@apearmy.com", true);
		
		LibsSortedLinkedList.add("The Wonderful Wizard of Oz","Frank Baum",  "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("Nature","Ralph Waldo Emerson",  "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("Black Beauty","Anna Sewell",  "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("The Jungle Book","Rudyard Kipling",  "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("The Secret Garden","Frances Hodgson Burnett",  "sunnysplatoon123@waterworld.com", true);
		
		LibsSortedLinkedList.add("Leviathan","Thomas Hobbes",  "sunnysplatoon123@waterworld.com", true);
		
		login();
	
		
		
		
		
	/*	
		
		if(login == true) {
			System.out.println("\n" + "1: Home");
			System.out.println("2: Library.");
			System.out.println("3: My Library");
			System.out.println("4: Your library. (WIP)");
			System.out.println("5: Read date. (WIP)");
			System.out.println("9: Go back to registry.");
			System.out.println("0: Exit.");
			
			userChoice = input.nextInt();
			input.nextLine();
			switch (userChoice) {
			case 1:
		/*	System.out.print("\n" + "Title: ");
				title = input.nextLine();
				System.out.print("Author: ");
				author = input.nextLine();
				
				//I will change data to be an actual date, is placeholder
				
				LibsSortedLinkedList.add(title,author, userDate, null, true);
				//add attributes to node, no one own book when in lib, all books are available when but in library
				
				home();
				break;
				
			case 2:
				System.out.print("Data: ");
				title = input.nextLine();
				System.out.println("1: Search by Title " +
				"\n" + "2: Search by Author" + "\n" + "3: Search by Availability (W.I.P.)");
				int category = input.nextInt();
				int temp = LibsSortedLinkedList.searchLib(title, category);
				
				if(temp >= 0) {
					
				System.out.println("\n" + "1: Add to Your Personal Library (W.I.P.).");
				System.out.println("2: Delete Book.");
				System.out.println("0: Leave.");
				userChoice = input.nextInt();
				input.nextLine();
				switch (userChoice) {
				case 1:
				break;
				
				case 2:
					LibsSortedLinkedList.removeFromIndex(temp);
				break;
				
				case 0:
				break;
				}
				}
				break;
				
			case 3:
				LibsSortedLinkedList.readLib();
				break;
				
			case 4:
				LibsSortedLinkedList.yourLib(email);
				//W.I.P.
				break;
			case 5:
				
				//W.I.P.
				break;

			case 9:
				login = false;
				break;
				
			case 0:
				login = false;
				System.out.println("Thank you!");
				System.exit(0);
			
			}
			
			}
			 * 
				 */
		
		}
		
		
		
		
	
		
		
			
			
		//LibsSortedLinkedList.add("name","author", "date", "email", true);
		//LibsSortedLinkedList.add("afee","qfefw", "effd", "ffr", false);
		//LibsSortedLinkedList.searchLib("afee");
		
		
	
	
	private void unitTesting() {
		System.out.println("\n" + "Registration Testing");
		System.out.println("--------------------------------------");
		System.out.println("[Register user email/pass]");
		login = userLogin.createUser("wowLibrary@gmail.com", "Chickenwing");
		System.out.println("[Register SAME user email/pass]");
		login = userLogin.createUser("wowLibrary@gmail.com", "Chickenwing");
		System.out.println("[Login as new email]");
		login = userLogin.signUser("OOOOOOOOOGhost@gmail.com", "BongBing");
		System.out.println("[Login as known email, wrong password]");
		login = userLogin.signUser("wowLibrary@gmail.com", "AHHHHHH");
		System.out.println("[Login as known email, right password]");
		login = userLogin.signUser("wowLibrary@gmail.com", "Chickenwing");
		System.out.println("[Test Restrictions on Email] (WIP)");
		login = userLogin.signUser("1232233333333", "Chickenwing");
		System.out.println("[Test Restrictions on Email]");
		login = false;
		System.out.println("--------------------------------------");
		System.out.println("\n" + "Registration Testing Complete");
		//reset Login ^
		
		//CLEAR
		System.out.println( "\n" + "Library Storage Testing");
		System.out.println("--------------------------------------");
		System.out.println("[CLEAR LIB]" + "\n" + "Check Positive and Negative Values");
		LibsSortedLinkedList.clear();
		System.out.println("readLib()");
		LibsSortedLinkedList.readLib(null);
		LibsSortedLinkedList.readLib("Author");
		System.out.println("searchLib()");
		LibsSortedLinkedList.searchLib("Name", "Author", true, -10);
		LibsSortedLinkedList.searchLib("Name", "Author", true, 10);
		System.out.println("\n" + "bookCap()");
		LibsSortedLinkedList.bookCap("wowLibrary@gmail.com");
		System.out.println(bookCap);
		System.out.println("removeFromIndex()");
		LibsSortedLinkedList.removeFromIndex(-10);
		LibsSortedLinkedList.removeFromIndex(10);
		System.out.println("rentBook()");
		LibsSortedLinkedList.rentBook("Name", -10, false);
		LibsSortedLinkedList.rentBook("Name", 10, false);
		System.out.println("\n" + "returnBook()");
		LibsSortedLinkedList.returnBook(-1, email);
		LibsSortedLinkedList.returnBook(10, email);
		System.out.println( "\n" + "[CLEAR COMPLETE]");
		
		LibsSortedLinkedList.add("Name","Author", "Email", true);
		
		System.out.println( "\n" + "[ADD 1]");
		System.out.println("[CLEAR LIB]" + "\n" + "Check Positive and Negative Values");
		System.out.println("readLib()");
		LibsSortedLinkedList.readLib(null);
		LibsSortedLinkedList.readLib("Author");
		System.out.println("searchLib()");
		LibsSortedLinkedList.searchLib("Name", "Author", true, -43);
		LibsSortedLinkedList.searchLib("Name", "Author", true, 43);
		System.out.println("\n" + "bookCap()");
		LibsSortedLinkedList.bookCap("wowLibrary@gmail.com");
		System.out.println(bookCap);
		System.out.println("removeFromIndex()");
		LibsSortedLinkedList.removeFromIndex(-43);
		LibsSortedLinkedList.removeFromIndex(43);
		System.out.println("rentBook()");
		LibsSortedLinkedList.rentBook("Name", -43, false);
		LibsSortedLinkedList.rentBook("Name", 43, false);
		System.out.println("returnBook()");
		LibsSortedLinkedList.returnBook(-43, email);
		LibsSortedLinkedList.returnBook(43, email);
		System.out.println( "\n" + "[ADD COMPLETE]");
		
		System.out.println("--------------------------------------");
		System.out.println( "\n" + "Library Storage Testing Complete");
		
		System.out.println(" ");
		LibsSortedLinkedList.add("name","author",  "email", true);
		LibsSortedLinkedList.add("afee","qfefw", "ffr", false);
		
		
	}
	
	
	
	
	private void login() {
		while(login == false) {
			System.out.println("--------------------------------------");
			System.out.println("Login = " + login );
			System.out.println("1: Register as new user.");
			System.out.println("2: Login as user");
			System.out.println("0: Leave.");
			System.out.println("--------------------------------------");
			userChoice = input.nextInt();
			input.nextLine();
			
			switch (userChoice) {
			case 1:
				if(login == false) {
				System.out.print("(eg: email@examplemail.com)" +  "\n" +"Email: ");
				email = input.nextLine();
				System.out.print("Password: ");
				password = input.nextLine();
				login = userLogin.createUser(email, password);
				}
				else {
					System.out.println("\n" + "You are already logged in!");
				}
				break;
			case 2:
				if(login == false) {
				System.out.print( "(eg: email@examplemail.com)" +  "\n" + "Enter email: ");
				email = input.nextLine();
				System.out.print("Enter password: ");
				password = input.nextLine();
				login = userLogin.signUser(email, password);
				} 
				else {
					System.out.println("\n" + "You are already logged in!");
				}
				break;
			case 0:
				System.out.println("Thank you!");
				System.exit(0);
			}
			
			
		}
		
		LibsSortedLinkedList.bookCap(email);
		home();
	}
	
	
	private void home() {
		readAllLib = true;
		
		while(true) {
			System.out.println("--------------------------------------");
		System.out.println("Here is the Library " +"\n" + "and the description of it");
		
		System.out.println("1: Browse all books");
		System.out.println("2: My books");
		System.out.println("3: About the library");
		System.out.println("9: Logout");
		System.out.println("0: Leave.");
		System.out.println("--------------------------------------");
		userChoice = input.nextInt();
		input.nextLine();
		
		switch (userChoice) {
		
		case 1:
			if(login == true) {
				allLibrary();
				}
				else {
					System.out.println("\n" + "You need to be logged in to access the Library!");
				}
			break;
			
		case 2:
			if(login == true) {
				myLibrary();
				}
				else {
					System.out.println("\n" + "You need to be logged in to access the Library!");
				}
			break;
		case 3: 
			aboutLib();
			break;
		case 9:
			if(login == true) {
			login = false;
			System.out.println("Logged out!");
			login();
			//Go back to login method if(You are not loggined in)
			}
			else {
				System.out.println("\n" + "You are not logged in!");
			}
			break;
		case 0:
			System.out.println("Thank you!");
			System.exit(0);
		}
	}
	}
	
	
	private void allLibrary() {
		//Display Maxbooks here too
		while(true) {
			
			System.out.println("--------------------------------------");
			if(readAllLib == true) {
				LibsSortedLinkedList.readLib(null);
				
				System.out.println("\n" +"--------------------------------------");
				if(bookMax-bookCap == 5) {
					System.out.println("Books allowed to rent: " + (bookMax - bookCap));
				}else {
					System.out.println("Books left to rent: " + (bookMax - bookCap));
				}
			}
			
			readAllLib = false;
			
			
		System.out.println("--------------------------------------");	
		System.out.println("1: Search for a book");
		System.out.println("9: Home");
		System.out.println("--------------------------------------");
		//System.out.println("3: Add a book to library");
	
		userChoice = input.nextInt();
		input.nextLine();
		
		switch (userChoice) {
			
		case 1:
			if(bookCap < bookMax) {
				
			
			int userTemp = askDataTypeSearch();
			if (userTemp >= 0) {
				System.out.println("\n" + "--------------------------------------");
				System.out.println("1: Rent this book");
				System.out.println("2: Browse all books");
				System.out.println("3: Home");
				System.out.println("--------------------------------------");
				userChoice = input.nextInt();
				input.nextLine();
				
				switch (userChoice) {
				case 1: 
					LibsSortedLinkedList.rentBook(email, userTemp, false);
					break;
				case 2: 
					readAllLib = true;
					allLibrary();
					break;
				case 3: 
					home();
					break;
				

				}
			}
			}
			else {
				System.out.println("Your Library is Maxed, You cannot rent anymore books!");
			}
			
			break;
	/*		
		case 3:
			System.out.print("\n" + "Title: ");
			title = input.nextLine();
			System.out.print("Author: ");
			author = input.nextLine();
			System.out.print("\n" + "Text(WIP): ");
			text = input.nextLine();
			//I will change data to be an actual date, is placeholder
			
			LibsSortedLinkedList.add(title,author,  null, true);
			//LibsSortedLinkedList.createFile(title, text);
			//add attributes to node, no one own book when in lib, all books are available when put in library
			break;
			*/
		case 9:
			home();
			break;
		
			
		}
	}
	}
	
	
	
	
	
	//Make it to load All lib first cast of it
	
	private int askDataTypeSearch() {
		String userTitle = "", userAuthor = "";
		System.out.println("Select how you want to search through library");
		
		System.out.println("1: Title");
		System.out.println("2: Author");
		System.out.println("3: Index");
		System.out.println("--------------------------------------");
		userChoice = input.nextInt();
		input.nextLine();
		
		switch (userChoice) {
		
		case 1:
			System.out.print("\n" + "Title: ");
			userTitle = input.nextLine();
		    return LibsSortedLinkedList.searchLib(userTitle, userAuthor, true, userIndex);
			
			
		case 2:
			System.out.print("\n" + "Author: ");
			userAuthor = input.nextLine();
			return LibsSortedLinkedList.searchLib(userTitle, userAuthor, true, userIndex);
			
		case 3:
			System.out.print("\n" + "Index: ");
			userIndex = input.nextInt();
			return LibsSortedLinkedList.searchLib(userTitle, userAuthor, true, userIndex);
			
		case 7:
			home();
			break;
		case 8: 
			allLibrary();
			break;
		case 9: 
			myLibrary();
			break;
		
			
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void myLibrary(){
		readAllLib = true;
		while(true) {
			
			/*
			[FUNCTIONS]
			LibsSortedLinkedList.readLib(email);
			read library by user email- used to show all of user library
			---------------------------------------------
			
			*/
			
			
			
			int userIndex = 0;
			System.out.println("--------------------------------------");
			LibsSortedLinkedList.readLib(email);
			
			System.out.println("--------------------------------------");
			
			if(bookMax-bookCap == 5) {
				System.out.println("Books allowed to rent: " + (bookMax - bookCap));
			}else {
				System.out.println("Books left to rent: " + (bookMax - bookCap));
			}
			
			
			
			System.out.println("1: Read a book from my library");
			System.out.println("2: Return a book from my library");
			System.out.println("9: Home");
			
			
			System.out.println("--------------------------------------");
			userChoice = input.nextInt();
			input.nextLine();
			
			switch (userChoice) {
				
			case 1:
				System.out.print("\n" + "Search for your book index: ");
				userIndex = input.nextInt();
				LibsSortedLinkedList.readFile(userIndex, email);
				
				
				System.out.println("--------------------------------------");
				System.out.println("1: My books");
				System.out.println("2: Home");
				System.out.println("--------------------------------------");
				
				
				userChoice = input.nextInt();
				input.nextLine();
				
				switch (userChoice) {
				case 1:
					myLibrary();
					break;
				case 2:
					home();
					break;
				}
				break;
				
			case 2:
				System.out.print("\n" + "Search for your book index: ");
				userIndex = input.nextInt();
				LibsSortedLinkedList.returnBook(userIndex, email);
				
				System.out.println("--------------------------------------");
				System.out.println("1: My books");
				System.out.println("2: Home");
				System.out.println("--------------------------------------");
				
				
				userChoice = input.nextInt();
				input.nextLine();
				
				switch (userChoice) {
				case 1:
					myLibrary();
					break;
				case 2:
					home();
					break;
				}
				break;
			case 9:
				home();
				break;
						
			}
		}
	}
	private void aboutLib() {
		readAllLib = true;
		while(true) {
		System.out.println("--------------------------------------");
		System.out.println("Description: THE Library has nice books.");
		System.out.println("1: Home");
		System.out.println("--------------------------------------");
		userChoice = input.nextInt();
		input.nextLine();
		
		switch (userChoice) {
		
		case 1:
			home();
			break;
		}
		}
	}
	
	//public void updateTime(){
		//userDate = Calendar.getInstance();// Gets current date and saves it into userData
		//userDate.add(Calendar.DATE, 7);// Increases date by 7. This is when the book will be due
//	}

	
}


