package Project;
import java.io.File;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class userLogin {
	HashMap<String, String> userCred = new HashMap<String, String>();
		String temp;
		public boolean createUser(String email, String password) {
			
			
			if(userCred.containsKey(email) == true) {
				System.out.println("Email is already registered!");
				return false;
			}
			else if(email.contains(" ")) {
				//No spaces also because of save and load function
				System.out.println("Email CANNOT contain spaces!");
				return false;
			}
			else if(email.contains("@") != true || email.contains(".com") != true) {
				//Must contain "@" and ".com"
				System.out.println("Email must contain a domain: " + "email" + "@" + "examplemail" + ".com");
				return false;
			}
			else if(email.contains("]") || email.contains(",") || email.contains("=") || email.contains("[")) {
				//can not use special character because of save and load functions  CANNOT contain these special characters ] , = [
				System.out.println("Email CANNOT contain these special characters ] , = [ ");
				return false;
			}
			temp = email.substring(0, email.indexOf("@"));
			
			
			if(temp.length() < 2) {
				//@esss.com
				//no user name for email
				//username must greater than 1 n@esss.com does not work but na@esss.com does
				System.out.println("Email must contain a username: " + "email" + "@" + "examplemail" + ".com");
				return false;
			}
			temp = email.substring(email.indexOf("@"));
			
			
			if(temp.length() < 6) {
				//12345@.com 
				//there is no domain name
				System.out.println("Email must contain a domain: " + "email" + "@" + "examplemail" + ".com");
				return false;
			}
			
			if(password.length() < 5) {
				//pass must cotain more than 4 letters
				System.out.println("Password must contain more than 4 letters!");
				return false;
			}
			else if(password.contains(" ")) {
				//No spaces in password
				System.out.println("Password CANNOT contain spaces!");
				return false;
			}
			else if(password.contains("]") || password.contains(",") || password.contains("=") || password.contains("[")) {
				//can not use special character because of save and load functions  CANNOT contain these special characters ] , = [
				System.out.println("Password CANNOT contain these special characters ] , = [ ");
				return false;
			}
			else {
				userCred.put(email,password);
				saveUser();
				System.out.println("Successfully Logged in!");
				
				return true;
			}
			
			
			
		}
		
		public void clearHashMap() {
			
			PrintWriter pw = null;
			File file = new File("userCred.data");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				pw = new PrintWriter(fos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			pw.println();
	
		
			pw.close();
		}
		
		
		public void loadHashMap() {
			Scanner fileInput = null;
			try {
				fileInput = new Scanner(new File("userCred.data"));
				
				while(fileInput.hasNextLine()) {
					
					String searchFile = fileInput.nextLine();
				//	System.out.println(searchFile);
		
					
					String email = ""; 
					String pass = "";
					int flip = 1;
					for(int i = 0; i < searchFile.length(); i++) {
						//Search through searchFile by character if it is a email then switch to password and vice versa
					
						char c = searchFile.charAt(i);
						
						if(c == 61) {
							// if character equal "="
						//	System.out.println("Email= " +  email);
							flip ++;
						}else if(c == 44 || c == 93) {
							// if character equal "," or "]"
						//	System.out.println("Pass= " + pass);
							userCred.put(email, pass);
							email = "";
							pass = "";
							flip ++;
						}
						
				if(c != 91 && c != 61 && c != 32 && c != 44 && c != 93) {
					// character cannot equal "[" or "=" or " " or "," or "]"
			
						if(flip % 2 == 1) {
							email = email + c;
						}else {
							pass = pass + c;
						}
							
							
						
				}
						
						
					}
					

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		
		public void saveUser() {
			PrintWriter pw = null;
			File file = new File("userCred.data");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				pw = new PrintWriter(fos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			pw.println(userCred.entrySet());
		//	pw.println();
	// To delete saved data
		
			pw.close();
		}
		
		
		
		
		
		
		public boolean signUser(String email, String password) {
			
			if(userCred.containsKey(email) == true) {
				if(userCred.get(email).equals(password)) {
					System.out.println("Successfully Logged in!");
					return true;
				}else {
					System.out.println("Password is incorrect");
					return false;
				}
			}
			else {
				System.out.println("Email is not registered!");
				return false;
			}
			
		}
		
		
	
}
