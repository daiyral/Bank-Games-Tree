package bank;
/*this class represents a bank account with two variables name and balance*/
public class Account {
private String name;
private int balance;
	/*account builder*/
	public Account(String name)
	{
		this.name= name;
		balance=0;
	}
	public int getShekels()
	{
		return balance;
	}
	public String getName()
	{
		return name;
	}
	public void add(int amount)
	{
		balance+=amount;
	}
	public String toString()
	{
		return name+" has "+balance+" shekels";
	}

}
