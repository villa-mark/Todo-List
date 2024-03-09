package todo.project.user;

public class UserController{
	/*
	 * Check The User File if the Following Parameters Exist
	 * @Params userPassword -> the user inputed password
	 * @Params userName     -> the user inputed username
	 * return true if the following exist else false
	*/
		public static boolean accountCheck(String userPassword, String userName) {
			return User.isExist(userPassword, userName);
		}
	
	/*
	 * Add the user inputed data into the User file
	 * @Params userPassword -> the user inputed password
	 * @Params userName     -> the user inputed username
	*/
		public static void addDataIntoFile(String firstName, String lastName, String userPassword, String userName) {
			User.addData(User.getID(), firstName, lastName, userPassword, userName);
		}
	
	// return the ID number
		
		public static int getID() {
			return User.getID();
		}
		
	//return the user full name
		
		public static String getFullName(String password, String username) {
			return User.getFullName(password, username);
		}
}