package thread.sync.test;

public class Immutable {
	private final int value;  // 변경X 동시 접근 문제X !!!
	public Immutable(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
