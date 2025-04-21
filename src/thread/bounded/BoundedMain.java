package thread.bounded;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain {

	public static void main(String[] args) {
		// 1. BoundedQueue 선택
		// BoundedQueue queue = new BoundedQueueV1(2);
		// BoundedQueue queue = new BoundedQueueV2(2);
		BoundedQueue queue = new BoundedQueueV3(2);

		// 2. 생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
		// producerFirst(queue);  // 생산자 먼저 실행
		consumerFirst(queue);  // 소비자 먼저 실행

		// notify() 는 비효율과 스레드 기아 문제가 발생한다..
		// 비효율 - 생산자가 생산자를 깨우거나, 소비자가 소비자를 깨우는 경우, 이는 비효율이지 문제는 아님!
		// 스레드 기아 - 어떤 스레드가 깨워질지 모르기 때문에 어떤 스레드가 꺠워지지 않는 기아 문제가 발생
		// notifyAll()을 통해 모든 스레드를 깨워 스레드 기아를 해결할 수 있다. 단, 비효율은 여전히 존재한다..
	}

	private static void producerFirst(BoundedQueue queue) {
		log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
		List<Thread> threads = new ArrayList<>();
		startProducer(queue, threads);
		printAllState(queue, threads);
		startConsumber(queue, threads);
		printAllState(queue, threads);
		log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
	}

	private static void consumerFirst(BoundedQueue queue) {
		log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + " ==");
		List<Thread> threads = new ArrayList<>();
		startConsumber(queue, threads);
		printAllState(queue, threads);
		startProducer(queue, threads);
		printAllState(queue, threads);
		log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + " ==");
	}

	private static void startProducer(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("생산자 시작");
		for (int i = 1; i <= 3; i++) {
			Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
			threads.add(producer);
			producer.start();
			sleep(100);
		}
	}

	private static void startConsumber(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("소비자 시작");
		for (int i = 1; i <= 3; i++) {
			Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
			threads.add(consumer);
			consumer.start();
			sleep(100);
		}
	}

	private static void printAllState(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("현재 상태 출력, 큐 데이터: " + queue);
		for(Thread thread : threads) {
			log(thread.getName() + ": " + thread.getState());
		}
	}
}
