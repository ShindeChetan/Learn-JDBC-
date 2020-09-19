//Step 1
import java.sql.*;

/*
 * Follow the 7 steps for jdbc connection
 * 1.import the package-->java.sql.*
 * 2.load & register the driver-->com.mysql.jdbc.Driver
 * 3.establish the connection-->create object of Connection(interface)
 * 4.create a statement
 * 5.execute the query
 * 6.processing of result
 * 7.close the connection
 */
public class JdbcDemoClass
{
	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/jdbc";
		String uname="root";
		String psw="Password";
		int id=4;
		String name="Bouncer";
		String query="insert into pract values(?,?)";
		
		//Step 2
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step 3
		Connection con=DriverManager.getConnection(url,uname,psw);
		
		//Step 4
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, id);
		st.setString(2, name);
		//Step 5
		int count= st.executeUpdate();
		
		//Step 6
		System.out.println(count +"row/s affected");
		
		
		//Step 7
		st.close();
		con.close();
	}

}
