
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PrevAccrAmountApp {

	public static void main(String[] args) {
	
		PrevAccrAmount obj = new PrevAccrAmount();
		
		Date paymentDate;
		Date dueDate;
		double amount = 9000;
		
	
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		      String input = "11/05/2017"; 

		      System.out.print(input + " Parses as "); 
		      StringWriter out = new StringWriter();
		    
		      try {
		    	  paymentDate = (Date) dateformat3.parse("11/05/2017"); 
		        // System.out.println(t); 
		    	  dueDate = (Date) dateformat3.parse("09/08/2017"); 
		    	  System.out.print(input + " Parses awdawdawdawdas ");
		    	  System.out.print(obj.getPreviousAccrualamount(paymentDate, dueDate, amount));
		    	//  String json = out.toString(obj.getPreviousAccrualamount(paymentDate, dueDate, amount));		    	  
		    	//  System.out.println(json);
		      }
		      catch (Exception e) { 
		         System.out.println("Unparseable using " + e); 
		      }
	}
}
