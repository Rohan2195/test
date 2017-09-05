
public class generateAccountEntryNo {
      private static long crNo;
      private static long drNo;
      private static long acrNo;
      private static long iRNo;
      
      public static long initcrNo(){
    	 return crNo++;
      }
      public static long initdrNo(){
     	 return drNo++;
       }
      public static long initacrNo(){
     	 return acrNo++;
       }
      
      public static long initirNo(){
     	 return iRNo++;
       }
      
      
	public String Generate(String head,String branch,String d_c_a,String swiftid){
		String cr ="Cr";
		String dr ="Dr";
		String ar ="Ar";
		String ir ="Ir";
		
		generateAccountEntryNo No = new generateAccountEntryNo();
		String AccountEntryNo ="";
		
		if(d_c_a.equals(dr)){
			AccountEntryNo=head+branch+"01"+Long.toString(No.initdrNo());
		}
		else if(d_c_a.equals(cr)){
			AccountEntryNo=head+branch+"02"+Long.toString(No.initcrNo());
		}
		else if(d_c_a.equals(ar)){
			AccountEntryNo=head+branch+"03"+Long.toString(No.initacrNo());
		}
		else if(d_c_a.equals(ir)){
			AccountEntryNo=head+branch+"04"+Long.toString(No.initirNo());
		}
		
		return AccountEntryNo;
	}
}
