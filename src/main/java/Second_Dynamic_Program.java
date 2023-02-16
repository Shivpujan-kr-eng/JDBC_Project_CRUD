import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.colorchooser.ColorChooserComponentFactory;

public class Second_Dynamic_Program {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");        
			Connection con=DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/college","admin","Root");
			
			//create table
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter table name ,which you want to create");
			String creating="create table college.";
			String s=sc.nextLine();
			System.out.println("enter number of column you want");
			int n;
			while(true) {
				try{
				    n=sc.nextInt();
					
					break;
				}catch(Exception e) {
					sc.nextLine();
					System.out.println("enter only number");
					
					
				}
			}
			
			String v[]=new String[n];
			String c[]=new String[n];
			HashMap<Integer, String> hm=new HashMap<>();
			hm.put(1, "int");
			hm.put(2, "varchar(50)");
			int k=n;
			while(n!=0) {
				System.out.println("enter column name");
				v[n-1]=sc.next();
				sc.nextLine();
				
				
				while(true){
					System.out.println("choose data type, Enter 1 for integer ,enter 2 for character");
					int a;
					
					while(true) {
						try{
							a=sc.nextInt();
							
							break;
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("enter only number");
							
							
						}
					}
					
					if(a==1) {
					c[n-1]=hm.get(1);
					break;}
					else if(a==2) {
						c[n-1]=hm.get(2);
						break;
					}else {
						System.out.println("wrong input\n enter valid input");
					}
				}
				n--;
			}
			s=s+"(";
			int i=0;
			for(i=0;i<(k-1);i++) {
				s=s+" "+v[k-i-1]+" "+c[k-i-1]+",";
			}
//			System.out.println(i);
//			i--;
			s=s+" "+v[k-1-i]+" "+c[k-1-i]+")";
			//System.out.println(creating+s);
			PreparedStatement ps=con.prepareStatement(creating+s);
			ps.execute();
			System.out.println("table created successfully");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		// everything is same just dynamically we have to take value from and we have to check is it valid for statement creation or not if not valid then again take value and similarly read,update,drop operation can be done on table;
	}

}
