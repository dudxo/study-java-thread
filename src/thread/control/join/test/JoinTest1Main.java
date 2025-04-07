package thread.control.join.test;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinTest1Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyTask(), "t1");
		Thread t2 = new Thread(new MyTask(), "t2");
		Thread t3 = new Thread(new MyTask(), "t3");

		t1.start();
		t1.join(); // main thread t1이 끝날 때까지 대기

		t2.start(); // t1 끝나고 t2 실행
		t2.join(); // main thread t2이 끝날 때까지 대기

		t3.start(); // t2 끝나고 t3 실행
		t3.join(); // main thread t3이 끝날 때까지 대기
		//3초씩 * 3개 스레드 = 총 9초
		System.out.println("모든 스레드 실행 완료");
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			for(int i = 1; i <= 3; i++) {
				log(i);
				sleep(1000);
			}
		}
	}
}
