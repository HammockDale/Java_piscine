
public class SumThread  implements Runnable {
	int from;
	int to;
	int[] sum;
	int[] randomArray;
	int threadsCount;
	Object lock;

	SumThread(int from, int to, int[] sum, int[] randomArray, int threadsCount, Object lock) {
		this.from = from;
		this.to = to;
		this.sum = sum;
		this.randomArray = randomArray;
		this.threadsCount = threadsCount;
		this.lock = lock;
	}

	@Override
	public void run() {
		int startSum = this.sum[0];
		int startFrom = this.from;
		for (; this.from < this.to; this.from++) {
			synchronized (lock) {
				this.sum[0] += this.randomArray[this.from];
			}
		}
		System.out.print("Thread " + (this.threadsCount + 1) + " from " + startFrom);
		if (this.to != (this.randomArray.length - 1)) {
			System.out.println(" to " + (this.to - 1) + " sum is " + (this.sum[0] - startSum));
		} else {
			System.out.println(" to " + (this.to) + " sum is " + (this.sum[0] - startSum));
		}
	}
}