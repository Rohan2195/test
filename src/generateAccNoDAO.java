import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class generateAccNoDAO {

public Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		System.out.println("connected to Oracle Db");
		
		return con;
		
	}

 public void createGlEntry(){
	 generateAccNoDAO dbobj = new generateAccNoDAO();
		List<String> swiftList=new LinkedList<String>();
		try {
			Connection con = dbobj.getConnection();
			Statement statement = con.createStatement();  
			System.out.println("In getCOAswiftList - After create statement");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM TranctionTable");// TranctionTable--> dumm<!-- -->		
			 
			while(resultSet.next())
			{
				swiftList.add(resultSet.getString("productSwiftId"));
			}
			generateAccountEntryNo ACCNo = new generateAccountEntryNo();
			String accENo =ACCNo.Generate(resultSet.getString("head"),resultSet.getString("branch"),resultSet.getString("Dr_Cr"), resultSet.getString("productSwiftId"));
			ResultSet resultSet1 = statement.executeQuery("insert into general_ledger values('"+accENo+"',null,'"+resultSet.getString("tranction_date")+"','"+resultSet.getString("tranction_id")+"','"+resultSet.getString("Customer_acc_no")+"','"+resultSet.getString("invoice_No")+"','"+resultSet.getString("DR_CR")+"','"+resultSet.getDouble("Amount")+"','"+resultSet.getString("due_Date")+"','"+resultSet.getString("productSwiftId")+"',");
			
			if(resultSet.getString("Dr_Cr").equals("Dr")){
				
			String accENo1 = ACCNo.Generate(resultSet.getString("head"),resultSet.getString("branch"),"Ar", resultSet.getString("productSwiftId"));
			
			resultSet1 = statement.executeQuery("insert into general_ledger values('"+accENo1+"',null,null,null,'"+resultSet.getString("Customer_acc_no")+"','"+resultSet.getString("invoice_No")+"','CR',null,'"+resultSet.getString("due_Date")+"','"+resultSet.getString("productSwiftId")+"'");
			
			accENo1 = ACCNo.Generate(resultSet.getString("head"),resultSet.getString("branch"),"Ir", resultSet.getString("productSwiftId"));
			
			resultSet1 = statement.executeQuery("insert into general_ledger values('"+accENo1+"',null,null,null,'"+resultSet.getString("Customer_acc_no")+"','"+resultSet.getString("invoice_No")+"','DR',null,'"+resultSet.getString("due_Date")+"','"+resultSet.getString("productSwiftId")+"'");
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
 }

