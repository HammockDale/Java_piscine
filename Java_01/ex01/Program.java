public class Program {
	public static void main(String[] args) {

		User user1 = new User("John", 10_000);
		User user2 = new User("Mike", 100_000);

		user1.setBalance(user1.getBalance() - 500);
		user2.setBalance(user2.getBalance() + 500);

		System.out.printf("%s %d\n", user1.getName(), user1.getBalance());
		System.out.printf("%s %d\n", user2.getName(), user2.getBalance());

		User user3 = new User("Паша", 10_000);
		User user4 = new User("Миша", 100_000);
		User user5 = new User("Сережа", -100_000);

		System.out.println(user1.getIdentifier());
		System.out.println(user4.getIdentifier());
		System.out.println(user5.getIdentifier());


	}
}
