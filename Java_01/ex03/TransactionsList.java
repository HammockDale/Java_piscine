public interface TransactionsList {

	public void addTransaction(Transaction tran);
	public void removeTransaction(String uid);
	public Transaction[] toArray();
}
