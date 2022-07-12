import java.util.UUID;

public class Transaction {
	enum OpType{
		DEBITS,
		CREDITS
	}

	private String	identifier;
	private User	recipient;
	private User	sender;

	public OpType	transferCategory;
	private long	amount;

	public OpType getTransferCategory() {
		return this.transferCategory;
	}

	public void setTransferCategory(OpType transferCategory) {
		this.transferCategory = transferCategory;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Transaction(User Sender, User Recipient, long Amount)
	{
		this.identifier = UUID.randomUUID().toString();
		this.recipient = Recipient;
		this.sender = Sender;
		this.amount = Amount;
		if (Amount >= 0) {
			this.transferCategory = OpType.DEBITS ;
		} else
			this.transferCategory = OpType.CREDITS;
	}
}
