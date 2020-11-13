public class ThreadConfinementUsingThreadLocal {

	public static void main(String[] args) {

		ThreadLocal<String> valueHolder = new ThreadLocal<>();

		Runnable run1 = () -> {
			valueHolder.set("Runnable 1 - Set Value");
			try {
				Thread.sleep(5000);
				System.out.println("Runnable 1 - " + valueHolder.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};

		Runnable run2 = () -> {
			valueHolder.set("Runnable 2 - Set Value");
			try {
				Thread.sleep(2000);
				valueHolder.set("Runnable 2 - Changed Value");
				Thread.sleep(2000);
				System.out.println("Runnable 2 - " + valueHolder.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};

		Runnable run3 = () -> {
			valueHolder.set("Runnable 3 - Set Value");
			try {
				Thread.sleep(5000);
				System.out.println("Runnable 3 - " + valueHolder.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};

		new Thread(run1).start();
		new Thread(run2).start();
		new Thread(run3).start();
	}
}
