import java.util.UUID;

public class User {
	private Integer				identifier;
	private String				name;
	private long				balance;
	private TransactionsList	transactions;

	public Integer getIdentifier() {
		return identifier;
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
			this.balance = 0;
		}
		else
			this.balance = Balance;
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.transactions = new TransactionsLinkedList();
//		System.out.println(" this.identifier " + this.identifier);
	}
}
