public class VolatileVariables {

	private static int count;

	private static class ChangeListener extends Thread {

		@Override
		public void run() {
			int localValue = count;
			while (localValue < 5) {
				if (localValue != count) {
					System.out.println("Got change for \"count\": " + count);
					localValue = count;
				}
			}
		}
	}

	private static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int localValue = count;
			while (count < 5) {
				System.out.println("Incrementing \"count\" to " + (localValue + 1));
				count = ++localValue;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ChangeListener().start();
		new ChangeMaker().start();
	}
}
