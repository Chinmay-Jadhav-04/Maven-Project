package MavenApplication.Project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws SQLException {
		System.out.println( "Hello World!" );
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "root");
	

		   Statement st=conn.createStatement();
		   String sql="select * from employee";
		   ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   try {
			while(rs.next()) {
				   int empid=rs.getInt("empid");
				   String empname=rs.getString("empname");
				   String address=rs.getString("address");
				   int empphone=rs.getInt("empphone");
				   
				   System.out.println(empid+" "+empname+" "+address+" "+empphone);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (ClassNotFoundException e) {
			                                     
			e.printStackTrace();
		}

	}

}
