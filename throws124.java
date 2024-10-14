package naveen;
 class naveen extends Exception
 {
	 naveen(String m)
	 {
		super(m); 
	 }
	 
 }
public class throws124 {
	void withdraw(int amount) throws naveen
	{
		if(amount<=0)
		{
			throw new naveen("amount is not valid");
		}
		else {
			throw new naveen("amount is valid");
		}
	}

	public static void main(String[] args) {
		throws124 obj =new throws124();
try {
	obj.withdraw(10000000);
}
catch(Exception e)
{
System.out.println(e);
{
	
}

}
	}
}
