public class Program {

	static class MyRunnableClass implements Runnable {
		private String str;
		private int count;
		private static String flag;

		public MyRunnableClass(String str, int count) {
			this.str = str;
			this.count = count;
		}

		@Override
		public void run() {
			for (int i = 0; i < count;i++) {
				try {
					synchronized (MyRunnableClass.class) {
						if (this.str == (flag)) {
							MyRunnableClass.class.wait();
						}
						System.out.println(str);
						flag = this.str;
						MyRunnableClass.class.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		if (args.length != 1 || args[0].startsWith("--count=") == false) {
			System.err.println("Wrong argument");
			return;
		}
		int count;
		try {
			count = Integer.parseInt(args[0].substring(8));
		} catch (Exception ex) {
			System.err.println("Incorret argument");
			return;
		}
			if (count <= 0) {
				System.err.println("Wrong argument");
				return;
			}
			Thread hen = new Thread(new Program.MyRunnableClass("Hen", count));
			Thread egg = new Thread(new Program.MyRunnableClass("Egg", count));
			hen.start();
			egg.start();

	}
}
