import java.util.UUID;

public class User {
	private int		identifier;
	private String	name;
	private long	balance;

	public int getIdentifier() {
		return identifier;
	}
//
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String Name, long Balance)
	{
		this.name = Name;
		if (Balance < 0)
		{
			System.out.println("Wrong balance. New " + Name + " balance = 0");
			this.balance = 0;
		}
		else
			this.balance = Balance;
	}
}
