import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class First_Static_Program {

	public static void main(String[] args) {
		
		//System.out.println("be happy , i am going to make project which will cover approximately all crud commands required in jdbc");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");        
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/college","admin","Root"); 
			//System.out.println("connection established");           //here student is schema ,first ,creating table
			// there is two type of execution of query first is having "select" command ,second doesn't have "select command in query
			// for select - used      -------------------------------------- executeQuery(), for other------------------------------------updateQuery()    ,
			
			// execute works in both
			// prepareStatement is used for query as below
			//-------------------------------------------------------------------------------------------------------------------
			//create
			
//			String creating="create table college.student(Id int not null,name varchar(45) not null,class varchar(45) null,primary key(Id))";
//			String creating="create table college.teacher(Id int not null,name varchar(45) not null,class varchar(45) null,primary key(Id,name))";
//			
//			PreparedStatement ps=con.prepareStatement(creating);
//			ps.execute();
			
			//-------------------------------------------------------------------------------------------------------------------
			
			//update--------------------insert
			//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//			String inserting="insert into college.student values(?,?,?)";
//			
//			
//			PreparedStatement ps=con.prepareStatement(inserting);
//			ps.setInt(1, 1);
//			ps.setString(2, "subash");
//			ps.setString(3, "8");
//			ps.execute();
//			for(int i=0;i<10;i++) {
//				ps.setInt(1, i+2);
//				ps.setString(2, "subash "+i);
//				ps.setString(3, ""+i+9);
//				ps.execute();
//			}
			
			//before update we have to know how to read so that we can get also which rows updated
			
//			String reading="select * from college.student";
//			PreparedStatement ps=con.prepareStatement(reading);
//			ResultSet rs=ps.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getShort(3));
//				
//			}
//			String reading="select * from college.student where name like 'su%4'"; ------------------it is working
//			String reading="select * from college.student where id=4";
//			PreparedStatement ps=con.prepareStatement(reading);
//			
//			ResultSet rs=ps.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getShort(3));
//				
//			}
			
			//update ,drop 
//			String updating="update college.student set name ='shivpujan' where id=2";
//			PreparedStatement ps=con.prepareStatement(updating);
//			
//			ps.executeUpdate();
//			String reading="select * from college.student where id=2";
//			PreparedStatement ps1=con.prepareStatement(reading);
//			
//			ResultSet rs=ps1.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" 			"+rs.getShort(3));
//				
//			}
			
			//--------------------------------------------------------------------------------------
			//delete table                  drop command
			String altering="drop table college.teacher";
			PreparedStatement ps=con.prepareStatement(altering);
			ps.executeUpdate();
			try {
				String reading="select * from college.teacher";
				PreparedStatement ps3=con.prepareStatement(reading);
				ResultSet rs=ps3.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getShort(3));
					
				}
				
			} catch (Exception e) {
				System.out.println("doesn't exist");
			}
			
			
			
			con.close();
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
