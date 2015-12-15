/**
 * @author Pfister
 *
 */

package ch.bfh.btx8081.w2015.green.doctorGreen.controller;

import java.io.IOException;
import java.util.Iterator;
import java.sql.*;

/**
 * Class Used to Authenticate User during Login procedure
 */

public class LogAuthorDB {
	public String AuthorResult = null;
	private Object MyLog;
	private Object MyPassw;
	public static final String DATABASE = "I2r2014";
	

	public LogAuthorDB() {

	}

	// Check whether the Input of the User is valid or different from the
	// authentication sheet
	public void CheckAcces(String MyLog, String MyPassw) {

		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		String lastName = "";
		String firstName = "";
		this.MyLog =  MyLog;
		MyLog =  "'"+MyLog+"'";
		this.MyPassw =  MyPassw;
		MyPassw =  "'"+MyPassw+"'";

		try {
			// load the driver
			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			// connecting to the db sever
			/*
			 * Zugriff auf BFH SQL-Datenbank-Server mit Public Username/
			 * Passwort, sobald die eigene SQL-Tabelle auf dem BFH Server bereit
			 * ist, werden entsprechende Parameter angepasst
			 */
			con = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://corpus.bfh.ch:55783;DatabaseName="
							+ DATABASE, "scott", "tiger");

			System.out.println("Connection to MS SQL DB successful!:");

			// creating statement object
			statement = con.createStatement();

			// executing the query
			// Zugriff auf BFH Daten
			rs = statement.executeQuery
			// Parameter Name und FirstName werden später
			// entsprechend angepasst, PatientNb ist hier überflüssig, warte aber 
					//noch mit anpassen bis Datenbank fix ist
					("SELECT PatientNb, Name, FirstName " + " FROM " + DATABASE
							+ ".dbo.Patient "
							//+ "where Name ='Abati' and Firstname ='Jan'");
			+ "where Name ="+MyLog +"and Firstname ="+MyPassw); 
			MyLog =  MyLog.replace("'",""); //Der User dürfte beim Loggin somit kein "'" verwenden
			MyPassw =  MyPassw.replace("'",""); //Der User dürfte beim Loggin somit kein "'" verwenden
			
			System.out.println("PatientNb\tName, Firstname");
			System.out.println("---------\t---------------");
			int i = 0;

			// displaying the result set, one tuple per line
			while (rs.next())
				if (i < 1) {
					System.out.println(String.format("%d\t%d\t%s, %s", i++,
							rs.getInt(1), rs.getString(2), rs.getString(3)));
					lastName = rs.getString("Name");
					System.out.println(lastName);
					firstName = rs.getString("FirstName");
					System.out.println(firstName);
				}

			// hier könnte man auf leere Abfrage prüfen(wäre einfacher),
			// warte noch mit anpassen, bis DB fix steht
			if ((lastName.compareTo(MyLog) == 0)
					&& (firstName.compareTo(MyPassw) == 0)) {
				AuthorResult = "true";
				System.out.println("Erfolgreiches Login");
				System.out.println("Dies wird aus der DB ausgelesen: " + lastName);
				System.out.println("Dies wird aus der Tastatur ausgelesen: " + MyLog);
				System.out.println("Dies wird aus der DB ausgelesen: " + firstName);
				System.out.println("Dies wird aus der Tastatur ausgelesen: " + MyPassw);
			}

			else {
				AuthorResult = "false";
				System.out.println("Login fehlgeschlagen");
				System.out.println("Dies wird aus der DB ausgelesen: " + lastName);
				System.out.println("Dies wird aus der Tastatur ausgelesen: " + MyLog);
				System.out.println("Dies wird aus der DB ausgelesen: " + firstName);
				System.out.println("Dies wird aus der Tastatur ausgelesen: " + MyPassw);

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

	public String getResult() {
		return AuthorResult;
	}

}
