public class NoVisibility {

	private static boolean isRunning;
	private static int number;

	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			while (!isRunning)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new ReaderThread().start();
		isRunning = true;
		number = 42;
		
	}
}
