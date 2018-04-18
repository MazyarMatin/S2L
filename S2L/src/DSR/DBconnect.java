package DSR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class DBconnect {

	// Beachte aktuelle Klasse DBConnect
	// Aufgrund von Neuentwicklungen hier nicht mehr Verf�gbar.
	
	public static Connection getDBCon(String user, String passwd) {
		String url = "jdbc:postgresql://localhost:5432/qis";
		try {
			return DriverManager.getConnection(url, user, passwd);
		} catch (SQLException sqlexception) {   
			System.err.println("Methode getDBCon SQL-Fehler: "
					+ sqlexception.getMessage());
			return null;
		}
	}
	

	
	public static void main(String[] args)  {
			
		String user = "postgres";
		String password = "1245";
		Connection con = getDBCon(user, password);
		
		      try {
		      //   Class.forName("org.postgresql.Driver");  uebrig gebliben, schauen ob das sein muss
		         		     
		   
		    	//lesen der Inhalte
		    	 loeschen(con);
		    	  //testAusgabe(con);
		    	//  testEingabe(con);
		         
		     
		    con.close();  
		     
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		      System.out.println("Verbindung erfolgreich");
	      
                      
	}
	
	
	
	// # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
	
	//lesen der Inhalte
	public static void testAusgabe(Connection con) throws SQLException {

		String anfrage ="select veranstid, dtxt from veranstaltung where oid >= 318850";
    	ResultSet rs =null;
     	Statement stmt =null;
    	stmt =con.createStatement();
       	rs = stmt.executeQuery(anfrage);
    	
    	while(rs.next()){
    		System.out.println("--:" +rs.getInt("veranstid") + " --: " +rs.getString("dtxt"));  //bez der tabellen
         
    	};
         
         
    	rs.close();
    	stmt.close();
                  
      
		
	}
	
	
	
	// # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
	
	
	
	//Inhalte Einfuegen
		public static void testEingabe(Connection con) throws SQLException {

			
		//	int oid = 318872;   OID wird automatisch vergeben
			// timestamp vergeben, zb get Date etc
			int veranstid = 1;
			String verart = "";
			int verartid =0;
			String aikz = "A";
			String veranstnr = "5 WI und so";
			int veranstnrint = 1;
			String ktxt = "neu";
			String dtxt = "Mathe";

			
			//
			PreparedStatement pstmt = null;

			try {
				con.setAutoCommit(false);

				String stmt = "insert into veranstaltung values(?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(stmt);

			//	pstmt.setInt(1, oid);
				pstmt.setInt(1, veranstid);
				pstmt.setString(2, verart);
				pstmt.setInt(3, verartid);
				pstmt.setString(4, aikz);
				pstmt.setString(5, veranstnr);
				pstmt.setInt(6, veranstnrint);
				pstmt.setString(7, ktxt);
				pstmt.setString(8, dtxt);
		
				pstmt.execute();
				pstmt.close();
				con.commit();

				
							
			} catch (SQLException sql) {
				System.err.println("Fehler 1: ");
				while (sql != null) {
					System.out.println("SQLState: " + sql.getSQLState());
					System.out.println("Message: " + sql.getMessage());
					System.out.println("SQLCode: " + sql.getErrorCode());
					sql = sql.getNextException();
				}
				try {
					con.rollback();
				} catch (SQLException sql2) {
					System.err.println("Fehler 2: ");
					while (sql != null) {
						System.out.println("SQLState: " + sql.getSQLState());
						System.out.println("Message: " + sql.getMessage());
						System.out.println("SQLCode: " + sql.getErrorCode());
						sql = sql.getNextException();
					}
				}
			}
	       	
			System.out.println("Successfully");
	                  
	 
			
		}
	
	// # # # # # # # # # # # # # # 	
		//loeschen der Inhalte
		public static void loeschen(Connection con) throws SQLException {
			try {
			Statement stmt = null;
			 con.setAutoCommit(false);
	         
	         stmt = con.createStatement();
	         String sql = "DELETE from veranstaltung where veranstid = 1;";  // zum loeschen von testdaten
	         stmt.executeUpdate(sql);
	         con.commit();
	         
	         
	    
	    	stmt.close();
			} catch (SQLException sql) {
				System.err.println("Fehler 1: ");
				while (sql != null) {
					System.out.println("SQLState: " + sql.getSQLState());
					System.out.println("Message: " + sql.getMessage());
					System.out.println("SQLCode: " + sql.getErrorCode());
					sql = sql.getNextException();
				}
				try {
					con.rollback();
				} catch (SQLException sql2) {
					System.err.println("Fehler 2: ");
					while (sql != null) {
						System.out.println("SQLState: " + sql.getSQLState());
						System.out.println("Message: " + sql.getMessage());
						System.out.println("SQLCode: " + sql.getErrorCode());
						sql = sql.getNextException();
					}
				}       
	     
			
		}
		
		}	
		
		// # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
		
		

}
