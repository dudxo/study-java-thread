package thread.start.test;

import static util.MyLogger.*;

public class CounterRunnableMainV1 {

	public static void main(String[] args) {
		log("main() start");
		CounterRunnable runnable = new CounterRunnable();
		// Thread thread = new Thread(runnable, "counter");  이 방식도 있다. 생성자를 살펴보자.
		Thread thread = new Thread(runnable);
		thread.setName("counter");
		thread.start();
		log("main() end");
	}

	static class CounterRunnable implements Runnable {

		@Override
		public void run() {
			for(int i = 1; i <= 5; i++) {
				log("value: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
