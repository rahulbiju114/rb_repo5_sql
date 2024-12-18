package pack_Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql_1 {

	public static void main(String[] args) throws SQLException {
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found. Please include the JDBC driver in your project.");
			e.printStackTrace();
			return;
		}
		
		String dbURL = "jdbc:sqlserver://DESKTOP-61QF0TL\\SQLEXPRESS;databaseName=Assign1_Obs;integratedSecurity=true";

				try (Connection conn = DriverManager.getConnection(dbURL);
				Statement st = conn.createStatement())
				
				{
					
				
				// Update query
				String updateQuery = "Select * from department_table";
				int rowsAffected = st.executeUpdate(updateQuery);
			
				// Check if update was successful
				if (rowsAffected > 0) {
				System.out.println("Updated "+ rowsAffected);
				}
				
				else {
				System.out.println("Update unsuccessful.");
				}
				
				ResultSet rs = st.executeQuery(query1);//Execute statement gets data from the table
				while(rs.next()){
				int empid=rs.getInt(1);
				String name=rs.getString(2);
				String desig=rs.getString(3);
				System.out.println(empid + " " +name+ " "+desig);
				}
				}
				conn.close();
				}
				}

	}

}
