package thread.start.test;

import static util.MyLogger.*;

public class ManyThreadMain {

	public static void main(String[] args) {
		log("main() start");
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					log("A");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}, "Thread-A");
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					log("B");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}, "Thread-B");
		thread2.start();

		log("main() end");
	}
}
