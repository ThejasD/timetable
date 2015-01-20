package in.bmsce.timetable;
import java.sql.*;
public class Table {

	public static void main(String[] args) {
		String subj[]=new String[15];
		String teach[]=new String[6];
		subj[0]="Free";
		String days[]=new String[6];
		days[0]="monday";
		days[1]="tuesday";
		days[2]="wednesday";
		days[3]="thursday";
		days[4]="friday";
		days[5]="saturday";
		
		Faculty te[]=new Faculty[6];
		for(int i=0;i<6;i++)
			te[i]=new Faculty();
		TermSubject su[]=new TermSubject[6];
		TermSubject spc[]=new TermSubject[7];
		su[0]=new TermSubject(0,0,1);
		spc[0]=new TermSubject(0,0,1);
		try{    
			Class.forName("oracle.jdbc.driver.OracleDriver"); 			
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","hr","hr"); 			
			 Statement stmt=con.createStatement();  			
			ResultSet rs=stmt.executeQuery("select * from section1");
			int i=1;
			while(rs.next())  
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			{
			
				su[i]=new TermSubject(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				i++;
			}
		    rs=stmt.executeQuery("select * from section2");
		    i=1;
			while(rs.next())  
			//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			{
				spc[i]=new TermSubject(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				i++;
			}
			rs=stmt.executeQuery("select * from subject");
			while(rs.next())
			subj[rs.getInt(1)]=rs.getString(2);
			rs=stmt.executeQuery("select * from faculty");
			while(rs.next())
				teach[rs.getInt(1)]=rs.getString(2);
			//step5 close the connection object  
			con.close();   
			}catch(Exception e){ System.out.println(e);}
		sec se[]=new sec[2];
		se[0]=new sec(su);
		se[1]=new sec(spc);
		ttble ttbl=new ttble(se,te);
		System.out.println(ttbl.ttb(0, 0, 0));
		String kk[]=new String[se.length+1];
		kk[0]="A";
		kk[1]="B";
		kk[2]="FREE";
		for(int k=0;k<se.length;k++)
		{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(se[k]._timetable[i][j]==-1)se[k]._timetable[i][j]=0;
			}
		}
		}
		for(int k=1;k<te.length;k++)
		{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(te[k]._timetable[i][j]==-1)te[k]._timetable[i][j]=se.length;
			}
		}
		}
		
		try{    
			Class.forName("oracle.jdbc.driver.OracleDriver"); 			
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","hr","hr"); 			
			 Statement stmt=con.createStatement();
			 for(int k=0;k<se.length;k++)
			 {
				 String sq="delete sec"+kk[k];
				 stmt.executeQuery(sq);
			 for(int i=0;i<5;i++)
			 {
			 String sql = "insert into sec"+kk[k]+" values ("+"'"+ days[i] + "'," +"'"+ subj[se[k]._timetable[i][0]] + "'," +"'"+ subj[se[k]._timetable[i][1]] + "'," + "'"+subj[se[k]._timetable[i][2]] + "'," + "'"+subj[se[k]._timetable[i][3]] + "'," +"'"+ subj[se[k]._timetable[i][4]] + "'," +"'"+ subj[se[k]._timetable[i][5]] + "'," +"'"+ subj[se[k]._timetable[i][6]] + "'" +")";
			 stmt.executeUpdate(sql);
			 }
			 }
			 for(int k=1;k<teach.length;k++)
			 {
				 String sq="delete "+teach[k];
				 stmt.executeQuery(sq);
			 for(int i=0;i<5;i++)
			 {
			 String sql = "insert into "+teach[k]+" values ("+"'"+ days[i] + "'," +"'"+ kk[te[k]._timetable[i][0]] + "'," +"'"+ kk[te[k]._timetable[i][1]] + "'," + "'"+kk[te[k]._timetable[i][2]] + "'," + "'"+kk[te[k]._timetable[i][3]] + "'," +"'"+ kk[te[k]._timetable[i][4]] + "'," +"'"+ kk[te[k]._timetable[i][5]] + "'," +"'"+ kk[te[k]._timetable[i][6]] + "'" +")";
			 stmt.executeUpdate(sql);
			 }
			 }
			 con.close();   
		}catch(Exception e){ System.out.println(e);}
		
	}

}
