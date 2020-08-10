package vikas.mypack;

import java.util.concurrent.CountDownLatch;

class Worker3 extends Thread {
	int delay;
	CountDownLatch latch;
	String name;

	Worker3(int delay, CountDownLatch latch, String name) {

		this.delay = delay;
		this.latch = latch;
		this.name = name;
	}

	public void run() {
		
		try {
			Thread.sleep(delay);
			latch.countDown();//
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread :: "+name+" :: Executed Task Successfully");
	}
}

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countLatch = new CountDownLatch(3);
		Worker3 t1=new Worker3(1000, countLatch, "Worker1");
		Worker3 t2=new Worker3(3000, countLatch, "Worker2");
		Worker3 t3=new Worker3(4000, countLatch, "Worker3");
		t1.start();
		t2.start();
		t3.start();
		
		countLatch.await();//will wait until other threads finishes their tasks.
		
		System.out.println("Main Thread Finished Its Work...");
		
	}

}
