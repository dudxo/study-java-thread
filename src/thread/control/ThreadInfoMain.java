package thread.control;

import static util.MyLogger.*;

import thread.start.HelloThread;

public class ThreadInfoMain {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		log("mainThread = " + mainThread);
		log("mainThread.threadId() = " + mainThread.threadId());
		log("mainThread.getName() = " + mainThread.getName());
		log("mainThread.getPriority() = " + mainThread.getPriority());
		log("mainThread.getT hreadGroup = " + mainThread.getThreadGroup( ));
		log("mainThread.getState() = " + mainThread.getState());

		// myThread
		Thread myThread = new Thread(new HelloThread(), "myThread");
		log("myThread = " + myThread);
		log("myThread.threadId() = " + myThread.threadId());
		log("myThread.getName() = " + myThread.getName());
		log("myThread.getPriority() = " + myThread.getPriority());
		log("myThread.getThreadGroup = " + myThread.getThreadGroup( ));
		log("myThread.getState() = " + myThread.getState());
	}
}
