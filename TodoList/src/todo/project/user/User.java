package todo.project.user;
import java.io.*;
import java.util.*;

class User{
	static File file = new File("User.dat");
	
	/* 
	 * Check if the following parameters exist in file
	 * @Params userPassword	-> the user inputed password
	 * @Params userName 	-> the user inputed username
	 * return true if it exist else false
	*/
		static boolean isExist(String userPassword, String userName) {
			try {
				file.createNewFile();
				try (Scanner scan = new Scanner(file)) {
					while(scan.hasNextLine()) {
						String data = scan.nextLine();
						String[] part = data.split(",',");
						if( part[3].equals(userPassword) && part[4].equals(userName)) {
							scan.close();
							return true;
						}
	 				}
					scan.close();
				}
			}catch(IOException e) {}
			return false;
		}
		
	/* Add the following parameters in User File
	 * @Params id			-> the system generated id
	 * @Params firstName 	-> the user first name
	 * @Params lastName		-> the user last name
	 * @Params userName		-> the user inputed user name
	 * @Params userPassword	-> the user inputed password
	*/
		static void addData(int id, String firstName, String lastName, String userPassword, String userName) {
			String delimeter = ",',";
			try {
				file.createNewFile();
				try (FileWriter writer = new FileWriter(file, true)) {
					writer.write( id + delimeter + firstName + delimeter + lastName + delimeter + userPassword + delimeter + userName + "\n" );
					writer.close();
				}
			}catch(IOException e) {}
		}
		
	// Count the data in the file and return the counted value
		
		static int getID() {
			int id = 0;
			try {
				file.createNewFile();
				try (Scanner scan = new Scanner(file)) {
					while(scan.hasNextLine()) {
						scan.nextLine();
						id++;
	 				}
					scan.close();
					return id;
				}
			}catch(IOException e) {}
			return 0;
		}
		
	// Return the full name of the user
		static String getFullName(String userPassword, String userName) {
			try {
				file.createNewFile();
				try (Scanner scan = new Scanner(file)) {
					while(scan.hasNextLine()) {
						String data = scan.nextLine();
						String[] part = data.split(",',");
						if( part[3].equals(userPassword) && part[4].equals(userName)) {
							scan.close();
							String concatenate = part[1] + " " + part[2];
							String[] partName = concatenate.split(" ");
							String name = "";
						
							for(String check : partName) {
								if(!check.isEmpty()) {
									char character = check.charAt(0);
									char upperChar = Character.toUpperCase(character);
									name = name + upperChar + check.substring(1) + " ";
								}
							}
							return name.substring(0, name.length()-1);
						}
	 				}
					scan.close();
				}
			}catch(IOException e) {}
			return "";
		}
}