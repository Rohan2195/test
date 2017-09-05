
public class test {
	private double x;
	public void print(){
		if(this.x==0)
			System.out.println("Its 0");
		else 
			System.out.println("its not zero");
	}
	
	public static void main(String[] args) {
		test z =new test();
    z.print();
    
    generateAccountEntryNo obj = new generateAccountEntryNo();
   String a1 = obj.Generate("RBS", "LND","Dr","xyz");
   String a2 = obj.Generate("RBS", "LND","Dr","xyz");
   String a3 = obj.Generate("RBS", "LND","Dr","xyz");
   String a4 = obj.Generate("RBS", "LND","Cr","xyz");
   System.out.println(a1+a2+a3+a4);
	}
	


}
