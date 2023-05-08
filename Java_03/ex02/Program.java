
public class Program {
	private static int size = 21;
	private static int threadsCount = 3;

	private static void parseArgs(String[] args) {
		try {
			if (args[0].startsWith("--arraySize=")) {
				size = Integer.parseInt(args[0].substring(12));
			} else {
				System.err.println("Invalid argument specified, setting arraySize to default (21)");
				size = 21;
			}
		} catch (Exception ex) {
			System.err.println("Invalid argument specified, setting arraySize to default (21)");
			size = 21;
		}
		try {
			if (args[1].startsWith("--threadsCount=")) {
				threadsCount = Integer.parseInt(args[1].substring(15));
			} else {
				System.err.println("Invalid argument specified, setting threadsCount to default (3)");
				threadsCount = 3;
			}
		} catch (Exception ex) {
			System.err.println("Invalid argument specified, setting threadsCount to default (3)");
			threadsCount = 3;
		}

		if (threadsCount > size || threadsCount <= 1 || size <= 0) {
			System.err.println("Invalid argument. The count of threads is greater than the size of the array.");
			System.err.println("setting threadsCount to default (3), setting arraySize to default (21)");
			threadsCount = 3;
			size = 21;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		int[] sum = new int[1];
		int sectionSize = 0;
		int sumArrayElements = 0;
		int[] randomArray;
		Object lock = new Object();

		parseArgs(args);
		randomArray = new int[size];
		for (int i = 0; i < size; i++)
		{
			randomArray[i] = (int) Math.round((Math.random() * 2000) - 1000);
			sumArrayElements += randomArray[i];
		}
		System.out.println("Sum: " + sumArrayElements);

		sectionSize = (size / (threadsCount - 1));

		for (int i = 0; i < (threadsCount); i++)
		{
			int from = i * sectionSize;
			int to = (i + 1) * sectionSize;

			if (i == (threadsCount - 1)) {
				to = size;
			}
			Thread sumThread = new Thread(new SumThread(from, to, sum, randomArray, i, lock));
			try {
				sumThread.start();
				sumThread.join();
			} catch (InterruptedException e) {
				System.err.println(e.getStackTrace());
				System.exit(1);
			}
		}
		System.out.println("Sum by threads: " + sum[0]);
	}
}