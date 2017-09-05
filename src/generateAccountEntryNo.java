
public class generateAccountEntryNo {
      private static long crNo;
      private static long drNo;
      private static long acrNo;
      
      public static long initcrNo(){
    	 if(crNo==0)
    		 crNo++;
    	 return crNo++;
      }
      public static long initdrNo(){
     	 if(drNo==0)
     		 drNo++;
     	 return drNo++;
       }
      public static long initacrNo(){
     	 if(acrNo==0)
     		 acrNo++;
     	 return acrNo++;
       }
      
      
	public String Generate(String head,String branch,String d_c_a,String swiftid){
		String cr ="Cr";
		String dr ="Dr";
		String ar ="Ar";
		
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
		
		return AccountEntryNo;
	}
}
