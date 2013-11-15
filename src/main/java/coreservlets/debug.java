package coreservlets;

public class debug {
	
	private static String email = "rally@email.com";
	private static String password = "password";
	
	public static void debugPrint() {
		System.out.println(
				// This was solved.  Needed to add some space between the email column data and WHERE
				// Likewise, same for the AND clause.
				"SELECT * FROM accounts"
				+ " WHERE email = '" + email + "'"
				+ " AND password = '" + password + "';"
				
				);
	}
}
