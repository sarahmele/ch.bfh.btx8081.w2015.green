/**
 * @author Pfister
 *
 */

package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class Used to Authenticate User during Login procedure
 */

public class LogAuthorDB {
	public String AuthorResult = null;
	private Object MyLog;
	private Object MyPassw;
	public static final String DATABASE = "SWE_2015_1"; // Access to our
														// SQL-Database-projekt

	public LogAuthorDB() {

	}

	// Check whether the Input of the User is valid or different from the
	// authentication sheet
	public void CheckAcces(String MyLog, String MyPassw) {

		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		String username = "";
		String passwort = "";

		this.MyLog = MyLog;
		int hashCodeMyLog = MyLog.hashCode();
		MyLog = Integer.toString(hashCodeMyLog);
		MyLog = "'" + MyLog + "'";

		this.MyPassw = MyPassw;
		int hashCodeMyPassw = MyPassw.hashCode();
		MyPassw = Integer.toString(hashCodeMyPassw);
		MyPassw = "'" + MyPassw + "'";

		try {
			// load the driver
			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			// connecting to the BFH db sever
			con = DriverManager.getConnection(

			"jdbc:jtds:sqlserver://corpus.bfh.ch:55783;DatabaseName="
					+ DATABASE, "SWE_2015_1", "swe2015");

			System.out.println("Connection to MS SQL DB successful!:");

			// creating statement object
			statement = con.createStatement();

			// executing the query, access to BFH-Database
			rs = statement.executeQuery
			

					// valid Logindata: "where Username ='Jan' and
					// Passwort ='wert12'");

					("SELECT PASSWORD, USERNAME " + " FROM " + DATABASE
							+ ".dbo.PERSON " + "where PASSWORD =" + MyPassw
							+ "and USERNAME =" + MyLog);

			MyPassw = MyPassw.replace("'", "");
			MyLog = MyLog.replace("'", "");

			// prepared for search function with int datatype
			// System.out.println("PatientNb\tUsername, Passwort");

			/*just for Presentation reason active:
			System.out.println("\tPASSWORD, \tUSERNAME,");
			System.out.println("\t---------\t---------------");
			*/
			int i = 0;
			

			// displaying the result set, one tuple per line
			while (rs.next())
				// (preparation for search function)
				if (i < 1) { // replace 1 with higher value in search function
								// to get more hits back

					/* (preparation code for search function, Data can be put 
					for example in a arrayList and be shown in a vaadin table view )
					System.out.println(String.format("%d\t%d\t%s, %s", i++,
					rs.getInt(1), rs.getString(2), rs.getString(3)));
					*/

					/*just for Presentation reason active:
					//System.out.println(String.format("%d\t%s, \t%s", i++,
							rs.getString(1), rs.getString(2)));
					*/		

					passwort = rs.getString("PASSWORD");
					//System.out.println(passwort);

					username = rs.getString("USERNAME");
					//System.out.println(username);

				}
			// Check whether the Input hash of the User is valid or different
			// from the db hash
			if (((username.compareTo(MyLog) == 0) && (passwort
					.compareTo(MyPassw) == 0))) {
				AuthorResult = "true";
				/*just for Presentation reason active:
				System.out.println("Erfolgreiches Login");
				System.out.println("Dies wird aus der DB ausgelesen: "
						+ username);
				System.out.println("Dies wird aus der Tastatur ausgelesen: "
						+ MyLog);
				System.out.println("Dies wird aus der DB ausgelesen: "
						+ passwort);
				System.out.println("Dies wird aus der Tastatur ausgelesen: "
						+ MyPassw);
				 */
			}

			else {
				AuthorResult = "false";
				/*just for Presentation reason active:
				System.out.println("Login fehlgeschlagen");
				System.out.println("Dies wird aus der DB ausgelesen: "
						+ username);
				System.out.println("Dies wird aus der Tastatur ausgelesen: "
						+ MyLog);
				System.out.println("Dies wird aus der DB ausgelesen: "
						+ passwort);
				System.out.println("Dies wird aus der Tastatur ausgelesen: "
						+ MyPassw);
				*/

			}
			// close result set and statement
			rs.close();
			statement.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) { /* ignore */
				}
		}
	}

	// gives "true" or "false" back on LoginView.java to get access to
	// HomeView.class

	public String getResult() {
		return AuthorResult;
	}

}
