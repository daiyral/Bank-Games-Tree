package bank;
/*this class represent a pro account which is an account with an addition of balance history*/
public class ProAccount extends Account {
	private int[] balanceHistory;
	private int i;
	/*pro account builder*/
	public ProAccount(String name) {
		super(name);//using account builder
		balanceHistory=new int[100];
		i=0;
	}
	@Override
	public void add(int amount)
	{
		super.add(amount);
		balanceHistory[i]=this.getShekels();
		i++;
	}
	@Override
	public String toString()
	{
		int j;
		String s="";
		s+=super.toString()+" [";
		for (j=0;j<i-1;j++)
		{
			s+=balanceHistory[j] +",";
		}
		
		s+=balanceHistory[j];
		s+="]";
		return s;
	}
	/*this func gets two pro accounts and transfer funds between them*/
	public static void transfer(ProAccount from, ProAccount to, int amount)
	{
		from.add(-amount);
		to.add(amount);
	}

}
