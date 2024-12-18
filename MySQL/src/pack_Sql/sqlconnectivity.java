package pack_Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlconnectivity {
public static void main(String[] args) throws SQLException {
try {
	
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Registering Driver

} 

catch (ClassNotFoundException e) 
{
e.printStackTrace();
}

Connection conn = null;

//String dbURL = "jdbc:sqlserver://localhost:1433;databasename=Assign1_Obs;encrypt=false";
//String dburl = "jdbc:sqlserver://DESKTOP-61QF0TL\\SQLEXPRESS;databaseName=Assign1_Obs;integratedSecurity=true";

String dburl = "jdbc:sqlserver://DESKTOP-61QF0TL\\SQLEXPRESS;databaseName=Assign1_Obs;integratedSecurity=true;encrypt=false";

//String user = "";
//String pass = "";

conn = DriverManager.getConnection(dburl);//Establishing Connection

if (conn != null)
{
	
Statement st;
st = conn.createStatement();//Creating Statement
String query = "update Student_DetailsTB set name = 'Sanu' where name ='Asha Dileep'";
String query1 = "select * from Student_DetailsTB";

int res = st.executeUpdate(query);//Execute statement--when using update,insert commands.. output comes as integer(1)row affected.. so have to store in integer

if(res>0)
{
System.out.println("Updated");
}
else
{
System.out.println("update unsuccessful");
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