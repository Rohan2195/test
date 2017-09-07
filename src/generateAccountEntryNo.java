
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
			String myStringRepOfInt = String.format("%03d", No.initdrNo());
			AccountEntryNo=head+branch+"01"+myStringRepOfInt;
		}
		else if(d_c_a.equals(cr)){
			String myStringRepOfInt = String.format("%03d", No.initcrNo());
			AccountEntryNo=head+branch+"02"+myStringRepOfInt;
		}
		else if(d_c_a.equals(ar)){
			String myStringRepOfInt = String.format("%03d", No.initacrNo());
			AccountEntryNo=head+branch+"03"+myStringRepOfInt;
		}
		else if(d_c_a.equals(ir)){
			String myStringRepOfInt = String.format("%03d", No.initacrNo());
			AccountEntryNo=head+branch+"04"+myStringRepOfInt;
		}
		
		return AccountEntryNo;
	}
}
