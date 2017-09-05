import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;

public class PrevAccrAmount {

	
	public JSONObject getPreviousAccrualamount(Date paymentDate, Date dueDate,double amount){
		
		double x = calculateAccruedIncomePerDay(paymentDate,dueDate,amount);
		long noOfDays =((TimeUnit.MINUTES.convert(new java.util.Date().getTime() - paymentDate.getTime(),TimeUnit.MILLISECONDS))/(60*24));
       
		JSONObject obj = new JSONObject();
		
		String day="Day";
		String key="";
		double value;
		for(int i=1;i<=noOfDays;i++){
			key = day + Integer.toString(i);
			value = x*i;
			obj.put(key, Double.toString(value));	
		}
	      return obj;
	}
	
	public double calculateAccruedIncomePerDay(Date paymentDate,Date dueDate,double amount){
		long noOfDays =((TimeUnit.MINUTES.convert(dueDate.getTime() - paymentDate.getTime(),TimeUnit.MILLISECONDS))/(60*24));
		double AccruedIncomePerDay = amount/noOfDays;
		return AccruedIncomePerDay;
	}
}
