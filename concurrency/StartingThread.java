package com.java.threads;

public class StartingThread {

	private static class EventListener {
		private Thread listener;
		private static volatile int threadNum;
		private static EventListener eventListener;

		private EventListener() {
			listener = new Thread(() -> {
				System.out.println("Thread number " + threadNum++ + " started");
			});
		}

		public static EventListener getInstance() {
			if (eventListener == null) {
				synchronized (EventListener.class) {
					if (eventListener == null) {
						eventListener = new EventListener();
						eventListener.listener.start();
					}
				}
			}
			return eventListener;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			EventListener.getInstance();
		}
	}

}
