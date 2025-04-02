package thread.start.test;

import static util.MyLogger.*;

public class CounterRunnableMainV2 {

	public static void main(String[] args) {
		log("main() start");
		Thread thread = new Thread(new Runnable() {
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
		}, "counter");
		thread.start();
		log("main() end");
	}

}
