package vikas.mypack;

class Counter {

	private int c = 0;

	 public void decrement() {
		System.out.println("Decrement Execution Starts..");
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				c--;	
			}
		}
		System.out.println("Decrement Execution Ends..");
	}

	public void increment() {
		System.out.println("Increment Execution Starts..");
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {
				c++;	
			}
		}
		System.out.println("Increment Execution Ends..");
	}

	public void displayCurrentval() {
		System.out.println("Current Value :: "+this.c);
	}
}

class Incremental extends Thread {

	private Counter c;

	Incremental(Counter c) {
		this.c = c;
	}

	public void run() {

		c.increment();

	}

}

class Decremental extends Thread {

	private Counter c;

	Decremental(Counter c) {
		this.c = c;
	}

	public void run() {
		
		//c.displayCurrentval();
		c.decrement();

	}

}

public class CounterDemo {

	public static void main(String[] args) throws InterruptedException {

		Counter count = new Counter();
		Incremental t1 = new Incremental(count);
		Decremental t2 = new Decremental(count);
		t2.setPriority(10);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		count.displayCurrentval();
		
	}

}
//There will be data inconsistency if more the one threads are operating on shared resources