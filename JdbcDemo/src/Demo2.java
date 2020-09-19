import java.sql.*;

public class Demo2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		StudentDAO dao=new StudentDAO();
		//Student s1=dao.getStudent(3);
		Student s2=new Student();
		//System.out.println(s1.name);
		s2.id=6;
		s2.name="bhidu";
		
		dao.connect();
		dao.addStudent(s2);
	}

}

class StudentDAO
{
	Connection con=null;
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/student","root","Password");
		} catch (Exception ex)
		{
			System.out.println(ex);
		} 
	}
	
	public Student getStudent(int id)
	{
		try {
			String query="select name from student where rollno="+id;
			Student s=new Student();
			s.id=id;
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			String nam=rs.getString(1);
			s.name=nam;
			return s;
		} catch (Exception ex)
		{
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		return null;
	}
	
	public void addStudent(Student s)
	{
		try {
			String query="insert into student values (?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, s.id);
			pst.setString(2, s.name);
			pst.executeUpdate();
			
		} catch (Exception ex)
		{
			System.out.println(ex);
		}
	}
}

class Student
{
	int id;
	String name;
}
