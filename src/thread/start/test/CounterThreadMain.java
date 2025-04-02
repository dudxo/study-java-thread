package thread.start.test;

import static util.MyLogger.*;

public class CounterThreadMain {

	public static void main(String[] args) {
		log("main() start");
		CounterThread thread = new CounterThread();
		thread.run();
		log("main() end");
	}
}
