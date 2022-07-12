public class TransactionsLinkedList implements TransactionsList{

	class TransactionNotFoundException extends RuntimeException{
		public TransactionNotFoundException(String message){
			super(message);
		}
	}

	public static class tranList{
		public Transaction trans;
		public tranList next;
		public tranList prev;

		public tranList()
		{
			this.trans = null;
			this.next = null;
			this.prev = null;
		}
	}

	private tranList lastTranList;
	private tranList firstTranList;
	private int count;


	public TransactionsLinkedList(){
		this.lastTranList = new tranList();
		this.firstTranList = this.lastTranList;
		this.count = 0;
	}

	@Override
	public void addTransaction(Transaction tran){
		if (this.count == 0) {
			this.lastTranList.trans = tran;
			this.firstTranList = this.lastTranList;
		}
		else {
			this.lastTranList.next = new tranList();
			this.lastTranList.next.trans = tran;
			this.lastTranList.next.prev = this.lastTranList;
			this.lastTranList = this.lastTranList.next;
		}
		this.count++;
	}

	@Override
	public void removeTransaction(String uid) throws TransactionNotFoundException {
		tranList tran = this.firstTranList;
		for (; count > 0 &&  tran != null; tran = tran.next) {
			if (tran.trans.getIdentifier().equals(uid))
			{
				if (tran.prev != null) {
					tran.prev.next = tran.next;
				}
				if (tran.next != null) {
					tran.next.prev = tran.prev;
				}
				this.firstTranList = tran;
				count--;
				return;
			}
		}
		throw new  TransactionNotFoundException("ID Transaction " + uid + " is not found");
	}

	@Override
	public Transaction[] toArray() {
		Transaction tranAr[] = new Transaction[this.count];
		tranList tran = this.firstTranList;
		for (int i = 0 ; i < count; i++, tran = tran.next ) {
			tranAr[i] = tran.trans;
		}
		return tranAr;

	}
}
