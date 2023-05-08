public class Program {

	static class MyRunnableClass implements Runnable {
		private String str;
		private int count;

		public MyRunnableClass(String str, int count) {
			this.str = str;
			this.count = count;
		}

		@Override
		public void run() {
			for (int i = 0; i < count; i++) {
				try {
					Thread.sleep(100);
					System.out.println(str);
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
			if (count <= 0) {
				System.err.println("Wrong argument");
				return;
			}
			Thread hen = new Thread(new Program.MyRunnableClass("Hen", count));
			Thread egg = new Thread(new Program.MyRunnableClass("Egg", count));
			hen.start();
			egg.start();
			try {
				hen.join();
				egg.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < count; i++) {
				System.out.println("Human");
			}
		} catch (Exception ex) {
			System.err.println("Wrong argument");
			ex.printStackTrace();
		}


	}
}
